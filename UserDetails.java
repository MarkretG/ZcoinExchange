import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserDetails extends ZCoinExchangeSystem {
    static Scanner sc=new Scanner(System.in);
    public static String setPassword(String name,String mail)
    {
        String password="";
        while (!Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$&\\*\\*.><]).{8,15}",password))
        {
            System.out.println("password must have contains 8 to 15 character.password must have one uppercase and one lowercase and numbers.\nEnter password");
            password=sc.nextLine();
        }
        return password;
    }
    public static void getUserDetails(String mail)
    {
        System.out.println("enter the zid");
        int zid= sc.nextInt();
        if (account.get(mail).getZId()==zid)
            System.out.println("Rc balance:"+account.get(mail).getRc()+"zCoin balance:"+account.get(mail).getZCoin());
        else
            System.out.println("invalid Zid");

    }
    public static void rcTransaction(String mail)
    {
        System.out.println("1.deposit\n2.withdrawl\n3.Rc tozCoin transaction");
        int res=sc.nextInt();
        if (res==1)
        {
            System.out.println("enter the deposit amount");
            account.get(mail).depositRc(sc.nextInt());
        }
        else if(res==2)
        {
            System.out.println("enter withdrawl amount");
            int withDrawl=sc.nextInt();
            if(withDrawl>account.get(mail).getRc())
                System.out.println("insufficient balance");
            else
                account.get(mail).withDrawlRc(withDrawl);
        }
        else if(res==3)
        {
            System.out.println("enter rc to zcoin");
            account.get(mail).convertRcToZCoin(sc.nextInt());
        }
    }
    public static void zCoinTransaction(String mail)
    {

        System.out.println("1.zCoin transaction\n2.zCoin to rc");
        int decision=sc.nextInt();
        if(decision==1)
        {
            System.out.println("enter the zid to transfer the amount");
            int zid=sc.nextInt();
            if (zIdAccount.containsKey(zid))
            {
                System.out.println("enter the amount to transfer");
                int amount=sc.nextInt();
                if(account.get(mail).getZCoin()>amount)
                {
                    account.get(mail).transferZCoin(amount);
                    zIdAccount.get(account.get(mail).getZId()).transferZCoin(amount);
                    zIdAccount.get(zid).receiveZCoin(amount);
                    account.get(zIdAccount.get(zid).getMail()).receiveZCoin(amount);
                }
                else
                    System.out.println("ZCoin not enough");
            }
        }
        else if(decision==2)
        {
            System.out.println("enter the amount to convert zcoin to rc for withdrawl");
            account.get(mail).convertZCoinToRc(sc.nextInt());
        }
    }

    public static void transactionHistory(String mail)
    {
        System.out.println("1.Rc transaction\n2.zCoin transaction");
        int t=sc.nextInt();
        if(t==1)
        {
            ArrayList<String> transactionHistory=new ArrayList<String>(account.get(mail).getRcTransactionHistory());
            for (String str:transactionHistory)
                System.out.println(str);
        }
        else if(t==1)
        {
            ArrayList<String> transactionHistory=new ArrayList<String>(account.get(mail).getZCoinTransactionHistory());
            for (String str:transactionHistory)
                System.out.println(str);
        }
    }

}

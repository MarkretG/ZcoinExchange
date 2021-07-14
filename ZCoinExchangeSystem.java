 import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class ZCoinExchangeSystem {
    static Scanner sc=new Scanner(System.in);
    static HashMap<String,AccountDetails> account=new HashMap<String, AccountDetails>();
    static HashMap<String,AccountDetails> zEmployee=new HashMap<String, AccountDetails>();
    static HashMap<Integer,AccountDetails> zIdAccount=new HashMap<Integer, AccountDetails>();
    public static void main(String[] args) {
        ArrayList<String> users = new ArrayList<String>();
        System.out.println("welcome to zCoin exchange");
        String email = "markret@gmail.com";
        AccountDetails ZE1 = new AccountDetails();
        ZE1.setDetails("markret", 1234, "Mark@123");
        zEmployee.put(email, ZE1);
        AccountDetails ZE2 = new AccountDetails();
        ZE2.setDetails("vino", 4567, "Vino@465");
        zEmployee.put(email, ZE2);
        System.out.println("1.signup" + "\n" + "2.login" + "\n" + "Exit");
        while (true) {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter mail id");
                    sc.nextLine();
                    String mail = sc.nextLine();
                    account.put(mail, new AccountDetails().customerDetails(mail));
                    users.add(mail);
                    break;
                case 2:
                    System.out.println("1.Agent login" + "\n" + "2.User login");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        mail = Login.verifyLogin(zEmployee);
                        System.out.println("1.ZId given\n2.change conversion rate");
                        int a = sc.nextInt();
                        if (a == 1) {
                            EmployeePanel.idGiven(users);
                            users.clear();

                        } else if (a == 2) {
                            account.get(mail).changeRate();

                        }
                    } else if (choice == 2) {
                        mail = Login.verifyLogin(account);
                        if(account.get(mail).getZId()!=0)
                        {
                            int accountUser=0;
                            while (accountUser!=6)
                            {
                                System.out.println("1.Account details\n2.Transaction history of user\n3.change password\n4.Rc transaction\n 5.Zcoin transaction\n6.exit");
                                int user=sc.nextInt();
                                switch (user)
                                {
                                    case 1:
                                        UserDetails.getUserDetails(mail);
                                        break;
                                    case 2:
                                        UserDetails.transactionHistory(mail);
                                        break;
                                    case 3:
                                        account.get(mail).changePassword(UserDetails.setPassword(account.get(mail).getName(),mail));
                                        break;
                                    case 4:
                                        UserDetails.rcTransaction(mail);
                                        break;
                                    case 5:
                                        UserDetails.zCoinTransaction(mail);
                                        break;
                                }

                            }
                        }
                    }

                case 3:
                    System.exit(0);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePanel extends ZCoinExchangeSystem {
    static Scanner sc=new Scanner(System.in);
    public  static void idGiven(ArrayList<String> check)
    {
        for (String mailId:check)
        {
            System.out.println(account.get(mailId).getName()+" "+account.get(mailId).getMail());
            System.out.println("1.Accept\n2.Reject");
            int choice= sc.nextInt();
            if (choice == 1)
            {
                System.out.println("enter the zid");
                zIdAccount.put(sc.nextInt(),account.get(mailId));
            }
            else if(choice==2)
            {
                account.remove(mailId);
            }

        }
    }
}

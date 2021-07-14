import java.util.HashMap;
import java.util.Scanner;
public class Login {
    static Scanner sc = new Scanner(System.in);

    public static String verifyLogin(HashMap<String, AccountDetails> check) {
        System.out.println("enter mail id");
        String mail = sc.nextLine();
        boolean end = true;
        while (true) {
            if (check.containsKey(mail))
            {
                System.out.println("enter your password");
                String pass = sc.nextLine();
                if (check.get(mail).getPassword().equals(pass))
                {
                    if (check.get(mail).getZId() != 0)
                        end = false;
                    else
                        System.out.println("account is waiting list");
                    break;
                }
                else {
                    System.out.println("Invalid password");
                    System.out.println("enter mail id");
                    mail = sc.nextLine();
                }
            }
            else
                {
                System.out.println("enter correct mail id");
                mail = sc.nextLine();
            }
            if (!check.containsKey(mail)) {
                end = false;
                break;
            }
            System.out.println("now you are logged in");
            return mail;
        }
        return mail;
    }
}

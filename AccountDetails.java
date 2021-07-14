import java.util.ArrayList;
import java.util.Scanner;
public class AccountDetails {
    static Scanner sc=new Scanner(System.in);
    String name,password,mail;
    int ZId,rc,ZCoin;
    long mobileNo;
    static float conversionRate=2f,commission;
    ArrayList<String> rcTransactionHistory=new ArrayList<String>();
    ArrayList<String> ZCoinTransactionHistory=new ArrayList<String>();
    public void setDetails(String name, int ZId, String password)
    {
        this.name=name;
        this.ZId=ZId;
        this.password=password;

    }
    public AccountDetails customerDetails(String mail)
    {
        System.out.println("enter name");
        this.name=sc.nextLine();
        System.out.println("set password");
        this.password=UserDetails.setPassword(name,mail);
        this.mail=mail;
        System.out.println("enter mobile no");
        this.mobileNo= sc.nextLong();
        System.out.println("enter real currency");
        int rc=sc.nextInt();
        sc.nextLine();
        return this;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getZId() {
        return ZId;
    }

    public void setZId(int ZId) {
        this.ZId = ZId;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public int getZCoin() {
        return ZCoin;
    }

    public void setZCoin(int ZCoin) {
        this.ZCoin = ZCoin;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getRcTransactionHistory() {
        return rcTransactionHistory;
    }
    public ArrayList<String> getZCoinTransactionHistory() {
        return ZCoinTransactionHistory;
    }

    public void setZCoinTransactionHistory(ArrayList<String> ZCoinTransactionHistory) {
        this.ZCoinTransactionHistory = ZCoinTransactionHistory;
    }

    public void changeRate()
    {
        System.out.println("enter the conversion rate rc to zcoin");
        conversionRate=sc.nextFloat();
    }
    public void depositRc(int amount)
    {
        rc+=amount;
        rcTransactionHistory.add("deposit amount"+amount+"amount balance"+rc);
    }
    public void withDrawlRc(int amount)
    {
        rc-=amount;
        rcTransactionHistory.add("withDrawl amount"+amount+"amount balance"+rc);
    }
    public void convertRcToZCoin(int amount)
    {
      ZCoin+=(int)(amount*conversionRate);
      rc-=amount;
    }
    public void convertZCoinToRc(int amount)
    {
        commission+=(amount/conversionRate)*0.15f;
        rc+=(int)((amount/conversionRate)-(amount/conversionRate)*0.15f);
        ZCoin-=amount;
    }
    public void transferZCoin(int amount)
    {
        ZCoin-=amount;
    }
    public void receiveZCoin(int amount)
    {
        ZCoin+=amount;
    }
    public void changePassword(String password)
    {
        this.password=password;
    }


}

import AccountPackage.Account;

public class AccountDemo {    
    public static void main(String[] args) {
        try{
            Account[] account=new Account[5];
            account[0] = new Account(1,1,"SA",1000);
            account[1] = new Account(2,2,"CA",1000);
            account[2] = new Account(3,1,"SA",1000);
            account[3] = new Account(4,2,"CA",1000);
            account[4] = new Account(5,3,"SA",1000);
            double d=AccountDemo.depositeIntrest(account[0],10.0);
            System.out.println(d);
        //     Account[] acc = AccountDemo.getAccountForSpecificCustomer(account[5],2);
        //     for(Account a:account){
        //         System.out.println(a.getAccountId()); 
        //     }
        }
        catch(Exception e){
        System.out.println(e);
        }
    }
    public static double depositeIntrest(Account account,Double intrestPercentage){
        double updatedBalance;
        updatedBalance =  (account.getAccountBalance())+(account.getAccountBalance()/intrestPercentage);
        return updatedBalance;
    }

    // public static Account getAccountForSpecificCustomer(Account account,int Customer){
    //     if(account.getAccountId() == Customer){
    //         return account.getAccountId();
    //     }    
    //     return account;
    // }
}

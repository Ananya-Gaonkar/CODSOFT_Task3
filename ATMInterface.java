// 1.Create a class to represent the ATM machine.
// 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
// checking the balance.
// 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
// checkBalance().
// 4. Create a class to represent the user's bank account, which stores the account balance.
// 5. Connect the ATM class with the user's bank account class to access and modify the account
// balance.
// 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
// 7. Display appropriate messages to the user based on their chosen options and the success or failure
// of their transactions.
import java.util.Scanner;
class BankAccount{
    double CurrentBalance;
    BankAccount(double CurrentBalance){
        this.CurrentBalance=CurrentBalance;
    }
    double getBalance(){
        return CurrentBalance;
    }
    public int withdraw(double amount){
        if(amount>0 && amount<=CurrentBalance){
            CurrentBalance-=amount;
            return 1;
        }
        else{
            System.out.println("Invalid withdrwal amount");
            return -1;
        }
    }
    public void  deposite(double amount){
        if(amount>0){
            CurrentBalance+=amount;

        }else{
            System.out.println("Invalid  amount");
        }
    }

}
class ATM{
    BankAccount account;
    ATM(BankAccount account){
        this.account=account;
    }

    void ATM_Menu(){
        System.out.println();
        System.out.println();
        System.out.println("Welcome to ATM");
        System.out.println("1.Withdraw\n2.Deposite\n3.Check Balance\n4.Exit");
        System.out.println("Enter your choice");
    }
    void withdraw(double amount){
        if(account.withdraw(amount)==1){
            System.out.println("Succesfully withdrawn "+amount+" .Rs");
        }else{
            System.out.println("Insufficient Balance");
        }    
    }
    void deposite(double amount){
        if(amount>0){
        account.deposite(amount);
        System.out.println("Successfully deposited "+amount+" .Rs");
        }
    }
    void CheckBalance(){
        System.out.println("Your Balance is :"+account.getBalance());
    }
}

public class ATMInterface{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        //Creating a bank account 
        BankAccount userAccount = new BankAccount(50000);
        //creating the object of ATM class
        ATM atm = new ATM(userAccount);
        boolean exit =false;
        while(!exit){
            atm.ATM_Menu();

            int choice=sc.nextInt();
            switch (choice) {
                case 1:System.out.println("Enter the amount to withdraw");
                       double withdrawAmount = sc.nextInt();
                       atm.withdraw(withdrawAmount);
                       break;
                case 2:System.out.println("Enter the amount to deposite");
                       double depositeAmount = sc.nextInt();
                       atm.deposite(depositeAmount);
                       break;
                case 3:atm.CheckBalance();
                       break;
                case 4:exit=true;
                       break;
                default:System.out.println("Invalid choice");
                        break;
            }

        } 
        sc.close();
    }
}
import java.util.ArrayList;
import java.util.List;

class BankAccount{
int accountNo;
String accountHolderName;
double balance;
String accountType;
List<Transaction> transactions;

    public BankAccount(int accountNo, String accountHolderName, double balance, String accountType){
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double money){
        balance+=money;
        transactions.add(new Transaction(this, "deposit", money));
        System.out.println();
        System.out.println(balance + " amount Deposited Successfully");
    }

    public void withdraw(double money){
        if(balance>=money){
            balance-=money;
            transactions.add(new Transaction(this, "withdraw", money));
            System.out.println(money + " amount Withdrawn Successfully");
            System.out.println();
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    public double getBalance(){
        return balance;
    }

    public void transactionDetails(){
        System.out.println("Account Number : " + accountNo);
        for(Transaction t : transactions){
            System.out.println("Transaction ID : " + t.transactionId + " Transaction Type : " + t.transactionType + " Amount : " + t.amount);
            System.out.println();
        }
    }
}

class Customer{
    int custId;
    String custName;
    List<BankAccount> accounts;

    public Customer(int custId, String custName){
        this.custId=custId;
        this.custName=custName;
        this.accounts=new ArrayList<>();
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
    }
}

class Transaction{
    int transactionId;
    BankAccount account;
    String transactionType;
    double amount;
    int counter=1;

    public Transaction(BankAccount account, String transactionType, double amount){
        this.transactionId=counter++;
        this.account=account;
        this.transactionType=transactionType;
        this.amount=amount;
    }

    public void executeTransaction(){
        if(transactionType.equals("deposit")){
            account.deposit(amount);
        }
        else if(transactionType.equals("withdraw")){
            account.withdraw(amount);
        }
        else{
            System.out.println("Invalid Transaction Type");
        }
    }
}

public class BankTransaction{
    public static void main(String[] args){

        Customer customer=new Customer(1,"Divya");

        BankAccount account1=new BankAccount(101,"Divya",1000,"Savings");
        BankAccount account2=new BankAccount(102,"Divya",2000,"Current");

        customer.addAccount(account1);
        customer.addAccount(account2);

        Transaction transaction1=new Transaction(account1,"deposit",500);
        Transaction transaction2=new Transaction(account2,"withdraw",1000);

        transaction1.executeTransaction();
        transaction2.executeTransaction();

        account1.transactionDetails();
        account2.transactionDetails();

        System.out.println("Avalaiable Account 1 Balance: "+account1.getBalance());
        System.out.println("Avalaiable Account 2 Balance: "+account2.getBalance());
    }
}


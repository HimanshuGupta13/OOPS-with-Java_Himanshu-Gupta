import java.io.*;
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}
class BankAccount{
    int accountNumber;
    String holderName;
    double balance;
    BankAccount(int accountNumber,String holderName,double balance){
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=balance;
    }
    void deposit(double amount){
        balance = balance + amount;
    }
    void withdraw(double amount) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance = balance - amount;
    }
}
class TransactionLogger{
    void writeTransaction(int acc,String type,double amount){
        try{
            FileWriter file = new FileWriter("transactions.txt",true);
            file.write(acc + " | " + type + " | " + amount + "\n");
            file.close();
        }
        catch(IOException e){
            System.out.println("File writing error");
        }
    }
}
public class Main{

    public static void main(String[] args){

        BankAccount acc = new BankAccount(420,"Himanshu Gupta",1000);
        TransactionLogger t = new TransactionLogger();

        try{
            acc.deposit(1234);
            t.writeTransaction(acc.accountNumber,"DEPOSIT",1234);
            acc.withdraw(230);
            t.writeTransaction(acc.accountNumber,"WITHDRAW",2300);
            acc.withdraw(7340);
            t.writeTransaction(acc.accountNumber,"WITHDRAW",7340);

        }
        catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Error");
        }
        System.out.println("Final Balance: " + acc.balance);
    }
}
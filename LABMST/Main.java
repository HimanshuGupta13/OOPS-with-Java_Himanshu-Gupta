import java.io.*;
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String msg){
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
        balance=balance+amount;
    }
    void withdraw(double amount) throws InsufficientBalanceException{
        if(amount>balance){
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance=balance-amount;
    }
}
class TransactionLogger{
    void log(int acc,String type,double amount){
        try{
            FileWriter fw=new FileWriter("transactions.txt",true);
            fw.write(acc+" | "+type+" | "+amount+"\n");
            fw.close();
        }
        catch(IOException e){
            System.out.println("File error");
        }
    }
}
public class Main{

    public static void main(String[] args){
        BankAccount acc=new BankAccount(1,"Himanshu",5990);
        TransactionLogger logger=new TransactionLogger();
        try{
            acc.deposit(2340);
            logger.log(acc.accountNumber,"DEPOSIT",2000);

            acc.withdraw(1340);
            logger.log(acc.accountNumber,"WITHDRAW",1000);

            acc.withdraw(7390);
            logger.log(acc.accountNumber,"WITHDRAW",7000);

        }
        catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic error");
        }
        System.out.println("Final Balance: "+acc.balance);
    }
}
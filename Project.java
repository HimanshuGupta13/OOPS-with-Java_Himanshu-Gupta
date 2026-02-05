abstract class RBI{
    abstract double getInterestRate();
}
class SBI extends RBI{
    double getInterestRate(){
        return 7.5;
    }
}
class PNB extends RBI{
    double getInterestRate(){
        return 7.2;
    }
}
public class Project{
    public static void main(String[] args){
        RBI sbi=new SBI();
        RBI pnb=new PNB();
        System.out.println("SBI Interest Rate: "+sbi.getInterestRate()+"%");
        System.out.println("PNB Interest Rate: "+pnb.getInterestRate()+"%");
    }
}
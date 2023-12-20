package packA;

public class Salesperson extends Programmer {
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n,exp,sal);
        target = assignedTarget;
    }
    Salesperson(String n, int exp){

    }
    public int getTarget() {
        return target;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void setSalary(int incresedAmount){
        this.salary += incresedAmount;
    }
    public void setSalary(){
        this.salary*=1.1;
    }
    public String makeQuotation(){
        return "Dear value customer, 898 is my best offer.";
    }
    @Override
    public String toString() {
        return "Saleperson [target=" + target + " " + super.toString()+ "]";
    }
    
}

package packA;

public class Salesperson extends EmpTmp {
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n,exp,sal);
        target = assignedTarget;
    }
    Salesperson(String n, int exp){

    }
    public void setTarget(int target) {
        this.target = target;
    }
    public int getTarget() {
        return target;
    }
    public void setSalary(){
        this.salary*=1.1;
    }
    @Override
    public void setSalary(int inAmt){
        this.salary += inAmt;
    }
    
    public String makeQuotation(){
        super.sayHi();
        return String.format("Dear value customer, %d is my best offer.", (int) (Math.random() * this.target) + this.salary);
    }
    @Override
    public String toString() {
        return "Saleperson [target=" + target + " " + super.toString()+ "]";
    }
    
}

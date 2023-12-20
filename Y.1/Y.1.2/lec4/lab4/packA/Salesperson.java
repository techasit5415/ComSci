package packA;

public class Salesperson extends Employee {
    private int target;

    public void setSalary(){
        this.salary*=1.1;
    }
    
    public void setSalary(int inAmt){
        this.salary += inAmt;
    }
    
    public String makeQuotation(){
        super.sayHi();
        return String.format("Dear value customer, %d is my best offer.", (int) (Math.random() * this.target) + this.salary);
    }
    
    
}

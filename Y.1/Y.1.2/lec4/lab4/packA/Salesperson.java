package packA;

public class Salesperson extends Employee implements SalesRole {
    private int target;

    public Salesperson (String n, int exp, int sal, int assignedTarget) {
        this.name = n;
        this.experience = exp;
        this.salary = sal;
        this.target = assignedTarget;
    }

    public Salesperson(String n, int exp) {
        this.name = n;
        this.experience = exp;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return this.target;
    }

    public void setSalary(int increasedAmount) {
        this.salary += increasedAmount;
    }

    public void setSalary() {
        this.salary = (this.salary * 110)/100;
    }

    public String makeQuotation() {
        return String.format("Dear value customer, %d is my best offer.", (int) (Math.random() * this.target) + this.salary);
    }

    public String toString() {
        return String.format("Salesperson [target=%d [name=%s, salary=%d, experience=%d] ]" , this.getTarget(), this.name, this.salary, this.experience);
    }
    public void sayHi() {
        System.out.println(String.format("Accountant [Hi! my name is %s]", this.name));
    }
}

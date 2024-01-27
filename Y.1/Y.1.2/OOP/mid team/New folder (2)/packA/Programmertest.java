package packA;
public class Programmertest{
    private String name;
    protected int salary;
    private int experience;
    public Programmertest(String n,int exp, int sal){
        this.name = n;
        this.experience=exp;
        this.salary=sal;
    }
    public Programmertest(String n){
        this.name = n;
    }
    public Programmertest(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int exp) {
        this.experience = exp;
    }

    public String toString() {
        return "Programmertest [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }
    public void sayHi(){System.out.println("hi from "+name);}
    
}
package packA;

public class Programmer {
    private String name;
    private int experience;
    protected int salary;

    public Programmer(String n, int exp, int sal) {
        this.name=n;
        this.experience=exp;
        this.salary=sal;
    }

    public Programmer(String n) {
        name = n;
        experience = 0;
        salary=0;
    }

    public Programmer() {

    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSalsalary(int salary) {
        this.salary = salary;
    }

    public void sayHi() {
        System.out.println("hi from "+name);
    }

    @Override
    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }

}

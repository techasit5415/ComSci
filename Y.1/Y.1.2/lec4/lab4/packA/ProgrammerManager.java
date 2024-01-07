package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles {
    public ProgrammerManager(String n, int exp, int sal) {
        super(n, exp, sal);
    }
    public void sayHi() {
        System.out.println("Coding in " + getSkills());
    }
    public String coding() {
        return "I am Programmer Manager Hehee... Be careful >:)";
    }
    public int evaluate(Programmer p) {
        p.salary += (p.salary * 15)/100;
        return p.salary;
    }
}
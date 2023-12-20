package packA;

public class Acountant extends Programmer {
    private static String companyName = "berk burn jamkad";
    private int experience;
    private String specialty;

    public Acountant(String name, int superExp, int experience, int sal, String talent) {
        super(name, superExp, sal);
        this.experience = experience;
        specialty = talent;
    }

    public int getAccountexperience() {
        return experience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountexperience(int exp) {
        experience = exp;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String tellProfit() {
        return companyName + "'s profit is " + (int) (Math.random() * 1000) + ". My salary is " + this.salary;
    }

    @Override
    public String toString() {
        return "Acountant [experience=" + experience + ", specialty=" + specialty + "]";
    }

    @Override
    public void sayHi() {
        System.out.println(this.getName() + " says hello");
    }

    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
}
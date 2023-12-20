package packA;

public class Accountant extends Employee {
    private static String companyName = "berk burn jamkad";
    private int experience;
    private String specialty;

public Accountant(String name, int superExp, int experience, int sal, String talent) {
    this.name = name;
    super.experience = superExp;
    this.experience = experience;
    this.salary = sal;
    this.specialty = talent;
    }
    public void setSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void SetAccountExperience(int exp) {
        this.experience = exp;
    }

    public int getAccountExperience() {
        return this.experience;
    }

    public String tellProfit() {
        return String.format("%s's profit is %d. My salary is %d", Accountant.companyName, (int) (Math.random() * this.salary), this.salary);
    }

    public String toString() {
        return String.format("%s [experience=%d, specialty=%s]", this.getClass().getSimpleName(), this.getAccountExperience(), this.getSpecialty());
    }

    public void sayHi() {
        System.out.println(String.format("Accountant [Hi! my name is %s]", this.name));
    }

    public static String tellMyRole() {
        return String.format("I am an accountant at %s", Accountant.companyName);
    }
}
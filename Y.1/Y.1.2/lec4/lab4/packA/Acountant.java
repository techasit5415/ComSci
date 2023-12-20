package packA;

public class Acountant extends Employee {
    private static String companyName = "berk burn jamkad";
    private int experience;
    private String specialty;

    
    public String tellProfit() {
        return companyName + "'s profit is " + (int) (Math.random() * 1000) + ". My salary is " + this.salary;
    }
    public void sayHi() {
        System.out.println(this.getName() + " says hello");
    }

    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
}
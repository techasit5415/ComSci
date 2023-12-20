package packA;

import java.util.ArrayList;

public class Programmer extends Employee {
    private ArrayList<String> skills = new ArrayList<String>();
    public Programmer(String n, int exp, int sal) {
        this.name = n;
        this.experience = exp;
        this.salary = sal;
        setSkills("solidity","typescript");
    }
    public void setSkills(String ...strings) {
        for (String i : strings) {
            this.skills.add(i);
        }
    }
    public ArrayList<String> getSkills() {
        return skills;
    }
    
    public void sayHi() {
        System.out.println(String.format("Programmer [Hi! my name is %s]", this.name));
    }
    public String toString() {
        return String.format("ManagerProgrammer [name=%s, experience=%dsalary=%d]", this.name, this.experience, this.salary);
    }
    public String coding() {
        return "Yes.. I was coding this and I dont know what should I return in this method so.. here's the messages.";
    }
}
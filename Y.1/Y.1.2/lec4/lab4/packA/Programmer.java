package packA;

import java.util.ArrayList;

public class Programmer extends Employee {
    private ArrayList<String> Skills = new ArrayList<String>();

    public Programmer(String n, int exp, int sal) {
        this.name=n;
        this.experience=exp;
        this.salary=sal;
    }

    public void sayHi() {
        System.out.println(this.getName() + " says hello");
    }

    public String coding(){
        return "I am programmer and marry crismistmas and happy new year kub arjarn";
    }

    



   
   

    

}

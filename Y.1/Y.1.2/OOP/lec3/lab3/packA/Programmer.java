package packA;

public class Programmer extends EmpTmp {
    

    public Programmer(String n, int exp, int sal) {
        this.name=n;
        this.experience=exp;
        this.salary=sal;
    }
    @Override
    public void sayHi() {
        System.out.println(this.getName() + " says hello");
    }

    public String coding(){
        return "I am programmer and marry crismistmas and happy new year kub arjarn";
    }

    @Override
    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }



   
   

    

}

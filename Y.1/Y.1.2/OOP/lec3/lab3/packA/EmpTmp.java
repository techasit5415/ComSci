package packA;
public class EmpTmp{
    
        protected String name;
        protected int salary;
        protected int experience;
    
    public EmpTmp(String n,int exp,int sal){
        name = n;
        salary = sal;
        experience =exp;
    }
    public EmpTmp(String n){

    }
    public EmpTmp(){

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(int newSalary){
        this.salary = newSalary;
    }
    public int getSalary(){
        return salary;
    }
    public void setExperience(int exp){
        this.experience=exp;
    }
    public int getExperience(){
        return experience;
    }
    @Override
    public String toString() {
        return "Acountant [experience=" + experience + ", specialty=]";
    }
    public void sayHi(){
       System.out.println(String.format("Hello from EmpTmp  [Hi my name is %s]",getName()));
    }
    
}
package packA;
public class Lab3EmpTmp{
    
        protected String name;
        protected int salary;
        protected int experience;
    
    public Lab3EmpTmp(String n,int exp,int sal){
        name = n;
        salary = sal;
        experience =exp;
    }
    public Lab3EmpTmp(String n){
        this.name = n;
    }
    public Lab3EmpTmp(){

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
        return this.salary;
    }
    public void setExperience(int exp){
        this.experience=exp;
    }
    public int getExperience(){
        return this.experience;
    }
    @Override
    public String toString() {
        return String.format("EmpTmp [name=%s, salary=%d, experience=%d]", getName(), getSalary(), getExperience());
    }
    public void sayHi(){
       System.out.println(String.format("Hello from EmpTmp  [Hi my name is %s]",getName()));
    }
    
}
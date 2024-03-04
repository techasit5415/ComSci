public class Employee {
    String name;
    int salary;
    String id;

    public Employee(String n) {
        name = n;
        int sal = 0;
        for (int j = 0; j < name.length(); j++) {
            sal += name.charAt(j);
        }
        salary = sal;
        int memAddress = System.identityHashCode(this);
        id = Integer.toHexString(memAddress);
    }
    
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public void setSalary(int sal) {
        salary = sal;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " [" + name + "(" + salary + ")]";
    }
        
}

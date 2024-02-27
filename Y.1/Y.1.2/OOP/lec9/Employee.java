import java.util.Objects;

public class Employee {
    private String name;
    private String id;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String n) {
        this.name = n;
        int sal = 0;
        for (int j = 0; j < name.length(); j++)
            sal += name.charAt(j);
        salary = sal;
        int memAddress = System.identityHashCode(this);
        id = Integer.toHexString(memAddress); // Integer.toHexString(memAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }


    @Override
    public String toString() {
        return id + " [" + name + "(" + salary + ")]";
    }

}

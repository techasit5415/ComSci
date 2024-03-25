import java.util.ArrayList;
import java.util.List;

public class Lab9_Q1 {
    public static void main(String[] args) {
        //ex1();
        // ex2();
        ex3();
        //ex4();
        //ex5();
    }

    static void ex1() {
        // hasCode() vs System.identityHashCode()
        Employee emp1 = new Employee("yindee");
        Employee emp2 = new Employee("yindee");
        int id1 = emp1.hashCode();
        int id2 = emp2.hashCode();
        String s1 = Integer.toHexString(id1);
        String s2 = Integer.toHexString(id2);
        System.out.println(s1);
        System.out.println(s2 + " " + s1.compareTo(s2));
    }

    static void ex2() {
        // java creates a copy of the reference when
        // an obj is passed to a method.
        // changes to an obj will be effected.
        Employee emp1 = new Employee("preeda");
        System.out.println(emp1);
        ex2_1(emp1);
        System.out.println(emp1);
    }
    private static void ex2_1(Employee e) {
        e.setName("aba abi abo abe");
    }

    static void ex3() {
        // changes to an obj will be effected when
        // passing as a parameter but not a collection
        ArrayList <Employee> singers = new ArrayList<>();
        singers.add(new Employee("aba"));
        singers.add(new Employee("abi"));
        singers.add(new Employee("abo"));
        singers.add(new Employee("abe"));

        ex3_1(singers);
        System.out.println(singers.get(0));
        // cha cha cha
        System.out.println(singers);
        // not empty because it's list who changes
    }
    private static void ex3_1(List<Employee> list) {
        list.get(0).setName("cha cha cha");
        // changes takes effect
        list = new ArrayList<>();
        // changes takes "no" effect on collection
    }

    static void ex4() {
        // what if we do need to change the referenced
        // object to another
        ArrayList<Employee> singers = new ArrayList<>();
        singers = ex4_1();
        System.out.println(singers);
    }
    private static ArrayList<Employee> ex4_1( /*List<Employee> list */ ) {
        ArrayList<Employee> list = new ArrayList<>();
        // whether list is passed in or newly allocated,
        // it's a local reference.
        list.add(new Employee("aba"));
        list.add(new Employee("abi"));
        return (ArrayList<Employee>) list;
    }

    static void ex5() {
        // collection clone is shallow copy
        ArrayList<Employee> singers = new ArrayList<>();
        singers.add(new Employee("aba"));
        singers.add(new Employee("abi"));
        singers.add(new Employee("abo"));
        singers.add(new Employee("abe"));
        @SuppressWarnings("unchecked") // by clone()
        List<Employee> tmp = (ArrayList<Employee>)singers.clone();
        tmp.get(0).setName("cha");
        System.out.println(singers);
        // by new ArrayList<>();
        tmp = new ArrayList<>(singers);
        tmp.get(1).setName("cha cha");
        System.out.println(singers);
        // by subList()
        tmp = singers.subList(0, singers.size() - 1);
        tmp.get(2).setName("cha cha cha");
        System.out.println(tmp);
    }
}


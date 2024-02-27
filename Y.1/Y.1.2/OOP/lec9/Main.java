// import java.util.HashMap;
public class Main{
public static void main(String[] args) {
   ex1();
    // ex2();
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
}
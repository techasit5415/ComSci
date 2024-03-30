import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lab9_1 {
    // generic
    public static void main(String[] args) {
        // example1();
        // example2();
        // example3();
        // example4();
        // example5();
        example6(example4());
        example7(example4());

    }
  

    private static void example1() {
        printer<Integer> number = new printer<>();
        number.sett(1);
        number.print();
        System.out.println("---------------------");
        printer<Double> Dnumber = new printer<>();
        Dnumber.sett(33.5);
        Dnumber.print();
        System.out.println("---------------------");
        printer<String> STR = new printer<>();
        STR.sett("set str");
        STR.print();

    }

    private static void example2() {
        System.out.println();
        System.out.println("------example2--------");
        System.out.println();

        printer1 exam = new printer1();
        System.out.println(":return from printer1 :" + exam.example2("john", 77));
    }

    private static void example3() {
        printer1 exam = new printer1();
        System.out.println();
        System.out.println("------example3--------");
        System.out.println();
        List<Integer> numList = new ArrayList<>();
        numList.add(3);
        exam.example3(numList);

        List<String> strList = new ArrayList<>();
        strList.add("Test");
        exam.example3(strList);
    }

    private static HashSet<String>  example4() {
        System.out.println("------example4--------");
        HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);
        return cars;
    }

    private static void example5() {
        System.out.println("------example5--------");
        HashSet<Integer> numcars = new HashSet<>();
        numcars.add(1);
        numcars.add(3);
        numcars.add(4);
        numcars.add(6);
        numcars.add(9);
        System.out.println(numcars);
    }

    private static void example6(HashSet<String> cars) {
        System.out.println("------example6--------");
        // HashSet<String> cars = new HashSet<>();
        System.out.println("Mazda");
        if (cars.contains("Mazda")) {
            System.out.println("str 'Mazda'");
        } else {
            System.out.println("str no have 'Mazda'");
        }
    }

    private static void example7(HashSet<String> cars) {
        System.out.println("------example7--------");
        // HashSet<String> cars = new HashSet<>();
        System.out.println("mazda");
        if (cars.contains("mazda")) {
            System.out.println("str have'mazda'");
        } else {
            System.out.println("str no have 'mazda'");
        }
    }
}
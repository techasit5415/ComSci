import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lab9_1{
//generic
    public static void main(String[] args) {
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

        System.out.println();
        System.out.println("------example2--------");
        System.out.println();

        printer1 exam =new printer1();
        System.out.println(":return from printer1 :"+ exam.example2("john", 77));
        
        System.out.println();
        System.out.println("------example3--------");
        System.out.println();
        List<Integer> numList = new ArrayList<>();
        numList.add(3);
        exam.example3(numList);
        
        List<String> strList = new ArrayList<>();
        strList.add("Test");
        exam.example3(strList);

        System.out.println("------example4--------");
        HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);
      
        System.out.println("------example5--------");
        HashSet<Integer> numcars = new HashSet<>();
        numcars.add(1);
        numcars.add(3);
        numcars.add(4);
        numcars.add(6);
        numcars.add(9);
        System.out.println(numcars);
        System.out.println("------example5--------");

        if (cars.contains("Mazda")) {
            System.out.println("str 'Mazda'");
        } else {
            System.out.println("str no have 'Mazda'");
        }

        System.out.println("------example6--------");
        
        if (cars.contains("mazda")) {
            System.out.println("str have'mazda'");
        } else {
            System.out.println("str no have 'mazda'");
        }
    }
    
}
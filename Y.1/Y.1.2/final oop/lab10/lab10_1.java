import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class lab10_1 {
    List<Integer> number = Arrays.asList(9, 4, 5, 6, 7);

    public static void main(String[] args) {
        lab10_1 lab10 = new lab10_1();
        lab10.example1();
        Stream<Integer> data = lab10.example2();
        lab10.example3(data);
        Stream<Integer> data2 = lab10.number.stream();
        lab10.example4(data2); // Adding example4 method call
        lab10.example5();
    }

    private void example1() {
        number.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("---------------------------------");
    }

    private Stream<Integer> example2() {
        Stream<Integer> data = number.stream();
        Stream<Integer> sortdata = data.sorted();
        sortdata.forEach(n -> System.out.println(n));
        System.out.println("---------------------------------");
        return number.stream();
    }

    private void example3(Stream<Integer> data) {
        long nums = data.count();
        System.out.println("Number of elements: " + nums);
        System.out.println("---------------------------------");
    }

    private void example4(Stream<Integer> data) {
        Stream<Integer> data1 = data.sorted();
        Stream<Integer> datamap = data1.map(n -> n * 2);
        datamap.forEach(n -> System.out.println(n));
        System.out.println("---------------------------------");
    }
    private void example5(){
        Stream <Integer>data =number.stream();
        Stream<Integer> datafilter = data.filter(n->n%2==1);
        datafilter.forEach(n-> System.out.println(n));
        System.out.println("---------------------------------");
    }
}

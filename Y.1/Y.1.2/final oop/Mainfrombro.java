import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

public class Main {
    static ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 54, 6, 23, 4, 2, 8, 9, 26, 123));
    static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList(new Student("John", 2),
                    new Student("Alice", 1),
                    new Student("Jan", 3)));

    public static void main(String[] args) {
        // .count() -> count data
        System.out.println(data.stream().count());
        // .reduce() -> reduce data in Collection to 1 datum.
        System.out.println(data.stream().reduce((a, b) -> a > b ? a : b).get());
        System.out.println(data.stream().max((a, b) -> a > b ? 1 : -1).get()); // Comparator
        System.out.println(data.stream().min(Integer::compare).get()); // Comparator
        System.out.println(Arrays.toString(data.stream().sorted().toArray())); // toArray -> cast every type to array.
                                                                               // // sorted -> sorting
        data.stream().forEach(System.out::println);
        // Optional just handle that value is empty or has value
        data.stream().max(Integer::compare).get();
        data.stream().mapToDouble(Double::valueOf).forEach(System.out::println);
        List<Integer> newList = data.stream().map(a -> a * 10).collect(Collectors.toList());
        System.out.println(data.stream().filter(d -> d > 400).findAny());
    }

    public static int calcualte(int a, int b) {
        return a + b;
    }
}

class Student implements Comparator<Student> {
    private String name;
    private int year;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    // comapre will return -1, 0, 1
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.year > o2.year) {
            return 1;
        } else if (o1.year == o2.year) {
            return 0;
        } else { // o1.yaer < o2.year
            return -1;
        }
    }

    public int addYear() {
        return ++this.year;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}

/**
 * InnerMain
 */
interface Plus {
    public int plus(int a, int b);
}

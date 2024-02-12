import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

interface HalfValueInterface {
    public abstract void printHalf(int n);
}

public class main {
    public static void main(String[] args) {
        q1_halfEachNumber();
        q2_forEachSingerName();
        q3_lambda_comparator();
        q4_method_reference_comparator();
    }

    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface q0 = new HalfValueInterface() {
            public void printHalf(int n) {
                System.out.println(n / 2);
            }
        };
        for (int n : nums) {
            q0.printHalf(n);
        }
        System.out.println("--q1.1--");
        HalfValueInterface halfVal = n -> System.out.println(n / 2);
        for (int n : nums) {
            halfVal.printHalf(n);
        }

        System.out.println("--q1.2--");
        Consumer<Integer> consumer = n -> System.out.println(n / 2);
        for (int n : nums) {
            consumer.accept(n);
        }
        System.out.println("--q1.3--");
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.forEach(halfMe);
        System.out.println("--q1.4--");
        nums.forEach(num -> System.out.println(num / 2));
        System.out.println("--q1.5--");
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::printHalf);
    }

    static class NumberProcessor {
        void printHalf(int n) {
            System.out.println(n / 2);
        }
    }

    public static void q2_forEachSingerName() {
        List<Singer> singerList = Arrays.asList(
                new Singer("Aba"),
                new Singer("Abi"),
                new Singer("Abo"),
                new Singer("Abe"));
        System.out.println("--q2.1--");
        singerList.stream().map(singer -> singer.getName()).forEach(System.out::println);
        System.out.println("--q2.2--");
        singerList.stream().map(Singer::getName).forEach(System.out::println);
    }

    public static void q3_lambda_comparator() {
        List<Singer> singerList = Arrays.asList(
                new Singer("Aba", SingStyle.POP),
                new Singer("Abo", SingStyle.POP),
                new Singer("Abi", SingStyle.ROCK),
                new Singer("Abe", SingStyle.ROCK));
        Comparator<Singer> byStyle1 = new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            }
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);

        System.out.println("---q3.1---");
        Comparator<Singer> byStyle2 = (singer1, singer2) -> singer1.getStyle().compareTo(singer2.getStyle());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);
    }

    public static void q4_method_reference_comparator() {
        List<Singer> singerList = Arrays.asList(
                new Singer("Aba", SingStyle.POP),
                new Singer("Abo", SingStyle.POP),
                new Singer("Abi", SingStyle.ROCK),
                new Singer("Abe", SingStyle.ROCK));
        System.out.println("---q4.1---");
        Comparator<Singer> byName = Comparator.comparing(Singer::toString);
        Collections.sort(singerList, byName);
        //Collections.sort(singerList,Singer::compareByName); q4.3
        singerList.forEach(System.out::println);

        System.out.println("---q4.2---");
        singerList.sort((singer1, singer2) -> singer1.getStyle().compareTo(singer2.getStyle()));
        //singerList.sort(Singer::compareByName) -> singer1.getStyle().compareTo(singer2.getStyle())); q4.4    
        singerList.forEach(System.out::println);
    }
}



class Singer {
    private String name;
    private SingStyle style;

    public Singer(String name) {
        this.name = name;
    }

    public Singer(String name, SingStyle style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public SingStyle getStyle() {
        return style;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(SingStyle style) {
        this.style = style;
    }

    public int compareByName(Singer s) {
        return this.name.compareTo(s.getName());
    }

    @Override
    public String toString() {
        return "Singer (" + name + "-SingStyle." + style + ")";
    }
}


enum SingStyle {
    POP, ROCK
}

// anthor class
// class Singer {
//     private String name;
//     private SingStyle style;

//     Singer(String n) {
//         name = n;
//     }

//     Singer(String n, SingStyle style) {
//         name = n;
//         this.style = style;
//     }

//     public SingStyle getStyle() {
//         return style;
//     }

//     public String getName() {
//         return name;
//     }

//     @Override
//     public String toString() {
//         return "Singer (" + name + "-SingStyle." + style + ")";
//     }
// }

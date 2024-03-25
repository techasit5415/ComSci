import java.util.Arrays;
import java.util.stream.Stream;

public class lec10 {
    public static void main(String[] args) {
        String[] array = { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(array);
        System.out.printf(" %s",stream);

    }

}

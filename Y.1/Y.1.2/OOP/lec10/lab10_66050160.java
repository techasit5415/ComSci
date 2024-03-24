import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class lab10_66050160 {
    public static void main(String[] args) {
        // args[0] is "5" and args[1] is "haha"
        // testBed(args);
        
            lab10_MovieCounter lab10MC = new lab10_MovieCounter();
            // lab10MC.q1();
            // lab10MC.q2();
            // lab10MC.q3();
            // lab10MC.q4();
            // lab10MC.q5();
            // lab10MC.q6();
            // lab10MC.q7();
            // lab10MC.q8();
            // lab10MC.q9();
            // lab10MC.q10();
            // lab10MC.q11():


    }

    static void testBed(String[] args) {
        System.out.println("**AAAAAAAA**");
        // learn behavior of args
        System.out.print("command arguments are ");
        for (String s : args)
            System.out.println(s.trim());
        System.out.println();
        System.out.println("**BBBBBBBB**");
        // review openning .csv file using .split()
        String row;
        String[] tokens;
        try (Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies15.csv"))) {
            input.nextLine(); // skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                tokens = row.split(",");
                for (String token : tokens)
                    System.out.print(token + " ");
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
        System.out.println("**CCCCCCCC**");
        // test what if title contains comma(,)
        row = "\"This is, a sample title\", \"Horror\", \"10.0\"";
        tokens = row.split(",");
        System.out.println("There are " + tokens.length
                + " tokens");
        for (String token : tokens)
            System.out.println(token.trim() + " ");
        tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println("There are " + tokens.length
                + " tokens");
        for (String token : tokens)
            System.out.println(token.trim() + " ");

    }

    private static void hintsQ10() {
        Map<String, Integer> unordered = new HashMap<>();

        unordered.put("A", 12);
        unordered.put("E", 7);
        unordered.put("F", 20);

        Map<String, Integer> orderByValuesMap;
        orderByValuesMap = unordered.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Entry::getKey, Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        for (Entry entry : orderByValuesMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        Map<String, Long> unorderedLong = new HashMap<>();
        unorderedLong.put("D", 12L);
        unorderedLong.put("E", 7L);
        unorderedLong.put("F", 20L);
        Map<String, Long> longAndReverseMap;
        longAndReverseMap = unorderedLong.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue(Long::compareTo)))
                .collect(Collectors.toMap(
                        Entry::getKey, Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        for (Entry entry : longAndReverseMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static void hitQ11() {
        Function<String, Integer> numWords = entry -> {
            String[] tokens = entry.split(" ");
            return tokens.length;
        };

        List<String> data = Arrays.asList("one two three", "four, five", "six seven eight nine");
        Optional<String> opt = data.stream().max(Comparator.comparing(numWords));
        System.out.println(opt.get());
    }
}

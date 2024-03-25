import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import pack10_CSMovie.CSMovie;


public class lab10_MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();

    public static void main(String []args){
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
        lab10MC.q11();
        
    }

    public lab10_MovieCounter() {
        String row;
        int rowCount = 1;
        int incomplementCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        // String skipped_released;
        Double score;
        Integer votes;
        String director;
        // String skipped_writer;
        String star;
        String country;
        Integer budget;
        Long gross;
        String company;
        Integer runtime;
        try (Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine();
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incomplementCount++;
                    System.out.println(rowCount + " " + incomplementCount + " is incompleted");
                    continue;
                }
                title = tokens[0];
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
                gross = (long) (Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));
                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre,
                            year, score, votes,
                            director, star, country,
                            budget, gross, company,
                            runtime));
                }
                uniqueTitle.add(title);
            }
            System.out.println("There are " + incomplementCount + " row of incompled data");
            System.out.println("from " + rowCount + " row. (" + uniqueTitle.size() + ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }

    private String parseDouble(String str) {
        if(str.isEmpty())
        return".0";
    return str;
    }

        public void q1() {
        Double average = mList.stream().mapToDouble(CSMovie::getScore).average().getAsDouble();
        System.out.println("Score average -> " + average);
    }

    public void q2() {
       mList.stream().filter(e -> e.getVotes() > 1900000).forEach(f -> System.out.println(f.getTitle()));
    }

    public void q3() {
        List<CSMovie> m = mList.stream().sorted(Collections.reverseOrder((e1, e2) -> e1.getGross().compareTo(e2.getGross())))
                            .collect(Collectors.toList());
        m.stream().findFirst().ifPresent(System.out::println);
    }

    public void q4() {
        Map<String,List<CSMovie>> genreList = new HashMap<>();
        genreList = mList.stream().collect(Collectors.groupingBy(e -> String.valueOf(e.getGenre())));
        System.out.println(genreList.keySet());
    }

    public void q5() {
        List<CSMovie> m = mList.stream().limit(5).sorted((e1, e2) -> e1.getRuntime().compareTo(e2.getRuntime()))
                            .collect(Collectors.toList());
        m.stream().map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime())).forEach(f -> System.out.println(f));
    }

    public void q6() {
        List<CSMovie> m = mList.stream().sorted(Collections.reverseOrder((e1, e2) -> e1.getBudget().compareTo(e2.getBudget())))
                            .collect(Collectors.toList());
        m.stream().findFirst().ifPresent(e -> System.out.println("Highest Buget -> " + e.getTitle() + ", " + e.getBudget()));
        m = m.stream().sorted((e1, e2) -> e1.getBudget().compareTo(e2.getBudget())).collect(Collectors.toList());
        m.stream().findFirst().ifPresent(e -> System.out.println("Lowest Buget -> " + e.getTitle() + ", " + e.getBudget()));
    }

    public void q7() {
        List<CSMovie> m = mList.stream().sorted(Collections.reverseOrder((e1, e2) -> e1.getScore().compareTo(e2.getScore())))
                            .collect(Collectors.toList());
        Map<String,List<CSMovie>> genreList = new HashMap<>();
        genreList = m.stream().limit(3).collect(Collectors.groupingBy(e -> String.valueOf(e.getGenre())));
        genreList.entrySet().stream().forEach(e -> System.out.println(e.getKey()));
    }

    public void q8() {
        List<CSMovie> action = mList.stream().filter(e -> e.getGenre().equals("Action"))
                                .sorted(Comparator.comparing(CSMovie::getScore).reversed()
                                .thenComparing(Comparator.comparing(CSMovie::getTitle))).limit(3).collect(Collectors.toList());
        action.stream().forEach(e -> System.out.println(e.getTitle() + " -> " + e.getScore()));
    }

    public void q9() {
        Map<String,List<CSMovie>> genreList = new HashMap<>();
        genreList = mList.stream().collect(Collectors.groupingBy(e -> String.valueOf(e.getGenre())));
        Map<String, Long> sumList = new HashMap<>();
        for(Entry entry : genreList.entrySet()) {
            long sum = genreList.get(entry.getKey()).stream().collect(Collectors.summingLong(e -> e.getGross()));
            sumList.put(String.format("%s", entry.getKey()), sum);
        }
        sumList.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    public void q10() {
        Map<String,List<CSMovie>> companyList = new HashMap<>();
        companyList = mList.stream().collect(Collectors.groupingBy(e -> String.valueOf(e.getCompany())));
        Map<String,Long> numCompanyMovie = new HashMap<>();
        for(Entry entry : companyList.entrySet()) {
            long num = companyList.get(entry.getKey()).size();
            numCompanyMovie.put(String.format("%s", entry.getKey()), num);
        }
        Map<String, Long> tenCompany;
        tenCompany = numCompanyMovie.entrySet().stream()
                        .sorted(Collections.reverseOrder(Entry.comparingByValue(Long::compareTo))).limit(10)
                        .collect(Collectors.toMap(
                            Entry::getKey, Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new
                        ));
        tenCompany.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    public void q11() {
        Function<String, Integer> numWords = entry -> {
            String[] tokens = entry.split("a");
            return tokens.length;
        };
        List<String> data = mList.stream().map(e -> e.getTitle()).collect(Collectors.toList());
        Optional<String> opt = data.stream().max(Comparator.comparing(numWords));
        System.out.println("Movie -> " + opt.get());
    }
}
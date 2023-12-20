import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProFun13_ReadCSV660160 {
    public static void main(String[] args) {
        demo4();
    }

    static void demo1() {
        try (Scanner input = new Scanner(Paths.get("movies.csv"));) {
            while (input.hasNext()) {
                String row = input.nextLine();
                String[] dataFields = row.split(",");
                String Title = dataFields[0];
                int Years = Integer.parseInt(dataFields[1]);
                double rating = Double.parseDouble(dataFields[2]);
                System.out.println(Title + (",") + Years + (",") + rating);
            }
        } catch (IOException e) {
            System.err.printf("o :error ", e);
            e.printStackTrace();
        }
    }

    static void demo2() {
        try (Scanner input = new Scanner(Paths.get("movies.csv"));) {
            while (input.hasNext()) {
                String row = input.nextLine();
                String[] dataFields = row.split(",");
                String Title = dataFields[0];
                int Years = Integer.parseInt(dataFields[1]);
                double rating = Double.parseDouble(dataFields[2]);
                movie movie = new movie(Title, Years, rating);
                System.out.println(movie);
            }
        } catch (IOException e) {
            System.err.printf("o :error ", e);
            e.printStackTrace();
        }
    }

    static void demo3() {
        int rowc =0;
        try (Scanner input = new Scanner(Paths.get("movies2.csv"));) {
            while (input.hasNext()) {
                
                try {
                    String row = input.nextLine();
                    String[] dataFields = row.split(",");
                    String Title = dataFields[0];
                    int Years = Integer.parseInt(dataFields[1]);
                    double rating = Double.parseDouble(dataFields[2]);
                    System.out.println(Title + (",") + Years + (",") + rating);
                    rowc++;
                } catch (NumberFormatException e) {
                    System.err.println("At row "+rowc+",exception named "+e+"... skip");
                    continue;
                }
            }
        } catch (Exception e) {
            System.err.printf("o :error ", e);
            e.printStackTrace();
        }
        
    }

    static void demo4() {
        ArrayList<movie> list = new ArrayList<>();
        try(Scanner input = new Scanner(Paths.get("movies2.csv"))){
            while(input.hasNext()){
                try {
                    String row = input.nextLine();
                    String[ ] tokens = row.split(",");
                    String title = tokens[0];
                    int year = Integer.parseInt(tokens[1]);
                    double rating = Double.parseDouble(tokens[2]);
                    movie movies = new movie(title,year,rating);
                    list.add(movies);
                } catch (Exception e) {
                    continue;
                }
            }
        }catch(Exception e){

        }
        for (movie m : list)
            System.out.println(m);
    }
}

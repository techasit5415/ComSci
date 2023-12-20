import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class movieCounter_660160 {
    public static void main(String[] args) {
        movieCounter_660160 location1 = new movieCounter_660160();
        movieCounter_660160 location2 = new movieCounter_660160();
        System.out.println("location 1");
        location1.showAvailableList();
        System.out.println("location 2");
        location2.showAvailableList();
        System.out.println("location 1");
        location1.checkOut(1);
        location1.showCheckOutList();
        location1.showAvailableList();

        System.out.println("location 2");
        location2.checkOut(2);
        location2.showCheckOutList();
        location2.showAvailableList();
    }

    movieCounter_660160() {
        try{
            System.out.println("From construtor -> We are open!");
        }
        catch(Exception e){
        System.out.println("From construtor -> We are close!");

        }
        try (Scanner input = new Scanner(Paths.get("movies2.csv"));) {
            while (input.hasNext()) {
                String str = input.nextLine();
                String[] dataFields = str.split(",");
                int Years = 0;
                try {
                    Years = Integer.parseInt(dataFields[1]);
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
                double rating = Double.parseDouble(dataFields[2]);
                movie m = new movie(dataFields[0], Years, rating);
                availableList.add(m);
            }
        } catch (IOException e) {
            System.out.println("error ");

        }
       
    }

    ArrayList<movie> availableList = new ArrayList<>();
    ArrayList<movie> checkOutList = new ArrayList<>();

    void showAvailableList() {
        System.out.println("The following titles are available.");
        for (movie m : availableList)
            System.out.println(m);
    }

    void showCheckOutList() {
    System.out.println("The following titles have been checked out.");
for (movie m : checkOutList)
            System.out.println(m);
    }

    void checkOut(int index) {
        movie movie =availableList.get(index);
        checkOutList.add(movie);
        availableList.remove(index);
    }

}

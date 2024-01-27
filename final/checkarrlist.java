import java.util.ArrayList;

public class checkarrlist {
    public static void main(String[] args) {
        ArrayList<Integer> listint = new ArrayList<>();
        ArrayList<String> liststr = new ArrayList<>();
        listint.add(5);
        liststr.add("hello world!!");
        System.out.println(listint + ""+liststr);
    }
}

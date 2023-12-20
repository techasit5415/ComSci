import java.util.ArrayList;

public class eiei1 {
    String[] arr;
    ArrayList<String> ans;

    eiei1() {
        String[] obj = {"c", "b", "a"};
        arr = obj;
        ans = new ArrayList<String>();
    }

    public static void main(String[] args) {
        eiei1 b = new eiei1();
        b.recurse(0, "");
        for (String str : b.ans) {
            System.out.print("\"" + str + "\", ");
        }
        System.out.println("bye");
    }

    void recurse(int pos, String tmp) {
        if (pos == arr.length) {
            ans.add(tmp);
            return;
        }
        recurse(pos + 1, tmp);
        tmp = tmp.concat(arr[pos]);
        recurse(pos + 1, tmp);
    }
}


//upcasting
import pack1.*;

public class lec2_main {
    public static void main(String[] args) {
        // demo0();
        demo1();

    }

    public static void demo0() {
        Emp e1 = new Emp("yindee", 1000);
        ReaderA r1 = new ReaderA("preeda", 2000, "java");
        System.out.println("bye");
    }

    public static void demo1() {
        A[] arr = new A[4];
        arr[0] = new B();
        arr[1] = new C();
        arr[2] = new B();
        arr[3] = new C();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            B ref;
            if (arr[i] instanceof B) {
                ref = (B) arr[i];
                ref.onlyB();
            }

            if (arr[i] instanceof C) {
                ((C) (arr[i])).onlyC();

            }
        }
    }
}
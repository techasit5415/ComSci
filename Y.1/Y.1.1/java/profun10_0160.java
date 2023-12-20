import java.util.Arrays;

public class profun10_0160 {
    public static void main(String[] args) {
        // labinclass();
        lab1();
        lab2();
    }

    public static void labinclass() {
        int[] a = { 1, 2, 3 };
        int b = 3;
        appearsIn(a, b);
    }

    public static boolean appearsIn(int[] a, int n) {
        boolean isFound = appearsIn1(a, n, 0);
        System.out.println(isFound);
        return isFound;
    }

    static boolean appearsIn1(int[] a, int x, int idx) {
        if (idx == a.length)
            return false;
        if (a[idx] == x)
            return true;
        return appearsIn1(a, x, idx + 1);

    }

    public static void lab1() {
        int[] arr = { 1, 2, 3, 2, 4, 2 };
        int num = 2;
        int c = count(arr, num, 0);
        System.out.println(c);
    }

    public static int count(int[] arr, int num, int idx) {
        if (idx == arr.length) {
            return 0;
        }
        int count1 = 0;
        if (arr[idx] == num) {
            ++count1;
        }
        return count1 + count(arr, num, idx + 1);
    }


    public static void lab2(){
        int [] arr = {1,-2, 3, 4, -5};
        check(arr,0);
        System.out.println(Arrays.toString(check(arr,0)));

    }
    public static int[] check(int[]arr, int idx){
        if( idx == arr.length)
        return arr;
                
        if (arr[idx] <0) {
            arr[idx]=0;
        }
        return check(arr, idx + 1);
        
    }
}

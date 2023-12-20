import java.util.Arrays;

public class Lab5_660160 {
   

    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement = arr -> {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    };

    static ArrayProcessor q2IndexOfLargestEvenValue = arr -> {
        int maxIndex = -1;
        int maxEvenValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] > maxEvenValue) {
                maxEvenValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    };
    static ArrayProcessor myMedian = arr -> {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    };

    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }

    static void q1() {
        System.out.println(q1NumberOfEvenElement.calculate(data)); // 4
    }

    static void q2() {
        System.out.println(q2IndexOfLargestEvenValue.calculate(data)); // 1
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        /* q3 */ // one statement
        System.out.println(myMedian.calculate(tmp)); // 48
    }
}
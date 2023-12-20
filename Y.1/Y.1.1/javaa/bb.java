public class bb {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 4, 5, 7 }; // Line 10
        int maxCnt = 0; // Line 20
        int arrSize = arr.length; // Line 30
        int cnt = 0;
        int k = 0; // Define k
        int m = 0; // Define m
        int ans = 0; // Define ans
        int secret = 0; // Define secret

        for (int i = 0; i < arrSize; i++) { // Line 40
            cnt = 0; // Reset cnt for each i
            for (int j = 0; j < arrSize; j++) { // Line 60
                if (arr[i] == arr[j]) { // Line 70
                    cnt++; // Line 80
                    k++; /* A */
                } // if
            } // inner loop

            if (cnt > maxCnt) { // Line 120
                maxCnt = cnt; // Line 130
                ans = arr[i]; // Line 140
                secret = i; /* B */
                m++; /* C */
            } // if
        } // outer loop

        System.out.println("ans"+ans + " " + "maxcnt"+maxCnt); // Line 190
        secret += k + m; // Line 200
        System.out.println(secret); // Line 210
    }
}


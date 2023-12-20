public class testest {
    public static void main(String[] args) {
        int currentExamineIdx, tmp = 0;

        int[] d = { 9, 11, 13, 14, 15, 17, 19, 22 }; // Input array
        int markIdx = 0;
        int magic = 0; // Count of swaps
        int iter = 1;

        for (iter = 0; iter < d.length - 1; iter++) {
            markIdx = iter;

            for (currentExamineIdx = iter + 1; currentExamineIdx < d.length; currentExamineIdx++) {
                if (d[markIdx] > d[currentExamineIdx]) {
                    markIdx = currentExamineIdx;
                    magic++; // Increment the count of swaps
                }
            } // end of inner loop (currentExamineIdx)

            // Swap the elements at iter and markIdx
            tmp = d[iter];
            d[iter] = d[markIdx];
            d[markIdx] = tmp;

            // Display array content after each iteration
            for (int i = 0; i < d.length; i++)
                System.out.print(d[i] + " ");
            System.out.println();
        } // end of outer loop (iter)

        System.out.println("magic = " + magic); // Print the count of swaps
    }

    @Override
    public String toString() {
        return "testest []";
    }
}

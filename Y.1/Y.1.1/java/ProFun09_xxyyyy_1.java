import java.util.Arrays;

public class ProFun09_xxyyyy_1 {
    public static void main(String... args) {
        
        //q2();
        //q3_markTheBomb();
        /* Q1 could take sometime to understand the idea, solve q1 last. */
        q1();
    }
    static void q1() {
        System.out.println("-q1----");
        int [] template = {0,1,0,1,1,0,0,0,1};
        int [] data = new int [template.length];
        System.arraycopy(template, 0, data, 0, template.length);
        q1_supernavie(template);
        System.arraycopy(template, 0, data, 0, template.length);
        q1_improve_naive(template); 
        System.arraycopy(template, 0, data, 0, template.length);
        q1_transform(template);

    }
    static void q1_supernavie(int [] data) {
        int goLeft, goRight;
        for (int i = 0; i < data.length; i++) {

            for (goLeft = 0; goLeft < data.length; goLeft++)
                if (data[goLeft] == 1)
                    break;
            for (goRight = data.length - 1; goRight >= 0; goRight--)
                if (data[goRight] == 0)
                    break;

            if (goLeft < goRight) { 
                int tmp = data[goLeft];
                data[goLeft] = data[goRight];
                data[goRight] = tmp;
            }
        }
        System.out.println(Arrays.toString(data));
    }
    static void q1_improve_naive(int[] data) {
        int goLeft = 0;
        int goRight = data.length - 1;
    
        while (goLeft < goRight) {
            while (goLeft < data.length && data[goLeft] == 0) {
                goLeft++;
            }
    
            while (goRight >= 0 && data[goRight] == 1) {
                goRight--;
            }
    
            if (goLeft < goRight) {
                int tmp = data[goLeft];
                data[goLeft] = data[goRight];
                data[goRight] = tmp;
            }
        }
        System.out.println(Arrays.toString(data));
    }
    
    static void q1_transform(int[] data) {
        int zeroPointer = 0;
        int onePointer = data.length - 1;
    
        for (int i = 0; i <= onePointer; i++) {
            if (data[i] == 0) {
                // Place 0 at the zeroPointer and increment the pointer
                data[i] = 1;
                data[zeroPointer] = 0;
                zeroPointer++;
            } else if (data[i] == 1) {
                // Place 1 at the onePointer and decrement the pointer
                data[i] = 0;
                data[onePointer] = 1;
                onePointer--;
            }
        }
        System.out.println(Arrays.toString(data));
    }

    static void q2() {
        // 
        int [][] data = {   {11,12,13,14}, 
                            {15,16,17,18},
                            {19,20,21,22},
                            {23,24,25,26},
                            {27,28,29,30} };
        System.out.println("-q2----");
        q2_flip_by_new_array(data);
        System.out.println("way2");
        q2_flipHorizontal_inplace(data);
        for (int[] row : data) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("way3");
        q2_swap_rows(data);
        for (int[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }
    static void q2_flip_by_new_array(int [][] data) {
        int [][] hori = flipHorizontal(data);
        for (int row = 0; row < data.length; row++) {
                System.out.println(Arrays.toString(hori[row]));
        }
    }

    static int[][] flipHorizontal(int [][] img) {
        int [][] aRef = new int[img.length][img[0].length];
        int r2 = img.length - 1;
        for (int row = 0; row < img.length; row++) {
            for (int col = 0; col < img[row].length; col++) {
                aRef[r2 - row][col] = img[row][col];
            }
        }
        return aRef;
    }
    static void q2_flipHorizontal_inplace(int [][] img) {

        int numRows = img.length;

        for(int row = 0; row < numRows /2 ; row++){
            for(int col = 0; col < numRows -1; col++){
                int tmp = img[row][col];
                img[row][col] = img[numRows - row - 1][col];
                img[numRows - row -1][col] = tmp;
            }
        }


    }

    static void q2_swap_rows(int [][] img) {
        // idea is 
        // swap(row_0, row_n-1)
        // swap(row_1, row_n-1 - iง)

        int numRows = img.length;

        for (int row = 0; row < numRows / 2; row++) {
            int[] temp = img[row];
            img[row] = img[numRows - 1 - row];
            img[numRows - 1 - row] = temp;
        }
    }
    static void q3_markTheBomb() {
        int[][] map = { { 0, 0, 9, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 0, 0, 0 },
                { 0, 9, 9, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 9, 0, 0, 9, 9, 0, 0, 9, 0, 9, 0, 0 },
                { 0, 9, 0, 0, 9, 9, 0, 0, 9, 9, 9, 0, 0 }, 
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0 }
        };
        int[][] map2 = new int[map.length][map[0].length];
        int row = 0;
        //int col = 0;
        initialMap2(map, map2);
        markTheBomb(map2);
        for (row = 0; row < map2.length; row++) {
            System.out.println(Arrays.toString(map[row]) + "\t" + Arrays.toString(map2[row]));
        }
    }

    static void initialMap2(int[][] map, int[][] map2) {
        int row = 0;
        int col = 0;
        for (row = 0; row < map.length; row++) {
            for (col = 0; col < map[0].length; col++) {
                map2[row][col] = map[row][col];
            }
        }
    }

    static void markTheBomb(int[][] map2) {
        int numRows = map2.length;
        int numCols = map2[0].length;
    
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (map2[row][col] != 9) {
                    int bombCount = 0;
                    for (int r = row - 1; r <= row + 1; r++) {
                        for (int c = col - 1; c <= col + 1; c++) {
                            if (r >= 0 && r < numRows && c >= 0 && c < numCols && map2[r][c] == 9) {
                                bombCount++;
                            }
                        }
                    }
                    map2[row][col] = bombCount;
                }
            }
        }
    }
    
    
    
}

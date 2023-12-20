import java.util.Arrays;

public class Lab8_660160 {
    public static void main(String[] args) {
        //int [] data = {-2,-3,4,-1,-2,1,5,-3};
         //q2_1_BF(data);
         //q2_2_kadane(data);
        q3_topK(5,3,8,4,10,3,1,5,9,7,2,0);
    }
    static void q2_1_BF(int ... data) {
        int max = Integer.MIN_VALUE;
        int sum;
        int start, stop;
        start = stop = 0;
        int numCases = 0;
        //all pair of i,j
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i; j < data.length; j++) {
                sum = 0;

                for(int k=i; k<j; k++)
                sum+=data[k];

                System.out.printf("case %d for start,stop = %d,%d ->  sum = %d",++numCases,i,j,sum);
                if (sum > max) {
                    start = i;
                    stop = j;
                    max = sum;
                    System.out.println(" ** new max **");
                } else {
                    System.out.println();
                }
            }
        }
        System.out.printf("%d %d = %d%n",start,stop,max);
    }
    static void q2_2_kadane(int ... data) {
        int start, stop;
        start = stop = 0;
        int max_so_far = Integer.MIN_VALUE;
        int max_ends_here = 0;

        for (int i = 0; i < data.length; i++) {
            max_ends_here += data[i]; 
            if ( max_ends_here > max_so_far ) { 
                max_so_far = max_ends_here;
                stop = i;
                System.out.printf("%d %d is new max = %d%n",start,stop,max_so_far); 
            }
            if (max_ends_here < 0) { 
                max_ends_here = 0;    // fast forword i to skip all subset of ending at j
                start = i+1;  // ignore negative sum 
            }            
        }
        System.out.printf("%d %d = %d%n",start,stop,max_so_far);
    }
    static void q3_topK(int ... data) {
        int[] intArr = new int[10];
            
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = 0; //0 all arr 
        }


        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < intArr.length; j++) {

                if (data[i] > intArr[j]) {
                    
                    
                    for(int k = intArr.length-1; k > j; k--) {
                        intArr[k] = intArr[k-1];
                    }

                    intArr[j] = data[i];
                    break;
                }
            }
            System.out.printf("insert %d -> " + Arrays.toString(intArr) , data[i]);
            System.out.println();
        }
        System.out.println("final " + Arrays.toString(intArr));
        
        
    }
}

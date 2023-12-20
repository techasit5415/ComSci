public class minarry {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 5, 0};
        int temp=Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp;
                }
            }
        }
        
        System.out.println("Sorted array in ascending order: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" , ");
        }
        
            
        }
    }


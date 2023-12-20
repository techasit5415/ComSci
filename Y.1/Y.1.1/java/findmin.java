import java.util.Scanner;
public class findmin {
    public static void main(String[] args) {
        int[]arr =new int[5];
        int minscore=Integer.MAX_VALUE;
        float tmpavr=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Receive input for midterm scores of 5 student : ");
        for (int i=0; i<arr.length; i++){
            System.out.print("number student "+ (i+1)+": ");
            arr[i] = sc.nextInt();
            
        }
        for(int j=0; j<arr.length; j++){
            if(arr[j]<minscore){
                 minscore = (arr[j]);
                     
            }
             tmpavr += arr[j];
        }
        float avr=(tmpavr/5);
        sc.close();

        

        for(int z=0; z<arr.length-1; z++){
            for(int x=0; x<arr.length-1; x++){
                if(arr[x]<arr[x+1]){
                int temp = arr[x];
                arr[x] = arr[x+1];
                arr[x+1] = temp;
        }
    }
}
System.out.println("min : "+ minscore);
        System.out.printf("average : %.2f\n",avr);
        System.out.print("max to min : ");
    for(int y=0; y<arr.length; y++){
        System.out.print(arr[y]+" ");
    }




    }
}

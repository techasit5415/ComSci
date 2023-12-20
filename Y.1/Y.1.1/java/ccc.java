public class ccc {
    public static void main(String[] args){
        int[] n={-2,-3,4,-1,-2,-1,5,-3};
        int x=Integer.MIN_VALUE;
        int y=0;
        for (int j=0; j<n.length; j++){
            y=y+n[j];      
            if(x<y){
                x=y;
            }
            if(y<0){
                y=0;
            }
            System.out.println("y "+y);
        }
        System.out.println(x);
        }
}

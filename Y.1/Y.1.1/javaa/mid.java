public class mid{
    public static void main(String[] args) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if( i < 4 && i+j < 4){
                    System.out.print("A ");
                }
                else if ( i > 4 && i + j < 12 && i-j > 4){
                    System.out.print("C ");
                }
                else if (i==4){
                    System.out.print("* ");
                }
                else if (j == 4 && i +j !=8){
                    System.out.print("+ ");
                }
                else if ( j-i < 5 && i+j <13) {
                    System.out.print("0 ");
                }
                else if ( i < 4 && i +j < 12 ){
                    System.out.print("B ");
                }
                else{
                    System.out.print("D ");
                }

            }
            System.out.println();
        }
    }
}
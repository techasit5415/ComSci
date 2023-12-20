 class a{
    public static void  main(String [] args){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(i+j <4){
                    System.out.print("A ");
                }
                else if(i+j<13 && i+j>4 && i-j>4 && i-j<9){
                    System.out.print("C ");
                }
                else if(j==4 && i+j !=8){
                System.out.print("+ ");
                }
                else if(i==4){
                System.out.print("* ");
                }
                else if(i-j > -9 && i-j<-4 && i+j<12 && i+j>4){
                    System.out.print("B ");
                }
                else if(i-j > -4 && i-j<4 && i+j<17 && i+j>12){
                    System.out.print("D ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
 }
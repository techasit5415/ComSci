public class Binomial{
    private int n;
    public Binomial(int n){
     this.n = n;
    } 
    public void getBinomial(){ 
     System.out.print("(a + b)^ "+n +" = ");
     int cnt =0;
     for(int r=0 ;r<=n ;r++){
       int ans = getCoeff(n, r);
       System.out.print(ans+" a^"+ cnt +"b^"+r);
       cnt--;
     }
     
   }
   public int getCoeff(int n,int r){
      return  (getFactorial(n)/getFactorial(r))/getFactorial(n-r);
       
   }
    public int getFactorial(int n){
     if(n==0||n == 1){
       return 1;
     }
     return n*getFactorial(n-1);
    }
 
 }
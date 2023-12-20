public class lab2
{
public static void main(String[] args){
/*10*/ int[] arr = { 1, 2, 2, 2, 3, 3, 3, 3 };
/*20*/ int maxCnt = Integer.MIN_VALUE; 
/*30*/ int mem = arr[0]; 
/*40*/ int cur = arr[0];   
/*50 q1*/ int curCnt = 1; 
/*60*/ int mode = arr[0];  
/*70*/ for (int idx = 1; idx < arr.length; idx++) {
/*80*/     cur = arr[idx]; 
/*90*/     if (cur == mem) {
/*100*/        curCnt++;
/*110*/    } else {
/*120*/        if (curCnt > maxCnt) {
/*130*/            mode = mem;
/*140*/            maxCnt = curCnt;
            }
/*150 q2*/        curCnt = 1;
/*160 q3*/        mem = cur;
/*170*/    }
/*180*/ } // for idx
/*190** q4*/ if (curCnt > maxCnt) {
/*200 q5*/    mode = cur;
/*210*/    maxCnt = curCnt;
/*220*/ }
System.out.printf("mode = %d freq = %d%n", mode, maxCnt);}

}

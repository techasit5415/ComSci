import java.util.*;
class aaaaaaa{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter BPM:");
       double BPM = sc.nextInt();
       System.out.print("Enter Timing: ");
       int timing = sc.nextInt();
       System.out.print("Enter minute: ");
       int minute = sc.nextInt();
       System.out.print("Enter secord: ");
       int secord = sc.nextInt();
       sc.close();

       double beat = BPM/60;
       int time = (minute*60)+secord;
       int songroom = (int)(beat*time)/timing;
       System.out.println("Total Song Room = "+songroom);
    }
}
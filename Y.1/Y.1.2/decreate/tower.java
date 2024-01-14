import java.util.Scanner;

public class tower {
    static void towerOfHanoi(int n, char fromRod, char toRod, char helperRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }

        towerOfHanoi(n - 1, fromRod, helperRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        towerOfHanoi(n - 1, helperRod, toRod, fromRod);
    }

    static void displayRods(char sourceRod, char targetRod, char helperRod) {
        System.out.println("Current State of Rods:");
        System.out.println("Source Rod (" + sourceRod + "): ");
        System.out.println("Target Rod (" + targetRod + "): ");
        System.out.println("Helper Rod (" + helperRod + "): ");
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of disks: ");
        int numberOfDisks = scanner.nextInt();
        scanner.close();
        
        char sourceRod = 'A';
        char targetRod = 'C';
        char helperRod = 'B';

        System.out.println("Tower of Hanoi solution for " + numberOfDisks + " disks:");

        displayRods(sourceRod, targetRod, helperRod);

        towerOfHanoi(numberOfDisks, sourceRod, targetRod, helperRod);

        
    }
}

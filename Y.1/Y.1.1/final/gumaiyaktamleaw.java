import java.time.Clock;

public class gumaiyaktamleaw {
    public static void main(String[] args) {
        gumaiyaktamleaw ex5 = new gumaiyaktamleaw(); // Create an instance of Excercise_5
        Clock clock1 = ex5.new Clock(); // Create a Clock object from the Excercise_5 instance

        // Simulate the clock ticking
        // for (int i = 0; i < 86400; i++) {
        // clock1.ticks_q3();
        // System.out.printf("%02d:%02d:%02d\n", clock1.hours, clock1.minutes,
        // clock1.second);
        // }
        

        gumaiyaktamleaw ex5_2 = new gumaiyaktamleaw(); // Create another instance of Excercise_5
        Clock clock2 = ex5_2.new Clock(); // Create another Clock object from a different Excercise_5 instance

        for (int i = 0; i < 691200; i++) {
            clock2.ticks_q4();
            System.out.printf("%02dweek:%02dday:%02d:%02d:%02d:%s\n",clock2.weeks, clock2.day, clock2.hours, clock2.minutes, clock2.second,clock2.meridiem);
        }
    }

    public class Clock {

        int day = 0;
        int hours;
        int minutes;
        int second;
        String meridiem;
        int round;
        int counthours;
        int weeks;

        void ticks_q3() {
            second++;
            if (second > 59) {
                second = 0;
                minutes++;
                if (minutes > 59) {
                    minutes = 0;
                    hours++;

                    if (hours == 24) {
                        hours = 0;
                    }

                }

            }

        }

        void ticks_q4() {
            second++;
            if (second > 59) {
                second = 0;
                minutes++;
                if (minutes > 59) {
                    minutes = 0;
                    hours++;
                    counthours++;

                    if (hours > 11)
                        round++;
                    if (counthours == 24) {
                        day++;
                        round = 0;
                        counthours = 0;
                        hours = 0;
                    }

                    if (counthours == 13){
                        hours = 1;}
                        if(day ==7){
                            weeks++;
                            day=0;
                        }

                    
                }

            }

            if (round < 1) {
                meridiem = "AM";
            } else {
                meridiem = "PM";
            }
        }
    }

    public static void print() {
        for (int i = 0; i < 3; i++)
            System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");

    }
}
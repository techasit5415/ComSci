public class Lab4Q3_660160 {
    public static void main(String[] args) 
    {
        int amountCharge = 0;
        int hours = 0;
        

        for (int i = 0; i < args.length; i++) 

        {
            hours = Integer.parseInt(args[i]);

                if (hours <= 24)
            {
                if (hours >= 0 && hours < 3) {
                amountCharge = 4;
                } else if (hours < 5) {
                amountCharge = 4 + (hours - 2) * 3;
                } else if (hours < 18) {
                amountCharge = 10 + (hours - 4) * 1;
                } else {
                amountCharge = 24;
                }
            }   
             
                else 
            {
                int hours1 = hours;
                int day = hours / 24;
                hours1 = hours % 24;
                if (hours1 >= 0 && hours1 < 3) {
                amountCharge = 4;
                } else if (hours1 < 5) {
                amountCharge = 4 + (hours1 - 2) * 3;
                } else if (hours1 < 24) {
                amountCharge = 14 + (hours1 - 4) * 1;
                } else {
                amountCharge = 24; 
                }
                amountCharge += day * 24; 
            
            }

                System.out.println("parking for" + hours + "hrs, pay" + amountCharge + "baht.");

        }
    }
}


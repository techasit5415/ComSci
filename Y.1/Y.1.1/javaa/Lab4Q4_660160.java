public class Lab4Q4_660160 {
    public static void main(String[] args) {
        int k = 3;

        int count = 0;
        int number = 1;

        while (count < k) 
        {
            int sum = 0;
            for (int i = 1; i < number; i++) 
            {
                if (number % i == 0) 
                {
                    sum += i;
                }
            }

            if (number == sum) 
            {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
}
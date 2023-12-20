public class cc {
    public static void main(String[] args)
    {
        int[][] prices = {
            {250, 400, 350},
            {400, 600, 350},
            {200, 400, 250}
        };
        String[] cityDest = {"Denver", "Edmonton", "Fargo"};
        int n = cityDest.length;
        int caseID = 1;
        int caseCost = 0;
        int bestDest_i = 0;
        int bestDest_j = 0;
        int bestDest_k = 0;
        int minCost = Integer.MAX_VALUE;
        
        for (int if_Go_i = 0; if_Go_i < n; if_Go_i++) {
            for (int if_Go_j = 0; if_Go_j < n; if_Go_j++) {
                for (int if_Go_k = 0; if_Go_k < n; if_Go_k++) {
                    if (if_Go_i != if_Go_j && if_Go_i != if_Go_k && if_Go_j != if_Go_k) {
                        System.out.print("case id " + caseID++ + " -> ");
                        System.out.print("Aus goes " + cityDest[if_Go_i] + " ");
                        System.out.print("Bos goes " + cityDest[if_Go_j] + " ");
                        System.out.print("Chi goes " + cityDest[if_Go_k] + " ");
                        caseCost = prices[0][if_Go_i] + prices[1][if_Go_j] + prices[2][if_Go_k];
                        System.out.println("cost = " + caseCost);
                        if (caseCost < minCost) {
                            minCost = caseCost;
                            bestDest_i = if_Go_i;
                            bestDest_j = if_Go_j;
                            bestDest_k = if_Go_k;
                        }
                    }
                }
            }
        }
        
        System.out.println("-Ans-----");
        System.out.println("Austin goes " + cityDest[bestDest_i]);
        System.out.println("Boston goes " + cityDest[bestDest_j]);
        System.out.println("Chicago goes " + cityDest[bestDest_k]);
        System.out.println("cost = " + minCost);
        System.out.println("bestDest_i"+bestDest_i);
        System.out.println("bestDest_j"+bestDest_j);
        System.out.println("bestDest_k"+bestDest_k);
        
    }
}

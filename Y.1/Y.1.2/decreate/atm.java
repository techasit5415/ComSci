public class atm {
    
    public static int useBanknotes1000;
    public static int useBanknotes500;
    public static int useBanknotes100;

    public atm(String user) {
        System.out.println("hi : " + user);
    }

    public void withdraw(int money) {
        
        System.out.println("Initial money: " + money);
        int cal1000 = calculator1000(money);
        int cal500 = calculator500(cal1000);
        int cal100 = calculator100(cal500);

        System.out.println("Banknotes of 1000 : " + useBanknotes1000);
        System.out.println("Banknotes of 500  : " + useBanknotes500);
        System.out.println("Banknotes of 100  : " + useBanknotes100);
        System.out.println("remaining         : " + cal100);

    }

    public int calculator1000(int m) {
        int banknote;
        for (banknote = 0; m >= 1000; banknote++) {
            m -= 1000;
        }
        useBanknotes1000 = banknote;
        return m;
    }

    public int calculator500(int m) {
        int banknote;
        for (banknote = 0; m >= 500; banknote++) {
            m -= 500;
        }
        useBanknotes500 = banknote;
        return m;
    }

    public int calculator100(int m) {
        int banknote;
        for (banknote = 0; m >= 100; banknote++) {
            m -= 100;
        }
        useBanknotes100 = banknote;
        return m;
    }
}
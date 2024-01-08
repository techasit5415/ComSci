public class programmer {
    public int Banknotes1000;
    public int Banknotes500;
    public int Banknotes100;

    public programmer(String user) {
        System.out.println("Hi : " + user);

    }

    public void remain() {
        Banknotes1000 -= atm.useBanknotes1000;
        Banknotes500 -= atm.useBanknotes500;
        Banknotes100 -= atm.useBanknotes100;
        System.out.println("remaining Banknotes1000 : " + Banknotes1000);
        System.out.println("remaining Banknotes500  : " + Banknotes500);
        System.out.println("remaining Banknotes100  : " + Banknotes100);
    }

    public void setBanknotes1000(int banknotes1000) {
        Banknotes1000 = banknotes1000;
    }

    public void setBanknotes500(int banknotes500) {
        Banknotes500 = banknotes500;
    }

    public void setBanknotes100(int banknotes100) {
        Banknotes100 = banknotes100;
    }

}

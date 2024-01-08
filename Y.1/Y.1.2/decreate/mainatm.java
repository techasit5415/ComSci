public class mainatm {
    public static void main(String[] args) {

        deposite();
    }

    static void deposite() {
        atm d1 = new atm("eiei");
        d1.withdraw(600);
        programmer p1 = new programmer("programmer");
        p1.setBanknotes1000(20);
        p1.setBanknotes500(20);
        p1.setBanknotes100(100);
        p1.remain();

    }
}

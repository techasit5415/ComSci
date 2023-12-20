public class Person_660160 {

    String name;
    int saving;

    Person_660160(String n, int amount) {
        name = n;
        saving = amount;
    }

    void introduce_self() {
        System.out.println("Hi,My name is " + name);
    }

    @Override
    public String toString() {
        return "I am " + name + ". Mysavings amount is " + saving;
    }

    boolean isWealthier(Person_660160 p) {
        return this.saving >= p.saving;
    }

    public boolean equals(Object q) {
        Person_660160 p = (Person_660160) q;
        return this.name.equals(p.name) && this.saving == (p.saving);
    }

    int reward(Person_660160 p, int amount) {
        this.saving -= amount;
        p.saving += amount;
        return amount;

    }
}

interface CanSwim {
    abstract public void swim();
}
class Main implements CanSwim {
    public static void main(String[] args) {
 
    }
    static void demo2() {
        CanSwim obj3 = new CanSwim() { // anonymous 
            public void swim() {
                System.out.println("From D");
            }
        };
        obj3.swim();

        CanSwim obj4 = () -> System.out.println("From E"); // lambda
        obj4.swim();
    }
    static void demo1() {
        C obj1 = new C();
        obj1.swim();
        Main obj2 = new Main();
        obj2.swim();
    }
    public void swim() {
        System.out.println("From M");
    }
}
class C implements CanSwim {
    public void swim() {
        System.out.println("From C");
    }
}
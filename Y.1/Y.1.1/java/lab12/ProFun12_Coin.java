class ProFun12_Coin {
    public static void main(String[] args) {
        demo_1_instantiation();
        demo2_hit();
        demo3_overloaded_hit();
        // demo4_non_oop_static_way();
    }
    static void demo3_overloaded_hit(){
        System.out.println("-demo overloaded method (from demo2)");
        Coin c1 = new Coin("Burgandy");
        Coin c2 = new Coin("Cabala");
        Coin c3  = new Coin("Danube");
        c1.hit(c2,c3);
    }
    static void demo2_hit(){
        System.out.println("-demo object interaction--");
        Coin c1 = new Coin("Burgandy");
        Coin c2 = new Coin("Cabala");
        Coin c3 = new Coin("Danube");
    
        c1.hit(c2);
        c1.hit(c3);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        
    }
    static void demo_1_instantiation(){
        System.out.println("-demo instantiation and call object method--");
        Coin c1 = new Coin("Burgandy");
        Coin c2 = new Coin("Cabala");
        Coin c3 = new Coin("Danube");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        c2.filp();
        System.out.println(c2);
    }
    // static void demo4_non_oop_static_way() {
    //     Coin c1 = new Coin("Burgandy");
    //     Coin c2 = new Coin("Cabala");
    //     static_hit(c1, c2);
    // }
    // static void static_hit(Coin c1, Coin c2) {
    //     if (c1.isHead)
    //         System.out.println("From flip() -> I am head my color is SILVER (my tailColor is " + c1.tailColor + ")");
    //     else
    //         System.out.println("From flip() -> My face color is " + c1.tailColor);
    //     c1.isHead = !c1.isHead;
    //     if (c2.isHead)
    //         System.out.println("From flip() -> I am head my color is SILVER (my tailColor is " + c2.tailColor + ")");
    //     else
    //         System.out.println("From flip() -> My face color is " + c2.tailColor);
    //     c2.isHead = !c2.isHead;
    // }
}
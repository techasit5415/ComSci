public class lec5{
    public static void main(String[] args) {
        demo1();
    }
    public static void demo1(){
        Duck d1 = new Duck();
        d1.swim();
        d1.method3();
        InterfaceCanSwim.method3();
        // d1.a = 7;
        // Duck.b = 8;
        // Duck.method2();
    }
    interface InterfaceCanSwim{
        
        public abstract void swim();
        default void method5(){method4();}
        default void method3(){}
        private void  method4(){}
    }
    class Duck implements InterfaceCanSwim{
        public void swim(){
            System.out.println("from duck");
        }
    }
    class Fish implements InterfaceCanSwim{
        public void swim(){
            System.out.println( "form fish");
        }
    }
}
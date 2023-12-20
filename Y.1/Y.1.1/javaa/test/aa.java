package test;

public class aa {
    public static void main(String[] args) {
        method1();
    }

    static void method1() {
        Demo d1 = new Demo(2, 3);
        //Demo d2 = new Demo(3, 4);
        System.out.println(d1.attr1);
    }

    
    static class Demo {
        int attr1;
        int attr2;

        Demo(int x, int y) {
            attr1 = x;
            attr2 = y;
        }

        void say_hi() {
            //int Z;
            for (int i = 0; i < 10; i++) {
                // Do something
            }
        }
    }
}

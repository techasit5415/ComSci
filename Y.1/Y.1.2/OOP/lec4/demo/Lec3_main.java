public class Lec3_main {
    public static void main(String[] args) {
        demo3();
    }

    static void demo1() {
        Programmer p1 = new Programmer();
        p1.name = "haha";
        System.out.println(p1.getName());
        p1.vacation();
    }

    static void demo2() {
        Sales s1= new Sales();
        s1.name = "haha";
        s1.fingerScanIn();
        s1.fingerScanOut();
        s1.test();
    }
    static void demo3(){
        Accountant a1 = new Accountant();
        a1.name = "haha";
        a1.vacation();
        a1.fingerScanIn();
        a1.fingerScanOut();
    }
}
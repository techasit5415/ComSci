public class lec7 {
 public static void main(String[] args) {
    
 }
 static void demo1(){
    Talipia t1 = new Talipia("smooth");
    Parrot p1 = new Parrot("abc");

 }  
 static void demo2(){
    Aquatic a1 = new Aquatic("Smooth");
    Talipia t1 = new Talipia("Smooth");
    a1.method1();//from talipia
    t1.onlyTalipia();
    ((Talipia)a1).onlyTalipia();//downcasting
 } 
 static void demo3(){
    canSwim nemo = new canSwim() {
        public void swim(){
            System.out.println("from crown fish");
        }
    };
    nemo.swim();
 }
 canSwim seaHorse = () ->{System.out.println("sea horse");};
}

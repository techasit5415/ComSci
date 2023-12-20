public interface DoAllThese {
    
    public void fingerScanIn();
    public abstract void fingerScanOut();
    public default void test(){
        System.out.println("test");
    }
}
class Accountant extends Emp implements DoAllThese{
    public String toString(){
        return"";
    }
    public String getName(){
        return "fromAccountant";
    }
    void vacation(){
        System.out.println("from Accountant vacation");
    }
    public void fingerScanIn(){
        System.out.println(name + (" arrives"));
    }
    public void fingerScanOut(){
        System.out.println("going homed happily");
    }
}




class Sales implements DoAllThese {
    String name;
    public void fingerScanIn() {
        System.out.println("welcome " + name);
    }

    public void fingerScanOut() {
        System.out.println("have a good evening");
    }
}

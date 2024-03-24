public class lecs9<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    public static void main(String[] args) {
        lecs9<String> type = new lecs9<>();
        type.setT("Pankaj");
        String str = (String)type.getT();
        System.out.println(str);
System.out.println("----------------------------");
        lecs9 type1 = new lecs9();
        type1.setT("pankaj");
        System.out.println(type1.getT());
        type1.setT("10");
        System.out.println(type.getT());
    }
}
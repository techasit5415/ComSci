public class printer <T>{
    T sth;

    public void sett(T sth){
        this.sth = sth;
        
    }
    public void print(){
        System.out.println("from printer : " + sth);
    }



}

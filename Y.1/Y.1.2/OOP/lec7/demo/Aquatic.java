public class Aquatic{
    protected String skin;
    Aquatic(){}
    Aquatic(String s){
        skin = s;
    }
void method1(){
    System.out.println("form Aquatic");

}
void setSkin(String s){}
}
class Talipia extends Aquatic{
    Talipia(String s){
        super(s);
    }

    public void onlyTalipia() {
        System.out.println("yyy");
    }
}
class Parrot extends Aquatic{
    Parrot(String s){
        skin = s;
    }
}
interface canSwim{
    public void swim();
}
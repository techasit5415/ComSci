import java.util.ArrayList;
import packA.*;

public class Lab3 {
    public static void main(String[] args) {
        q1();
    }

    static void q1() {
        ArrayList<EmpTmp> aList = new ArrayList<>();
        aList.add(new Acountant("goodAtmyJob", 7, 6, 390, "sing"));
        aList.add(new Acountant("canRap", 4, 9, 480, "rap"));
        aList.add(new Salesperson("mr.saleperson", 5, 150, 5000));
        aList.add(new Salesperson("me.kayan", 3, 260, 9000));
        aList.add(new Programmer("keng", 2, 300));
        aList.add(new EmpTmp("invisible", 9, 120));

        System.out.println("Upcasting");
        for (EmpTmp e : aList)



            e.sayHi();
        System.out.println("Downcasting");
        for (EmpTmp e : aList) {

            String str;
            if (e instanceof Programmer) {
                str = ((Programmer) e).coding();
            } else if (e instanceof Salesperson) {
                str = ((Salesperson) e).makeQuotation();
            } else if (e instanceof Acountant) {
                str = ((Acountant) e).tellProfit();
            } else {
                continue;
            }
            System.out.println(str);
        }

    }
}

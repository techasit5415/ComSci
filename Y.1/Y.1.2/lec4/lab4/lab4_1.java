import java.util.ArrayList;

import packA.Employee;
import packA.Programmer;
import packA.ProgrammerManager;

public class lab4_1 {
    public static void main(String[] args) {
    q1();
    System.out.println("-------------------------");
    q2();
}

static void q1() {
    ProgrammerManager pmanager = new ProgrammerManager("CodeReviewer", 9, 550);
    System.out.println(pmanager);

    Employee e = pmanager;
    e.sayHi();
}

static void q2() {
    ProgrammerManager pmanager = new ProgrammerManager("CodeReviewer", 9, 550);

    ArrayList<Programmer> alist = new ArrayList<>();
    alist.add(new Programmer("Keng", 2, 300));
    alist.add(new Programmer("Somsri", 3, 400));
    alist.add(new Programmer("haha", 4, 600));

    for (Programmer p : alist) {
        int newSalary = pmanager.evaluate(p);
        System.out.println(newSalary);
    }
}
}

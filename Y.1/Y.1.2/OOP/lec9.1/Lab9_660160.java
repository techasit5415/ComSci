import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Lab9_660160 {
    static ArrayList<Employee> empList;
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        q6();
        q7();
        q8();
        q9();
        q10();
        q11();
        q12();
        q13();
        q14();
        q15();
    }

    static void ex1() {
        Employee emp1 = new Employee("yindee");
        Employee emp2 = new Employee("yindee");
        int id1 = emp1.hashCode();
        int id2 = emp2.hashCode();
        String s1 = Integer.toHexString(id1);
        String s2 = Integer.toHexString(id2);
        System.out.println(s1);
        System.out.println(s2 + " " + s1.compareTo(s2));
    }

    static void ex2() {
        Employee emp1 = new Employee("preeda");
        System.out.println(emp1);
        ex2_1(emp1);
        System.out.println(emp1);
    }
    private static void ex2_1(Employee e) {
        e.setName("aba abi abo abe");
    }

    static void ex3() {
        ArrayList <Employee> singers = new ArrayList<>();
        singers.add(new Employee("aba"));
        singers.add(new Employee("abi"));
        singers.add(new Employee("abo"));
        singers.add(new Employee("abe"));

        ex3_1(singers);
        System.out.println(singers.get(0));
        System.out.println(singers);
    }
    private static void ex3_1(List<Employee> list) {
        list.get(0).setName("cha cha cha");
        list = new ArrayList<>();
    }

    static void ex4() {
        ArrayList<Employee> singers = new ArrayList<>();
        singers = ex4_1();
        System.out.println(singers);
    }
    private static ArrayList<Employee> ex4_1( /*List<Employee> list */ ) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("aba"));
        list.add(new Employee("abi"));
        return (ArrayList<Employee>) list;
    }

    static void ex5() {
        ArrayList<Employee> singers = new ArrayList<>();
        singers.add(new Employee("aba"));
        singers.add(new Employee("abi"));
        singers.add(new Employee("abo"));
        singers.add(new Employee("abe"));
        @SuppressWarnings("unchecked")
        List<Employee> tmp = (ArrayList<Employee>)singers.clone();
        tmp.get(0).setName("cha");
        System.out.println(singers);
        tmp = new ArrayList<>(singers);
        tmp.get(1).setName("cha cha");
        System.out.println(singers);
        tmp = singers.subList(0, singers.size() - 1);
        tmp.get(2).setName("cha cha cha");
        System.out.println(tmp);
    }

    static void q6() {
        List<Employee> singers1 = new ArrayList<Employee>(
        Arrays.asList(new Employee("aba"), new Employee("abi")));
        List<Employee> singers2 = new ArrayList<>();
        singers2.add(new Employee("abo"));
        singers2.add(new Employee("abe"));
        List<Employee> join = q6_1(singers1, singers2);
        System.out.println(singers1);
        System.out.println(singers2);
        System.out.println(join);
        singers1.addAll(singers2);
        System.out.println(singers1);
    }
    private static List<Employee> q6_1(List<Employee> l1, List<Employee> l2) {
        List<Employee> tmp = new ArrayList<>(l1);
        for(Employee e : l2) {
            tmp.add(e);
        }
        return tmp;
    }

    static void q7() {
        List<Employee> singers = Arrays.asList(new Employee("aba"), new Employee("abi"));
        System.out.println(singers);
        singers = q7_1(singers);
        System.out.println(singers);
    }
    private static List<Employee> q7_1(List<Employee> list) {
        List<Employee> tmp = new ArrayList<>(list);
        tmp.remove(1);
        return tmp;
    }
    
    static void q8() {
        List<Employee> list1 = Arrays.asList(new Employee("yindee"), new Employee("pramote"));
        List<Employee> list2 = Arrays.asList(new Employee("pramote"), new Employee("preeda"));
        Set<Employee> empSet;
        empSet = new HashSet<>(list1);
        for(Employee el : list2) {
            for(Employee el1 : list1) {
                if(el1.getName() == el.getName()) {
                    empSet.remove(el1);
                    empSet.add(el);
                }
                else {
                    empSet.add(el);
                }
            }
        }
        List<Employee> q8_ans = new ArrayList<>(empSet);
        System.out.println(q8_ans);
    }

    static void q9() {
        Set<Employee> empSet1 = new HashSet<>(Arrays.asList(new Employee("yindee"), new Employee("preeda"), new Employee("pramote")));
        Set<Employee> empSet2 = new HashSet<>(Arrays.asList(new Employee("yindee"), new Employee("pramote")));
        Set<String> eset1 = new HashSet<>();
        Set<String> eset2 = new HashSet<>();
        for(Employee eS1 : empSet1) {
            eset1.add(eS1.getName());
        }
        for(Employee eS2 : empSet2) {
            eset2.add(eS2.getName());
        }
        eset1.retainAll(eset2);
        empSet1.clear();
        for(String eS3 : eset1) {
            empSet1.add(new Employee(eS3));
        }
        System.out.println(empSet1);
    }

    static void q10() {
        Set<Employee> empSet1 = new HashSet<>(Arrays.asList(new Employee("yindee"), new Employee("preeda"), new Employee("pramote")));
        Set<Employee> empSet2 = new HashSet<>(Arrays.asList(new Employee("yindee"), new Employee("pramote")));
        Set<String> eset1 = new HashSet<>();
        Set<String> eset2 = new HashSet<>();
        for(Employee e1 : empSet1) {
            eset1.add(e1.getName());
        }
        for(Employee e2 : empSet2) {
            eset2.add(e2.getName());
        }
        eset1.removeAll(eset2);
        empSet1.clear();
        for(String e3 : eset1) {
            empSet1.add(new Employee(e3));
        }
        System.out.println(empSet1);
    }

    static void q11() {
        Set<Employee> empSet = new HashSet<>(Arrays.asList(new Employee("yindee"), new Employee("preeda"), new Employee("promote"), new Employee("preeda")));
        Employee[] q11_ans = new Employee[empSet.size()];
        int i = 0;
        for(Employee eS1 : empSet) {
            q11_ans[i] = eS1;
            i++;
        }
        for (Employee e : q11_ans)
            System.out.print(e + " ");
        System.out.println();
    }

    static {
        empList = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("packExercise//names.csv"))) {
            input.nextLine(); // skip first row
            while (input.hasNext()) {
                String row = input.nextLine().trim();
                empList.add(new Employee(row));
            }
            System.out.println("There are " + empList.size() +" employees.");
        } catch (IOException e) { e.printStackTrace(); } 
    }

    static void q12() {
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(empList.get(i).getName(), empList.get(i));
        }
        System.out.println(map);
    }

    static void q13() {
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(empList.get(i).getName(), empList.get(i));
        }
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        System.out.println(keySet);
    }

    static void q14() {
        PriorityQueue<Employee> PQ = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        PQ.addAll(empList);
        List<Employee> q14_ans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            q14_ans.add(PQ.poll());
        }
        System.out.println(q14_ans);
    }

    static void q15() {
        int sum = 0;
        int cnt = 0;
        Iterator<Employee> it;
        Long pqStart = System.nanoTime(); // System.currentTimeMillis();
        sum = 0;
        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        pq.addAll(empList);
        it = pq.iterator();
        while (it.hasNext()) {
            sum += it.next().getSalary();
            cnt++;
        }
        System.out.println("PQ (" + sum + ") takes " + String.format("%,d", System.nanoTime() - pqStart));
        Long listStart = System.nanoTime();
        ArrayList<Employee> clone = new ArrayList<>();
        sum = 0;
        clone.addAll(empList);
        Collections.sort(clone, (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        it = clone.iterator();
            while (it.hasNext()) {
            sum += it.next().getSalary();
            cnt--;
        }
        System.out.println("ArrayList (" + sum + ") takes " + String.format("%,d", System.nanoTime() - listStart));
        if (cnt != 0)
            System.out.println("error on number of elements");
    }
}   
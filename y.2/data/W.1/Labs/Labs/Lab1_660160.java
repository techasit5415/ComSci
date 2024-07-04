
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import solutions.pack1.Breed_660160;
import solutions.pack1.Dog_660160;

//import solutions.pack1.*;

public class Lab1_660160 {
    public static void task1() {
        System.out.println("--task1---");
        ArrayList<String> lis1a = new ArrayList<>(Arrays.asList("Lily","Daisy"));
        ArrayList<String> lis1b = new ArrayList<>(Arrays.asList("Tulip","Daisy"));
        ArrayList<String> lis1c;
        lis1c=new ArrayList<>(lis1a);
        lis1c.addAll(lis1b);
        /* your code */
        System.out.println(lis1c); 
        System.out.println(lis1a);
    }
    public static void task2() {
        System.out.println("--task2---");
        ArrayList<StringBuilder> lis1a = new ArrayList<>(Arrays.asList(new StringBuilder("Lily"), new StringBuilder( "Daisy")));
        ArrayList<StringBuilder> lis1b = new ArrayList<>(lis1a);
        lis1b.add(new StringBuilder("30"));        
        System.out.println(lis1b); 
        System.out.println(lis1a);  // Original data seems not affected
        StringBuilder sb = lis1a.get(0);
        sb.append("mySuffix");
        // Does lis2b.get(0) object change? Or it is not affected. Check it yourself.
        // complete the task by display "shallow copy" if lis2b first element is affected.
        /* your code */
    }
    public static void task3() {
        System.out.println("--task3---");
        List<String> lis3 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));

        String tmp = lis3.get(0);
        lis3.clear();
        lis3.add(tmp);

        // lis3.subList(1,lis3.size()-1);
        // for(int i = 1; i<lis3.size(); i++){
        //     lis3.remove(lis3.get(i));
        // }
        /* your code */
        System.out.println(lis3);
    }
    public static void task4() { // show unique elements
        System.out.println("--task4---");
        // ArrayList<String> lis1 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        List<String> lis4a = Arrays.asList("Lily","Daisy","Tulip","Daisy");
        HashSet<String> flowers = new HashSet<>(lis4a);
        for (String ele : flowers) {
            System.out.print(ele + " ");
        }
        System.out.println();
        ArrayList<Dog_660160> lis4b = new ArrayList<>(Arrays.asList(new Dog_660160(Breed_660160.pomeranian,1200), new Dog_660160(Breed_660160.beagle, 2300), new Dog_660160(Breed_660160.jack, 1440), new Dog_660160(Breed_660160.beagle,2300)));
        HashSet<Dog_660160> dogs = new HashSet<>(lis4b);
        for (Dog_660160 ele : dogs) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    static void task5() { // dog breed frequency 
        System.out.println("--task5---");
        ArrayList<Dog_660160> lis5 = new ArrayList<>(Arrays.asList(new Dog_660160(Breed_660160.pomeranian,1200), new Dog_660160(Breed_660160.beagle, 2300), new Dog_660160(Breed_660160.jack, 1440), new Dog_660160(Breed_660160.beagle,2300)));
        HashMap<Breed_660160,Integer> map = new HashMap<>();
        /* your code */
        for(Dog_660160 d :lis5){
            map.putIfAbsent(d.getB(),0);
            map.put(d.getB(),map.get(d.getB())+1);
        }
        for (Entry<Breed_660160, Integer> ele : map.entrySet()) {
            System.out.println(ele.getKey() + "\t" + ele.getValue());
        }
    }
    static void task6() { // number of unique elements
        System.out.println("--task6---");
        System.out.print("The number of unique element is ");
        ArrayList<Dog_660160> lis6 = new ArrayList<>(Arrays.asList(new Dog_660160(Breed_660160.pomeranian,1200), new Dog_660160(Breed_660160.beagle, 2300), new Dog_660160(Breed_660160.jack, 1440), new Dog_660160(Breed_660160.beagle,2300)));        
        /* your code */
        HashSet<Dog_660160> UQDogs = new HashSet<>(lis6);
        System.out.println(UQDogs.size());
    }
    public static void main(String[] args) {
        System.out.println("hello");
        
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task4a();
    }
    static int N = 10_000;
    static Integer [] arr = new Integer [N];
    static int num_iter = 100_000 * 10;
    static ArrayList<Integer> lis = new ArrayList<>();
    static LinkedList<Integer> llis;
    static {
        for (int i = 0; i < N; i++) {
            lis.add(i);
        }
        Collections.shuffle(lis);
        lis.toArray(arr);
        llis = new LinkedList<>(lis);
    }
    static void demo_arrayList(int idx) {
        long start = System.currentTimeMillis();
        for (int iter = 0; iter < num_iter; iter++) {
        }
        long time = (System.nanoTime() - start);
        System.out.println("|ArrayList \t|\ttakes " + time);
    }
    static void demo_linkedList(int idx) {
        int value;
        long start = System.currentTimeMillis();
        for (int iter = 0; iter < num_iter; iter++) {
            value = llis.get(idx);
        }
        long time = (System.currentTimeMillis() - start);
        System.out.println("|LinkedList \t|\ttakes " + time);
        /* your code */
    }
    static void demo_array(int idx) {
        int value;
        long start = System.currentTimeMillis();
    for (int iter = 0; iter < num_iter; iter++) {
        value = arr[idx];
    }
    long time = (System.currentTimeMillis() - start);
    System.out.println("|Array     \t|\ttakes " + time);
        /* your code */
    }
    static void task4a() {
        for (int index = 0; index < arr.length; index += arr.length/4) {
            System.out.println("+---------------+-----------------------------+");
            System.out.println("|Index is at    |\t" + index);
            demo_arrayList(index);
            demo_linkedList(index);
            demo_array(index);
            
        }
        System.out.println("+---------------+-----------------------------+");
    }
}

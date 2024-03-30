import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // consumer<T> one para return nothing (.accept())
        // predicate<T> one para return boolean (.test())
        // function<T,R> one prara return R (.apply())
        // supplier<R> no para , return R (.get())

        List<Meat> MeatForSell = Arrays.asList(new Meat("beff" ,500), new Meat("pork", 600), 
                new Meat("Dog", 200), new Meat("Chicken",100));

        List<String> result = MeatForSell.stream()
            .filter(e -> e.getPrice() < 500)
            .sorted()
            .map(e -> e.getMeatType())
            .collect(Collectors.toList());

        result.forEach(System.out::print);

    //     int ExpensiveMeat = MeatForSell.stream()
    //         .map(e -> e.getPrice())
    //         .max(Integer::compare)
    //         .orElse(0);
        
    //     System.out.println("expensive" + " " + ExpensiveMeat);
    }
}

class Meat {
    String type;
    int price;
    public Meat(String name,int price) {
        this.price = price;
        this.type = name;
    }

    public int getPrice() {
        return this.price;
    }
    public String getMeatType() {
        return this.type;
    }
}
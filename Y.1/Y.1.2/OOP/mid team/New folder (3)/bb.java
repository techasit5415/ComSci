public class bb {

}

class Super {
    public void superMethod(int n) {
        System.out.println("from super");
    }
}

class Sub extends Super {
    public void superMethod(double n) {
        System.out.println("from sub");
    }
}



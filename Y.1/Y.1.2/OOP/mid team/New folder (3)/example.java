public class example {
    public static void main(String[] args) {
        Sub subObject = new Sub();

        // Calls the overridden method in the Sub class
        // subObject.superMethod(3.14);

        // Calls the method in the Super class
        // (since there is no method in the Sub class that takes an int)
        subObject.superMethod(0);
    }
}
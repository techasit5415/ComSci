public class shapeDemo {
    class Shape {
        public void shape() {
            System.out.println("from parent");
        }
    }

    class Triangle extends Shape {
        @Override
        public void shape() {
            System.out.println("from sub");
        }
    }

    public static void main(String[] args) {
        // Create an instance of Triangle
        Triangle o1 = new Triangle();

        // Assign the Triangle instance to a reference of type Shape
        Shape s1 = o1;

        // Call the shape method using the Shape reference
        s1.shape();  // This will invoke the overridden method in Triangle
    }
}

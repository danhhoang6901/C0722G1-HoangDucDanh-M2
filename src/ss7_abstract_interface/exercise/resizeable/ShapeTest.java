package ss7_abstract_interface.exercise.resizeable;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(2.0);
        shape[1] = new Rectangle(2, 3);
        shape[2] = new Square(4);
        for (Shape shape1 : shape) {
            shape1.resize(Math.floor(Math.random() * 100));
            System.out.println(shape1);
        }
    }
}

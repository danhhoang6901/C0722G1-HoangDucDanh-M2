package ss7_abstract_interface.exercise.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(2.0);
        shape[1] = new Square(4.0);
        shape[2] = new Rectangle(3, 4);

        for (Shape shapes : shape) {
            System.out.println(shapes);
            if (shapes instanceof Square) {
                IColorable iColorable = (Square) shapes;
                iColorable.howToColor();
            }
        }
    }
}

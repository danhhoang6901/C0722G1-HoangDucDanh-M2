package ss6_inheritance.exercise.circle_cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(3.0, "red");
        System.out.println(circle);
        Circle circle1 = new Circle();
        circle1.setRadius(2.0);
        circle1.setColor("blue");
        System.out.println(circle1);
        System.out.println("Area circle = " + circle.getArea());
        System.out.println("Area circle1 = " + circle1.getArea());
    }
}

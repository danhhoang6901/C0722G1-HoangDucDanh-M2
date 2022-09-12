package ss5_static_access_modifier.circle;

import ss5_static_access_modifier.circle.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(2.0);
        Circle circle1 = new Circle();
        System.out.println("Radius circle1 = " + circle1.getRadius() + ", color circle1 = " + circle1.getColor());
        System.out.println("Area circle1 = " + circle1.getArea());
        System.out.println("Radius circle = " + circle.getRadius() + ", color circle = " + circle.getColor());
        System.out.println("Area circle = " + circle.getArea());
        circle.setRadius(3.0);
        circle.setColor("blue");
        System.out.println("Radius circle = " + circle.getRadius() + ", color circle = " + circle.getColor());
        System.out.println("Area circle = " + circle.getArea());
    }
}

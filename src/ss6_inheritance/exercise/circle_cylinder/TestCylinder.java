package ss6_inheritance.exercise.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3.0, "red", 2.0);
        System.out.println(cylinder);
        System.out.println("Volume = " + cylinder.getVolume());
        System.out.println("Area = " + cylinder.getArea());
        Cylinder cylinder1 = new Cylinder(4.0);
        System.out.println(cylinder1);
        Cylinder cylinder2 = new Cylinder();
        cylinder2.setHeight(1.0);
        cylinder2.setRadius(1.0);
        cylinder2.setColor("yellow");
        System.out.println(cylinder2);
    }
}

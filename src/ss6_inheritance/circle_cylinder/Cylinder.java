package ss6_inheritance.circle_cylinder;

import ss6_inheritance.circle_cylinder.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(this.getRadius(), 2) * this.height;
    }


    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "} " + super.toString();
    }
}

package ss6_inheritance.point_movable_point;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint moveablePoint = new MovablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MovablePoint(2.0f, 3.0f, 4.0f, 5.0f);
        System.out.println(moveablePoint);
//        moveablePoint = new MoveablePoint(6.0f, 7.0f);
//        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}

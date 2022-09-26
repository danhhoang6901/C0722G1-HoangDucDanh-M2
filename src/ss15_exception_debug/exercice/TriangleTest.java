package ss15_exception_debug.exercice;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a;
        do {
            System.out.print("Nhập cạnh a: ");
            try {
                a = Double.parseDouble(scanner.nextLine());
                if (a < 0) {
                    throw new IllegalTriangleException("Giá trị nhập vào phải là số dương!");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        double b;
        do {
            System.out.print("Nhập cạnh b: ");
            try {
                b = Double.parseDouble(scanner.nextLine());
                if (b < 0) {
                    throw new IllegalTriangleException("Giá trị nhập vào phải là số dương!");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        double c;
        do {
            System.out.print("Nhập cạnh c: ");
            try {
                c = Double.parseDouble(scanner.nextLine());
                if (c < 0) {
                    throw new IllegalTriangleException("Giá trị nhập vào phải là số dương!");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        try {
            if (a + b < c || a + c < b || b + c < a) {
                throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
            }
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}

package ss15_exception_debug.exercice;

import java.util.Scanner;

public class exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;
        do {
            System.out.print("Nhập cạnh a: "+"\n");
            System.out.print("Nhập cạnh b: "+"\n");
            System.out.print("Nhập cạnh c: "+"\n");
            try {
                a = Double.parseDouble(scanner.nextLine());
                b = Double.parseDouble(scanner.nextLine());
                c = Double.parseDouble(scanner.nextLine());
                if (a < 0 || b < 0 || c < 0) {
                    throw new IllegalTriangleException("Giá trị nhập vào phải là số dương!");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}

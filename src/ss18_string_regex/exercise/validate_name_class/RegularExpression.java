package ss18_string_regex.exercise.validate_name_class;

import java.util.Scanner;

public class RegularExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameClass;
        do {
            System.out.print("Nhập tên lớp: ");
            try {
                nameClass = scanner.nextLine();
                if (!nameClass.matches("^[CAP][0-9]{4}[GHIKLM]$")) {
                    System.out.println("Không hợp lệ!");
                    break;
                }
                System.out.println("Hợp lệ");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}

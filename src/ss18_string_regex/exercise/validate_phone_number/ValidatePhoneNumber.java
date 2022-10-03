package ss18_string_regex.exercise.validate_phone_number;

import java.util.Scanner;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phone;
        do {
            System.out.print("Nhập số điện thoại: ");
            try {
                phone = scanner.nextLine();
                if (!phone.matches("^[(][0-9]{2}[)]-[(]0[1-9]{9}[)]")) {
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

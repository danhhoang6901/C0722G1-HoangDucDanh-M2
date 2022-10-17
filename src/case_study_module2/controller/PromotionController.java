package case_study_module2.controller;

import java.util.Scanner;

public class PromotionController {
    private static Scanner scanner = new Scanner(System.in);

    public static void promotionManagement() {
        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
            System.out.println("2. Danh sách hiển thị khách hàng nhận được voucher");
            System.out.println("3. Trở lại menu chính");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:

            }
        }
    }
}

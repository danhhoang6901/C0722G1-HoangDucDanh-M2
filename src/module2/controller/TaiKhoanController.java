package module2.controller;

import java.util.Scanner;

public class TaiKhoanController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG--");
            System.out.println("1. Tài khoản tiết kiệm");
            System.out.println("2. Tài khoản thanh toán");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    TaiKhoanTietKiemController.menuTaiKhoanTietKiem();
                    break;
                case 2:
                    TaiKhoanThanhToanController.menuTaiKhoanThanhToan();
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}
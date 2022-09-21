package bai_tap_them.bai_2.controller;

import bai_tap_them.bai_2.service.IMotorcycleService;
import bai_tap_them.bai_2.service.impl.MotorcycleService;

import java.util.Scanner;

public class MotorcycleController {
    private static Scanner scanner = new Scanner(System.in);
    private static IMotorcycleService motorcycleService = new MotorcycleService();

    public static void motorcycleManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ XE MÁY--");
            System.out.println("1. Thêm mới xe máy");
            System.out.println("2. Hiển thị danh sách xe máy");
            System.out.println("3. Xóa xe máy");
            System.out.println("4. Tìm kiếm theo biển kiểm soát");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    motorcycleService.addMotorcycle();
                    break;
                case 2:
                    motorcycleService.displayAllMotorcycle();
                    break;
                case 3:
                    motorcycleService.removeMotorcycle();
                    break;
                case 4:
                    motorcycleService.searchMotorcycle();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

package bai_tap_them.bai_2.controller;

import bai_tap_them.bai_2.service.ITruckService;
import bai_tap_them.bai_2.service.impl.TruckService;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Scanner;

public class TruckController {
    private static Scanner scanner = new Scanner(System.in);
    private static ITruckService truckService = new TruckService();

    public static void truckManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ XE TẢI--");
            System.out.println("1. Thêm mới xe tải");
            System.out.println("2. Hiển thị danh sách xe tải");
            System.out.println("3. Xóa xe tải");
            System.out.println("4. Tìm kiếm theo biển kiểm soát");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    truckService.addTruck();
                    break;
                case 2:
                    truckService.displayAllTruck();
                    break;
                case 3:
                    truckService.removeTruck();
                    break;
                case 4:
                    truckService.searchTruck();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

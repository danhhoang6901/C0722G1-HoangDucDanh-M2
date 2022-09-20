package bai_tap_them.bai_2.controller;

import java.util.Scanner;

public class TransportController {
    private static Scanner scanner = new Scanner(System.in);

    public static void managementProgram() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG--");
            System.out.println("1. Quản lý ô tô ");
            System.out.println("2. Quản lý xe tải ");
            System.out.println("3. Quản lý xe máy ");
            System.out.println("4. Thoát ");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CarController.carManagement();
                    break;
                case 2:
                    TruckController.truckManagement();
                    break;
                case 3:
                    MotorcycleController.motorcycleManagement();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }


}

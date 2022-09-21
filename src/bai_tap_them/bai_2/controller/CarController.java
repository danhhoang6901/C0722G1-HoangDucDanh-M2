package bai_tap_them.bai_2.controller;

import bai_tap_them.bai_2.service.ICarService;
import bai_tap_them.bai_2.service.impl.CarService;

import java.util.Scanner;

public class CarController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICarService carService = new CarService();

    public static void carManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ Ô TÔ--");
            System.out.println("1. Thêm mới ô tô");
            System.out.println("2. Hiển thị danh sách ô tô");
            System.out.println("3. Xóa ô tô");
            System.out.println("4. Tìm kiếm theo biển kiểm soát");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    carService.addCar();
                    break;
                case 2:
                    carService.displayALlCar();
                    break;
                case 3:
                    carService.removeCar();
                    break;
                case 4:
                    carService.searchCar();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }

}

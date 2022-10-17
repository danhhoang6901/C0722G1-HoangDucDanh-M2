package module2.controller;

import module2.service.ITaiKhoanTietKiemService;
import module2.service.impl.TaiKhoanTietKiemService;

import java.util.Scanner;

public class TaiKhoanTietKiemController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ITaiKhoanTietKiemService iTaiKhoanTietKiemService = new TaiKhoanTietKiemService();

    public static void menuTaiKhoanTietKiem() {
        while (true) {
            System.out.println("--QUẢN LÝ TÀI KHOẢN TIẾT KIỆM--");
            System.out.println("Chọn chức năng theo số để tiếp tục: ");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các tài khoản ngân hàng");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iTaiKhoanTietKiemService.addTaiKhoanTietKiem();
                    break;
                case 2:
                    iTaiKhoanTietKiemService.deleteTaiKhoanTietKien();
                    break;
                case 3:
                    iTaiKhoanTietKiemService.displayAllTaiKhoanTietKiem();
                    break;
                case 4:
                    iTaiKhoanTietKiemService.searchTaiKhoanTietKiem();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

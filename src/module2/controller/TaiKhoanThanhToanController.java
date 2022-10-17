package module2.controller;

import module2.service.ITaiKhoanThanhToanService;
import module2.service.impl.TaiKhoanThanhToanService;

import java.util.Scanner;

public class TaiKhoanThanhToanController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ITaiKhoanThanhToanService iTaiKhoanThanhToanService = new TaiKhoanThanhToanService();

    public static void menuTaiKhoanThanhToan() {
        while (true) {
            System.out.println("--QUẢN LÝ TÀI KHOẢN THANH TOÁN--");
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
                    iTaiKhoanThanhToanService.addTaiKhoanThanhToan();
                    break;
                case 2:
                    iTaiKhoanThanhToanService.deleteTaiKhoanThanhToan();
                    break;
                case 3:
                    iTaiKhoanThanhToanService.displayAllTaiKhoanThanhToan();
                    break;
                case 4:
                    iTaiKhoanThanhToanService.searchTaiKhoanThanhToan();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}


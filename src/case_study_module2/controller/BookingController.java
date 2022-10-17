package case_study_module2.controller;

import case_study_module2.service.IBookingService;
import case_study_module2.service.impl.BookingService;

import java.util.Scanner;

public class BookingController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IBookingService bookingService = new BookingService();

    public static void bookingManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ ĐẶT CHỖ--");
            System.out.println("1. Thêm đặt chỗ mới");
            System.out.println("2. Hiển thị danh sách đặt chỗ");
            System.out.println("3. Tạo hợp đồng mới");
            System.out.println("4. Hiển thị hợp đồng danh sách");
            System.out.println("5. Chỉnh sửa hợp đồng");
            System.out.println("6. Trở lại menu chính");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    bookingService.displayAllBooking();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

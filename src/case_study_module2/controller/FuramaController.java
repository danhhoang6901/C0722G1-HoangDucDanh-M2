package case_study_module2.controller;

import java.util.Scanner;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            try {
                System.out.println("--ỨNG DỤNG QUẢN LÝ KHU NGHỈ DƯỠNG FURAMA--");
                System.out.println("Chọn chức năng theo số để tiếp tục: ");
                System.out.println("1. Quản lý nhân sự");
                System.out.println("2. Quản lý khách hàng");
                System.out.println("3. Quản lý cơ sở ");
                System.out.println("4. Quản lý đặt chỗ ");
                System.out.println("5. Quản lý Quảng cáo ");
                System.out.println("6. Thoát");
                System.out.print("Chọn chức năng: ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        EmployeeController.employeeManagement();
                        break;
                    case 2:
                        CustomerController.customerManagement();
                        break;
                    case 3:
                        FacilityController.facilityManagement();
                        break;
                    case 4:
                        BookingController.bookingManagement();
                        break;
                    case 5:
                        PromotionController.promotionManagement();
                        break;
                    case 6:
                        System.out.println("Thoát chương trình");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn của bạn không đúng!"); 
                }
            }catch (NumberFormatException e){
                System.err.println("Không nhập chữ!");
            }
        }
    }
}
package case_study_module2.controller;

import case_study_module2.service.impl.CustomerService;
import case_study_module2.service.ICustomerService;

import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();

    public static void customerManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ KHÁCH HÀNG--");
            System.out.println("Chọn chức năng theo số để tiếp tục: ");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa khách hàng");
            System.out.println("4. Trở lại menu chính");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    customerService.displayAllCustomer();
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    customerService.editCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

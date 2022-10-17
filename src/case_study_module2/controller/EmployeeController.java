package case_study_module2.controller;

import case_study_module2.service.IEmployeeService;
import case_study_module2.service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeService();

    public static void employeeManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ NHÂN VIÊN--");
            System.out.println("Chọn chức năng theo số để tiếp tục: ");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm nhân viên mới");
            System.out.println("3. Chỉnh sửa nhân viên");
            System.out.println("4. Trở lại menu chính");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    employeeService.displayAllEmployee();
                    break;
                case 2:
                    employeeService.addEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}
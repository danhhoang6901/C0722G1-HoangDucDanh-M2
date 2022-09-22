package bai_tap_them.bai_1.controller;

import bai_tap_them.bai_1.service.IStudentService;
import bai_tap_them.bai_1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();

    public static void studentManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ HỌC VIÊN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục ): ");
            System.out.println("1. Thêm mới học viên");
            System.out.println("2. Xóa học viên");
            System.out.println("3. Xem danh sách học viên");
            System.out.println("4. Chỉnh sửa thông tin học viên");
            System.out.println("5. Tìm kiếm học viên theo id");
            System.out.println("6. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentService.addStudent();
                    break;
                case 2:
                    studentService.removeStudent();
                    break;
                case 3:
                    studentService.displayAllStudent();
                    break;
                case 4:
                    studentService.editStudent();
                    break;
                case 5:
                    studentService.searchStudentById();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

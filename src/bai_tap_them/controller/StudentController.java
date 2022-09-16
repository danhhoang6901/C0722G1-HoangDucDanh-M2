package bai_tap_them.controller;

import bai_tap_them.service.IStudentService;
import bai_tap_them.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService = new StudentService();

    public void studentManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ HỌC VIÊN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục ): ");
            System.out.println("1. Thêm mới học viên");
            System.out.println("2. Xóa học viên");
            System.out.println("3. Xem danh sách học viên");
            System.out.println("4. Quay lại");
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
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

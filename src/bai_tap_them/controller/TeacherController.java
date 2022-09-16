package bai_tap_them.controller;

import bai_tap_them.service.ITeacherService;
import bai_tap_them.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static Scanner scanner = new Scanner(System.in);
    private static ITeacherService teacherService = new TeacherService();

    public void teacherManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ GIẢNG VIÊN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục ): ");
            System.out.println("1. Thêm mới giảng viên");
            System.out.println("2. Xóa giảng viên");
            System.out.println("3. Xem danh sách giảng viên");
            System.out.println("4. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherService.addTeacher();
                    break;
                case 2:
                    teacherService.removeTeacher();
                    break;
                case 3:
                    teacherService.displayAllTeacher();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

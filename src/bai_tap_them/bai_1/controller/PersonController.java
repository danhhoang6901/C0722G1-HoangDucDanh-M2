package bai_tap_them.bai_1.controller;

import bai_tap_them.bai_1.service.exception.ExceptionCheck;

import java.util.Scanner;

public class PersonController {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN VÀ GIẢNG VIÊN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục ): ");
            System.out.println("1. Quản lý học viên ");
            System.out.println("2. Quản lý giảng viên ");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        StudentController.studentManagement();
                        break;
                    case 2:
                        TeacherController.teacherManagement();
                        break;
                    case 3:
                        System.out.println("Đã thoát khỏi chương trình");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn của bạn không đúng!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Không được nhập chữ!");
            }
        }
    }
}
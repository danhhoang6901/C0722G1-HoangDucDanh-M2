package bai_tap_them.controller;

import bai_tap_them.service.IStudentService;
import bai_tap_them.service.ITeacherService;
import bai_tap_them.service.impl.StudentService;
import bai_tap_them.service.impl.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentController studentController = new StudentController();
    private static TeacherController teacherController = new TeacherController();

    public void menuManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN VÀ GIẢNG VIÊN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục ): ");
            System.out.println("1. Quản lý học viên ");
            System.out.println("2. Quản lý giảng viên ");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentController.studentManagement();
                    break;
                case 2:
                    teacherController.teacherManagement();
                    break;
                case 3:
                    System.out.println("Đã thoát khỏi chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    public Teacher infoTeacher() {
        int id;
        do {
            System.out.print("Nhập id của giảng viên: ");
            id = Integer.parseInt(scanner.nextLine());
            if (id < 0) {
                System.out.println("Id không hợp lệ!");
            }
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.println("Id đã có trong danh sách!");
                }
            }
            break;
        } while (true);
        System.out.print("Nhập tên giảng viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String dateOfbirth = scanner.nextLine();
        String gender = "";
        do {
            boolean check = false;
            System.out.println("Giới tính: ");
            System.out.println("1. Nam ");
            System.out.println("2. Nữ ");
            System.out.println("3. Khác ");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    gender = "Nam";
                    check = true;
                    break;
                case 2:
                    gender = "Nữ";
                    check = true;
                    break;
                case 3:
                    System.out.print("Nhập giới tính khác: ");
                    gender = scanner.nextLine();
                    check = true;
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không đúng");
            }
            if (check) {
                break;
            }
        } while (true);
        String specialize = "";
        do {
            System.out.println("Chuyên môn giảng viên: ");
            System.out.println("1. Tutor");
            System.out.println("2. Intrucstor");
            System.out.println("3. Coach");
            System.out.println("4. Khác");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choice) {
                case 1:
                    specialize = "Tutor";
                    check = true;
                    break;
                case 2:
                    specialize = "Intrucstor";
                    check = true;
                    break;
                case 3:
                    specialize = "Coach";
                    check = true;
                    break;
                case 4:
                    System.out.print("Nhập chuyên môn khác của giảng viên: ");
                    specialize = scanner.nextLine();
                    check = true;
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        } while (true);
        Teacher teacher = new Teacher(id, name, dateOfbirth, gender, specialize);
        return teacher;
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    @Override
    public void removeTeacher() {
        System.out.print("Nhập id giảng viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                System.out.println("Bạn có muốn xóa giảng viên này?");
                System.out.println("Nhấn Y: Yes");
                System.out.println("Nhấn N: No");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    teachers.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy giảng viên!");
        }
    }

    @Override
    public void displayAllTeacher() {
        if (teachers.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        }
    }

    @Override
    public void editTeacher() {
        System.out.println("Nhập id giảng viên muốn chỉnh sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                Teacher teacher = this.infoTeacher();
                teachers.set(i, teacher);
                System.out.println("Chỉnh sửa thông tin giảng viên thành công");
                flagDelete = true;
                break;
            }

        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy giảng viên!");
        }
    }
}


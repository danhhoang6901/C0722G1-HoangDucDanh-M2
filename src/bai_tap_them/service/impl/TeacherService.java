package bai_tap_them.service.impl;

import bai_tap_them.model.Student;
import bai_tap_them.model.Teacher;
import bai_tap_them.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private List<Teacher> teachers = new ArrayList<>();

    public Teacher infoTeacher() {
        System.out.print("Nhập id của giảng viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên giảng viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String dateOfbirth = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập chuyên môn giảng viên: ");
        String specialize = scanner.nextLine();
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
}


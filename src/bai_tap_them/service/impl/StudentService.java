package bai_tap_them.service.impl;

import bai_tap_them.model.Student;
import bai_tap_them.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();

    public Student infoStudent() {
        System.out.print("Nhập id của học viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên học viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String dateOfbirth = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        System.out.print("Nhập điểm: ");
        double score = Double.parseDouble(scanner.nextLine());
        Student student = new Student(id, name, dateOfbirth, gender, nameClass, score);
        return student;
    }

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học viên thành công");
    }

    @Override
    public void removeStudent() {
        System.out.print("Nhập id học viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println("Bạn có muốn xóa học viên này?");
                System.out.println("Nhấn Y: Yes");
                System.out.println("Nhấn N: No");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    students.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy học viên!");
        }
    }

    @Override
    public void displayAllStudent() {
        if (students.size() == 0) {
            System.out.println("Danh sách trống");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

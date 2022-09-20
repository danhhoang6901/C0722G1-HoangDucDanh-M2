package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Danh", "06/09/2001", "Nam", "C07", 10));
    }

    public Student infoStudent() {
        int id;
        do {
            System.out.print("Nhập id của học viên: ");
            id = Integer.parseInt(scanner.nextLine());
            if (id < 0) {
                System.out.println("Id không hợp lệ!");
            }
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("Id đã có trong danh sách!");
                }
            }
            break;
        } while (true);
        System.out.print("Nhập tên học viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh theo định dạng dd/MM/yy: ");
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

    @Override
    public void editStudent() {
        System.out.println("Nhập id học viên muốn chỉnh sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                Student student = this.infoStudent();
                students.set(i, student);
                System.out.println("Chỉnh sửa thông tin học viên thành công");
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy học viên!");
        }
    }
}


package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.service.ITeacherService;
import bai_tap_them.bai_1.service.exception.ExceptionCheck;
import bai_tap_them.bai_1.util.teacher.ReadFileTeacher;
import bai_tap_them.bai_1.util.teacher.WriteFileTeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();
    private static final String SRC_TEACHER = "src\\bai_tap_them\\bai_1\\data\\teacher.csv";
//
//    static {
//        teachers.add(new Teacher(1, "HảiTT", "06/09/2001", "Nam", "Tutor"));
//    }

    public Teacher infoTeacher() {
        int id;
        do {
            System.out.print("Nhập id của giảng viên: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new ExceptionCheck("Id phải lớn hơn 0!");
                }
                for (Teacher teacher : teachers) {
                    if (teacher.getId() == id) {
                        throw new ExceptionCheck("Id đã có trong danh sách!");
                    }
                }
                break;
            } catch (ExceptionCheck e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String name;
        do {
            System.out.print("Nhập tên giảng viên: ");
            try {
                name = scanner.nextLine();
                if (!name.matches("^\\D{4,50}\\s*$")) {
                    throw new ExceptionCheck("Tên không hợp lệ!");
                }
                break;
            } catch (ExceptionCheck e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String dateOfbirth;
        do {
            System.out.print("Nhập ngày sinh theo định dạng dd/MM/yyyy: ");
            try {
                dateOfbirth = scanner.nextLine();
                if (dateOfbirth.matches("^(?:(?:31(\\\\/|-|\\\\.)(?:0?[13578]|1[02]))\\\\1|(?:(?:29|30)(\\\\/|-|\\\\.)(?:0?[13-9]|1[0-2])\\\\2))(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$|^(?:29(\\\\/|-|\\\\.)0?2\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\\\d|2[0-8])(\\\\/|-|\\\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\\\4(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$")) {
                    throw new ExceptionCheck("Ngày sinh phải đúng định dạng dd/MM/yyyy!");
                }
                break;
            } catch (ExceptionCheck e) {
                System.err.println(e.getMessage());
            }
        } while (true);

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
                    System.err.println("Lựa chọn của bạn không đúng");
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
                    System.err.println("Lựa chọn của bạn không đúng!");
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
        boolean swap = true;
        for (int k = 0; k < teachers.size() - 1 && swap; k++) {
            swap = false;
            for (int i = 0; i < teachers.size() - 1 - k; i++) {

                if (teachers.get(i).getName().compareTo(teachers.get(i + 1).getName()) > 0) {
                    swap = true;
                    Teacher temp = teachers.get(i + 1);
                    teachers.set(i + 1, teachers.get(i));
                    teachers.set(i, temp);
                }
            }
        }
        WriteFileTeacher.writeFileTeacher(SRC_TEACHER, teachers);
        System.out.println("Thêm mới giảng viên thành công");
    }

    @Override
    public void removeTeacher() {
        teachers = ReadFileTeacher.readFileTeacher(SRC_TEACHER);
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
                    WriteFileTeacher.writeFileTeacher(SRC_TEACHER, teachers);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.err.println("Không tìm thấy giảng viên!");
        }
    }

    @Override
    public void displayAllTeacher() {
        teachers = ReadFileTeacher.readFileTeacher(SRC_TEACHER);
        if (teachers.size() == 0) {
            System.err.println("Danh sách trống");
        } else {
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        }
    }

    @Override
    public void editTeacher() {
        teachers = ReadFileTeacher.readFileTeacher(SRC_TEACHER);
        System.out.println("Nhập id giảng viên muốn chỉnh sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                Teacher teacher = this.infoTeacher();
                teachers.set(i, teacher);
                WriteFileTeacher.writeFileTeacher(SRC_TEACHER, teachers);
                System.out.println("Chỉnh sửa thông tin giảng viên thành công");
                flagDelete = true;
                break;
            }

        }
        if (!flagDelete) {
            System.err.println("Không tìm thấy giảng viên!");
        }
    }
}


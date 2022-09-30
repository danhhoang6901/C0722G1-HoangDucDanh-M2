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
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();
    private static final String SRC_TEACHER = "src\\bai_tap_them\\bai_1\\data\\teacher.csv";

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
            System.out.print("Nhập họ tên giảng viên: ");
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
                if (!dateOfbirth.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                    throw new ExceptionCheck("Ngày sinh phải đúng định dạng dd/MM/yyyy!");
                }
                if (!checkDayMonthYear(dateOfbirth)) {
                    throw new ExceptionCheck("Ngày sinh không hợp lệ!");
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
                    System.out.print("Nhập giới tính: ");
                    gender = scanner.nextLine();
                    check = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
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
                    System.out.print("Nhập chuyên môn: ");
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

        return new Teacher(id, name, dateOfbirth, gender, specialize);
    }

    @Override
    public void addTeacher() {
        teachers = ReadFileTeacher.readFileTeacher(SRC_TEACHER);
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
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
            System.err.println("Danh sách trống!");
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

    @Override
    public void searchTeacher() {
        teachers = ReadFileTeacher.readFileTeacher(SRC_TEACHER);
        System.out.print("Nhập id giảng viên bạn muốn tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                System.out.println(teacher.toString());
                flag = true;
                break;
            }
            System.err.println("Không tìm thấy giảng viên!");
            System.out.print("Nhập tên giảng viên muốn tìm kiếm: ");
            String name = scanner.nextLine();
            for (Teacher teacher1 : teachers) {
                if (teacher1.getName().contains(name)) {
                    System.out.println(teacher1.toString());
                    flag = true;
                    break;
                }
            }
            break;
        }
        if (!flag) {
            System.err.println("Không tìm thấy giảng viên!");
        }
    }

    @Override
    public void sortTeacher() {
        teachers = ReadFileTeacher.readFileTeacher(SRC_TEACHER);
        boolean isSwap = true;
        for (int k = 0; k < teachers.size() - 1 && isSwap; k++) {
            isSwap = false;
            for (int i = 0; i < teachers.size() - 1 - k; i++) {
                if (teachers.get(i).getName().compareTo(teachers.get(i + 1).getName()) > 0) {
                    isSwap = true;
                    Teacher temp = teachers.get(i + 1);
                    teachers.set(i + 1, teachers.get(i));
                    teachers.set(i, temp);
                    WriteFileTeacher.writeFileTeacher(SRC_TEACHER, teachers);
                }
                if (teachers.get(i).getName().equals(teachers.get(i + 1).getName())) {
                    if (teachers.get(i).getId() > teachers.get(i + 1).getId()) {
                        isSwap = true;
                        Teacher temp = teachers.get(i + 1);
                        teachers.set(i + 1, teachers.get(i));
                        teachers.set(i, temp);
                        WriteFileTeacher.writeFileTeacher(SRC_TEACHER, teachers);
                    }
                }
            }
        }
        System.out.println("Sắp xếp giảng viên thành công");
    }

    public static boolean checkDayMonthYear(String string) {
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(string.substring(0, 1).concat(string.substring(1, 2)));
        arr[1] = Integer.parseInt(string.substring(3, 4).concat(string.substring(4, 5)));
        arr[2] = Integer.parseInt(string.substring(6));
        if (arr[2] % 4 == 0 && !(arr[2] % 100 == 0 && arr[2] % 400 != 0)) {
            arr[0] = day[arr[1] - 1] + 1;
        }
        return (arr[0] <= day[arr[1] - 1]);
    }
}




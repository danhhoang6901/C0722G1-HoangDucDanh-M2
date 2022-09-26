package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.service.IStudentService;
import bai_tap_them.bai_1.service.exception.ExceptionCheck;
import bai_tap_them.bai_1.util.student.ReadFileStudent;
import bai_tap_them.bai_1.util.student.WriteFileStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static final String SRC_STUDENT = "src\\bai_tap_them\\bai_1\\data\\student.csv";

    public Student infoStudent() {
        int id;
        do {
            System.out.print("Nhập id của học viên: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new ExceptionCheck("Id phải lớn hơn 0!");
                }
                for (Student student : students) {
                    if (student.getId() == id) {
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
            System.out.print("Nhập họ tên học viên: ");
            try {
                name = scanner.nextLine();
                if (!name.matches("^\\D{5,50}\\s*$")) {
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
                    System.out.print("Nhập giới tính khác: ");
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

        String nameClass;
        do {
            System.out.print("Nhập tên lớp: ");
            try {
                nameClass = scanner.nextLine();
                if (!nameClass.matches("^[C]\\d{4}[G]1")) {
                    throw new ExceptionCheck("Tên lớp không hợp lệ!");
                }
                break;
            } catch (ExceptionCheck e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        double score;
        do {
            System.out.print("Nhập điểm: ");
            try {
                score = Double.parseDouble(scanner.nextLine());
                if (score < 0 || score > 10) {
                    throw new ExceptionCheck("Điểm không được bé hơn 0 và lớn hơn 10!");
                }
                break;
            } catch (ExceptionCheck e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        Student student = new Student(id, name, dateOfbirth, gender, nameClass, score);
        return student;
    }

    @Override
    public void addStudent() {
        students = ReadFileStudent.readFileStudent(SRC_STUDENT);
        Student student = this.infoStudent();
        students.add(student);
        WriteFileStudent.writeFileStudent(SRC_STUDENT, students);
        System.out.println("Thêm mới học viên thành công");
    }

    @Override
    public void removeStudent() {
        students = ReadFileStudent.readFileStudent(SRC_STUDENT);
        System.out.print("Nhập id học viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println("Bạn có muốn xóa học viên này?");
                System.out.println("Nhấn Y: Yes");
                System.out.println("Nhấn N: No");
                System.out.print("Chọn: ");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    students.remove(i);
                    WriteFileStudent.writeFileStudent(SRC_STUDENT, students);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.err.println("Không tìm thấy học viên!");
        }
    }

    @Override
    public void displayAllStudent() {
        students = ReadFileStudent.readFileStudent(SRC_STUDENT);
        if (students.size() == 0) {
            System.err.println("Danh sách trống");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void editStudent() {
        students = ReadFileStudent.readFileStudent(SRC_STUDENT);
        System.out.println("Nhập id học viên muốn chỉnh sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                Student student = this.infoStudent();
                students.set(i, student);
                WriteFileStudent.writeFileStudent(SRC_STUDENT, students);
                System.out.println("Chỉnh sửa thông tin học viên thành công");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.err.println("Không tìm thấy học viên!");
        }
    }

    @Override
    public void searchStudent() {
        students = ReadFileStudent.readFileStudent(SRC_STUDENT);
        System.out.print("Nhập id học viên bạn muốn tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (Student student1 : students) {
            if (student1.getId() == id) {
                System.out.println(student1);
                flag = true;
                break;
            }
            System.err.println("Không tìm thấy học viên!");
            System.out.print("Nhập tên học viên muốn tìm kiếm: ");
            String name = scanner.nextLine();
            for (Student student : students) {
                if (student.getName().contains(name)) {
                    System.out.println(student);
                    flag = true;
                    break;
                }
            }
            break;
        }
        if (!flag) {
            System.err.println("Không tìm thấy học viên!");
        }
    }

    @Override
    public void sortStudent() {
        students = ReadFileStudent.readFileStudent(SRC_STUDENT);
        boolean isSwap = true;
        for (int k = 0; k < students.size() - 1 && isSwap; k++) {
            isSwap = false;
            for (int i = 0; i < students.size() - 1 - k; i++) {
                if (students.get(i).getName().compareTo(students.get(i + 1).getName()) > 0) {
                    isSwap = true;
                    Student temp = students.get(i + 1);
                    students.set(i + 1, students.get(i));
                    students.set(i, temp);
                    WriteFileStudent.writeFileStudent(SRC_STUDENT, students);
                }
                if (students.get(i).getName().equals(students.get(i + 1).getName())) {
                    if (students.get(i).getId() > students.get(i + 1).getId()) {
                        isSwap = true;
                        Student temp = students.get(i + 1);
                        students.set(i + 1, students.get(i));
                        students.set(i, temp);
                        WriteFileStudent.writeFileStudent(SRC_STUDENT, students);
                    }
                }
            }
        }
        System.out.println("Sắp xếp học viên thành công");
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



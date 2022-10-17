package case_study_module2.service.impl;

import case_study_module2.model.person.Employee;
import case_study_module2.service.IEmployeeService;
import case_study_module2.service.exception.ExceptionFuruma;
import case_study_module2.util.employee.ReadFileEmployee;
import case_study_module2.util.employee.WriteFileEmployee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    private static final String SRC_EMPLOYEE = "src\\case_study_module2\\data\\employee.csv";

    public static Employee infoEmployee() {
        employees = ReadFileEmployee.readFileEmployee(SRC_EMPLOYEE);
        int id = employees.size() + 1;

        String name;
        do {
            System.out.print("Nhập họ tên nhân viên: ");
            try {
                name = scanner.nextLine();
                if (!name.matches("^\\D{5,50}\\s*$")) {
                    throw new ExceptionFuruma("Tên không đúng!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        LocalDate dateNow = LocalDate.now();
        LocalDate dateOfBirth;
        do {
            System.out.print("Nhập ngày sinh theo định dạng dd/MM/yyyy: ");
            try {
                String day = scanner.nextLine();
                dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(dateOfBirth, dateNow);
                if (!(periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18)) {
                    throw new ExceptionFuruma("Ngày sinh không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String gender = "";
        do {
            System.out.println("Giới tính: ");
            System.out.println("1. Nam");
            System.out.println("2. NỮ");
            System.out.println("3. Khác");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choose) {
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

        String identityCardNumber;
        do {
            System.out.print("Nhập số CMND: ");
            try {
                identityCardNumber = scanner.nextLine();
                if (!identityCardNumber.matches("^[0-9]{11}$")) {
                    throw new ExceptionFuruma("Số CMND không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String phoneNumber;
        do {
            System.out.print("Nhập số điện thoại: ");
            try {
                phoneNumber = scanner.nextLine();
                if (!phoneNumber.matches("^0[0-9]{9}$")) {
                    throw new ExceptionFuruma("Số điện thoại không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String email;
        do {
            System.out.print("Nhập email: ");
            try {
                email = scanner.nextLine();
                if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+([.][A-Za-z0-9]+)$")) {
                    throw new ExceptionFuruma("Email không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String level = "";
        do {
            System.out.println("Trình độ: ");
            System.out.println("1. Trung cấp");
            System.out.println("2. Cao đẳng");
            System.out.println("3. Đại học");
            System.out.println("4. Sau đại học");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    level = "Trung cấp";
                    check = true;
                    break;
                case 2:
                    level = "Cao đẳng";
                    check = true;
                    break;
                case 3:
                    level = "Đại học";
                    check = true;
                    break;
                case 4:
                    level = "Sau đại học";
                    check = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        } while (true);

        String position = "";
        do {
            System.out.println("Vị trí: ");
            System.out.println("1. Lễ tân");
            System.out.println("2. Phục vụ");
            System.out.println("3. Chuyên viên");
            System.out.println("4. Giám sát");
            System.out.println("5. Quản lý");
            System.out.println("6. Giám đốc");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    position = "Lễ tân";
                    check = true;
                    break;
                case 2:
                    position = "Phục vụ";
                    check = true;
                    break;
                case 3:
                    position = "Chuyên viên";
                    check = true;
                    break;
                case 4:
                    position = "Giám sát";
                    check = true;
                    break;
                case 5:
                    position = "Quản lý";
                    check = true;
                    break;
                case 6:
                    position = "Giám đốc";
                    check = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        } while (true);

        int wage;
        do {
            System.out.print("Nhập lương nhân viên: ");
            try {
                wage = Integer.parseInt(scanner.nextLine());
                if (wage < 0 || wage > 10000000) {
                    throw new ExceptionFuruma("Lương không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        return new Employee(id, name, dateOfBirth, gender, identityCardNumber, phoneNumber, email, level, position, wage);
    }

    @Override
    public void displayAllEmployee() {
        employees = ReadFileEmployee.readFileEmployee(SRC_EMPLOYEE);
        if (employees.size() == 0) {
            System.err.println("Danh sách trống!");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee.getInfo());
            }
        }
    }

    @Override
    public void addEmployee() {
        employees = ReadFileEmployee.readFileEmployee(SRC_EMPLOYEE);
        Employee employee = this.infoEmployee();
        employees.add(employee);
        WriteFileEmployee.writeFileEmployee(SRC_EMPLOYEE, employees);
        System.out.println("Thêm mới nhân viên thành công");
    }

    @Override
    public void editEmployee() {
        employees = ReadFileEmployee.readFileEmployee(SRC_EMPLOYEE);
        displayAllEmployee();
        System.out.print("Nhập id nhân viên bạn muốn chỉnh sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                Employee employee = this.infoEmployee();
                employee.setId(id);
                employees.set(i, employee);
                WriteFileEmployee.writeFileEmployee(SRC_EMPLOYEE, employees);
                System.out.println("Chỉnh sửa nhân viên thành công");
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy nhân viên!");
        }
    }
}

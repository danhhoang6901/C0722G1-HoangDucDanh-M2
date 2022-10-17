package case_study_module2.service.impl;

import case_study_module2.model.person.Customer;
import case_study_module2.service.ICustomerService;
import case_study_module2.service.exception.ExceptionFuruma;
import case_study_module2.util.customer.ReadFileCustomer;
import case_study_module2.util.customer.WriteFileCustomer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new ArrayList<>();
    private static final String SRC_CUSTOMER = "src\\case_study_module2\\data\\customer.csv";

    public  Customer infoCustomer() {
        customers = ReadFileCustomer.readFileCustomer(SRC_CUSTOMER);
        int id = customers.size() + 1;

        String name;
        do {
            System.out.print("Nhập họ tên khách hàng: ");
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

        String typeOfGuest = "";
        do {
            System.out.println("Loại khách: ");
            System.out.println("1. Diamond");
            System.out.println("2. Platinium");
            System.out.println("3. Gold");
            System.out.println("4. Silver");
            System.out.println("5. Member");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    typeOfGuest = "Diamond";
                    check = true;
                    break;
                case 2:
                    typeOfGuest = "Platinium";
                    check = true;
                    break;
                case 3:
                    typeOfGuest = "Gold";
                    check = true;
                    break;
                case 4:
                    typeOfGuest = "Silver";
                    check = true;
                    break;
                case 5:
                    typeOfGuest = "Member";
                    check = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        } while (true);

        String address;
        do {
            System.out.print("Nhập địa chỉ: ");
            try {
                address = scanner.nextLine();
                if (!address.matches("^\\D*\\s*")) {
                    throw new ExceptionFuruma("Địa chỉ không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        return new Customer(id, name, dateOfBirth, gender, identityCardNumber, phoneNumber, email, typeOfGuest, address);
    }

    @Override
    public void displayAllCustomer() {
        customers = ReadFileCustomer.readFileCustomer(SRC_CUSTOMER);
        if (customers.size() == 0) {
            System.out.println("Danh sách trống!");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer.getInfo());
            }
        }
    }

    @Override
    public void addCustomer() {
        customers = ReadFileCustomer.readFileCustomer(SRC_CUSTOMER);
        Customer customer = this.infoCustomer();
        customers.add(customer);
        WriteFileCustomer.writeFileCustomer(SRC_CUSTOMER, customers);
        System.out.println("Thêm mới khách hàng thành công");
    }

    @Override
    public void editCustomer() {
        customers = ReadFileCustomer.readFileCustomer(SRC_CUSTOMER);
        displayAllCustomer();
        System.out.print("Nhập id khách hàng bạn muốn chỉnh sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                Customer customer = this.infoCustomer();
                customer.setId(id);
                customers.set(i, customer);
                WriteFileCustomer.writeFileCustomer(SRC_CUSTOMER, customers);
                System.out.println("Chỉnh sửa khách hàng thành công");
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy khách hàng!");
        }
    }

    public Customer findCustomer(int id) {
        customers = ReadFileCustomer.readFileCustomer(SRC_CUSTOMER);
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}

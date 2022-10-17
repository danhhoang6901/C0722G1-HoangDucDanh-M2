package case_study_module2.service.impl;

import case_study_module2.model.facility.Room;
import case_study_module2.service.exception.ExceptionFuruma;

import java.util.Scanner;

public class RoomService {
    private static Scanner scanner = new Scanner(System.in);

    public static Room infoRoom() {
        String serviceId;
        do {
            System.out.print("Nhập mã dịch vụ: ");
            try {
                serviceId = scanner.nextLine();
                if (!serviceId.matches("^\\d{4}$")) {
                    throw new ExceptionFuruma("Mã dịch vụ không hợp lệ!");
                }
                serviceId = "SVRO-" + serviceId;
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String serviceName;
        do {
            System.out.print("Nhập tên dịch vụ: ");
            try {
                serviceName = scanner.nextLine();
                if (!serviceName.matches("^[A-Z][a-z]{4,50}\\s*$")) {
                    throw new ExceptionFuruma("Tên dịch vụ không hợp lệ!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        int usableArea;
        do {
            System.out.print("Nhập diện tích sử dụng: ");
            try {
                usableArea = Integer.parseInt(scanner.nextLine());
                if (usableArea < 30) {
                    throw new ExceptionFuruma("Diện tích sử dụng phải lớn hơn 30 mét vuông!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        int rentalCosts;
        do {
            System.out.print("Nhập chi phí thuê: ");
            try {
                rentalCosts = Integer.parseInt(scanner.nextLine());
                if (rentalCosts < 0) {
                    throw new ExceptionFuruma("Chi phí thuê phải là số dương!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        int maximumNumberOfPeople;
        do {
            System.out.print("Nhập số lượng người tối đa: ");
            try {
                maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
                if (maximumNumberOfPeople < 0 || maximumNumberOfPeople > 20) {
                    throw new ExceptionFuruma("Số lượng người phải lớn hơn 0 và bé hơn 20!");
                }
                break;
            } catch (ExceptionFuruma e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String rentalType = "";
        do {
            System.out.println("Kiểu thuê: ");
            System.out.println("1. Thuê theo năm");
            System.out.println("2. Thuê theo tháng");
            System.out.println("3. Thuê theo ngày");
            System.out.println("4. Thuê theo giờ");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    System.out.print("Bạn muốn thuê thời gian bao nhiêu năm?: ");
                    rentalType = scanner.nextLine();
                    rentalType = rentalType + " năm";
                    check = true;
                    break;
                case 2:
                    System.out.print("Bạn muốn thuê thời gian bao nhiêu tháng?: ");
                    rentalType = scanner.nextLine();
                    rentalType = rentalType + " tháng";
                    check = true;
                    break;
                case 3:
                    System.out.print("Bạn muốn thuê thời gian bao nhiêu ngày?: ");
                    rentalType = scanner.nextLine();
                    rentalType = rentalType + " ngày";
                    check = true;
                    break;
                case 4:
                    System.out.print("Bạn muốn thuê thời gian bao nhiêu giờ?: ");
                    rentalType = scanner.nextLine();
                    rentalType = rentalType + " giờ";
                    check = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        } while (true);

        String freeServiceIncluded = "";
        do {
            System.out.println("Dịch vụ miễn phí đi kèm: ");
            System.out.println("1. Ăn buffe");
            System.out.println("2. Massage");
            System.out.println("3. Xông hơi");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choose) {
                case 1:
                    freeServiceIncluded = "Ăn buffe";
                    check = true;
                    break;
                case 2:
                    freeServiceIncluded = "Massage";
                    check = true;
                    break;
                case 3:
                    freeServiceIncluded = "Xông hơi";
                    check = true;
                    break;
                default:
                    System.out.print("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        } while (true);

        return new Room(serviceId, serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, freeServiceIncluded);
    }
}

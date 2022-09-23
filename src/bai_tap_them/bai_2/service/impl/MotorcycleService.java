package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Manufacturer;
import bai_tap_them.bai_2.model.Motorcycle;
import bai_tap_them.bai_2.service.IMotorcycleService;
import bai_tap_them.bai_2.service.exception.ExceptionTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorcycleService implements IMotorcycleService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Motorcycle> motorcycles = new ArrayList<>();
    private static List<Manufacturer> manufacturers = new ArrayList<>();
    private static Manufacturer manufacturer1 = new Manufacturer("Motorcycle123", "HONDA", "Nhật Bản ");
    private static Manufacturer manufacturer2 = new Manufacturer("Motorcycle456", " TRIUMPH", "Anh");
    private static Manufacturer manufacturer3 = new Manufacturer("Motorcycle789", "YAMAHA", "Nhật Bản ");

    public Motorcycle infoMotorcycle() {
        String seaOf​Control;
        do {
            System.out.print("Nhập biển kiếm soát: ");
            try {
                seaOf​Control = scanner.nextLine();
                if (!seaOf​Control.matches("^[0-9]{2}-[A-Z][1-9]-[0-9]{5}$")) {
                    throw new ExceptionTransport("Biển kiểm soát không hợp lệ!");
                }
                break;
            } catch (ExceptionTransport e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        Manufacturer manufacturer = null;
        while (true) {
            System.out.println("Chọn hãng sản xuất: ");
            System.out.println("1. Toyota");
            System.out.println("2. Ford");
            System.out.println("3. Chevrolet");
            System.out.println("4 Hãng khác: ");
            System.out.print("Chọn: ");
            manufacturers.add(manufacturer1);
            manufacturers.add(manufacturer2);
            manufacturers.add(manufacturer3);
            int choice = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choice) {
                case 1:
                    manufacturer = manufacturers.get(0);
                    check = true;
                    break;
                case 2:
                    manufacturer = manufacturers.get(1);
                    check = true;
                    break;
                case 3:
                    manufacturer = manufacturers.get(2);
                    check = true;
                    break;
                case 4:
                    String manufacturerCode;
                    do {
                        System.out.print("Nhập mã sản xuất: ");
                        try {
                            manufacturerCode = scanner.nextLine();
                            if (!manufacturerCode.matches("^[C]-[0-9]{3}$")) {
                                throw new ExceptionTransport("Mã sản xuất không hợp lệ!");
                            }
                            break;
                        } catch (ExceptionTransport e) {
                            System.err.println(e.getMessage());
                        }
                    } while (true);

                    String manufacturerName;
                    do {
                        System.out.print("Nhập tên hãng sản xuất: ");
                        try {
                            manufacturerName = scanner.nextLine();
                            if (!manufacturerName.matches("^\\D*\\s*$")) {
                                throw new ExceptionTransport("Hãng sản xuất không hợp lệ!");
                            }
                            break;
                        } catch (ExceptionTransport e) {
                            System.err.println(e.getMessage());
                        }
                    } while (true);

                    String nation;
                    do {
                        System.out.print("Nhập quốc gia: ");
                        try {
                            nation = scanner.nextLine();
                            if (!nation.matches("^\\D*\\s*$")) {
                                throw new ExceptionTransport("Quốc gia không hợp lệ!");
                            }
                            break;
                        } catch (ExceptionTransport e) {
                            System.err.println(e.getMessage());
                        }
                    } while (true);

                    Manufacturer manufacturer4 = new Manufacturer(manufacturerCode, manufacturerName, nation);
                    manufacturers.add(manufacturer4);
                    manufacturer = manufacturers.get(3);
                    check = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        }

        String yearOfManufacture;
        do {
            System.out.print("Nhập năm sản xuất: ");
            try {
                yearOfManufacture = scanner.nextLine();
                if (!yearOfManufacture.matches("^[0-9]{1,4}$")) {
                    throw new ExceptionTransport("Năm sản xuất không hợp lệ!");
                }
                if (Integer.parseInt(yearOfManufacture) > 2022 || Integer.parseInt(yearOfManufacture) < 1000) {
                    throw new ExceptionTransport("Năm sản xuất không hợp lệ!");
                }
                break;
            } catch (ExceptionTransport e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        String owner;
        do {
            System.out.print("Nhập chủ sở hữu: ");
            try {
                owner = scanner.nextLine();
                if (!owner.matches("^\\D{4,50}\\s*$")) {
                    throw new ExceptionTransport("Tên chủ sỡ hữu không hợp lệ!");
                }
                break;
            } catch (ExceptionTransport e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        double wattage;
        do {
            System.out.print("Nhập công suất: ");
            try {
                wattage = Double.parseDouble(scanner.nextLine());
                if (wattage < 0 || wattage > 300) {
                    throw new ExceptionTransport("Công suất không hợp lệ!");
                }
                break;
            } catch (ExceptionTransport e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        return new Motorcycle(seaOf​Control, manufacturer, yearOfManufacture, owner, wattage);
    }

    @Override
    public void addMotorcycle() {
        Motorcycle motorcycle = this.infoMotorcycle();
        motorcycles.add(motorcycle);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayAllMotorcycle() {
        if (motorcycles.size() == 0) {
            System.err.println("Danh sách trống!");
        } else {
            for (Motorcycle motorcycle : motorcycles) {
                System.out.println(motorcycle);
            }
        }
    }

    @Override
    public void removeMotorcycle() {
        System.out.print("Nhập biển kiểm soát: ");
        String seaOf​Control = scanner.nextLine();
        boolean flafDelete = false;
        for (int i = 0; i < motorcycles.size(); i++) {
            if (motorcycles.get(i).getSeaOf​Control().equals(seaOf​Control)) {
                System.out.println("Bạn có muốn xóa phương tiện này không?");
                System.out.println("Nhấn Y: Yes");
                System.out.println("Nhấn N: No");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    motorcycles.remove(i);
                    System.out.println("Đã xóa thành công");
                }
                flafDelete = true;
                break;
            }
        }
        if (!flafDelete) {
            System.err.println("Không tìm thấy phương tiện!");
        }
    }

    @Override
    public void searchMotorcycle() {
        System.out.print("Nhập biển kiếm soát: ");
        String seaOf​Control = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < motorcycles.size(); i++) {
            if (motorcycles.get(i).getSeaOf​Control().contains(seaOf​Control)) {
                System.out.println(motorcycles.get(i).toString());
            }
            flag = true;
            break;
        }
        if (!flag) {
            System.err.println("Không có phương tiện nào tìm thấy!");
        }
    }
}

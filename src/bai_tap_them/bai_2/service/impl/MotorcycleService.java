package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Manufacturer;
import bai_tap_them.bai_2.model.Motorcycle;
import bai_tap_them.bai_2.service.IMotorcycleService;

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
        System.out.print("Nhập biển kiếm soát: ");
        String seaOf​Control = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất: ");
        System.out.println("1. HONDA");
        System.out.println("2. TRIUMPH");
        System.out.println("3. YAMAHA");
        System.out.println("4 Hãng khác: ");
        System.out.print("Chọn: ");
        Manufacturer manufacturer = null;
        manufacturers.add(manufacturer1);
        manufacturers.add(manufacturer2);
        manufacturers.add(manufacturer3);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                manufacturer = manufacturers.get(0);
                break;
            case 2:
                manufacturer = manufacturers.get(1);
                break;
            case 3:
                manufacturer = manufacturers.get(2);
                break;
            case 4:
                System.out.print("Nhập mã sản xuất: ");
                String manufacturerCode = scanner.nextLine();
                System.out.print("Nhập tên hãng sản xuất: ");
                String manufacturerName = scanner.nextLine();
                System.out.print("Nhập quốc gia: ");
                String nation = scanner.nextLine();
                Manufacturer manufacturer4 = new Manufacturer(manufacturerCode, manufacturerName, nation);
                manufacturers.add(manufacturer4);
                manufacturer = manufacturers.get(3);
                break;
            default:
                System.err.println("Lựa chọn của bạn không đúng!");
        }
        System.out.print("Nhập năm sản xuất: ");
        int yearOfManufacture = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập công suất: ");
        double wattage = Double.parseDouble(scanner.nextLine());
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

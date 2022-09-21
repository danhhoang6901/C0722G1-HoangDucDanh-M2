package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Car;
import bai_tap_them.bai_2.model.Manufacturer;
import bai_tap_them.bai_2.service.ICarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();
    private static List<Manufacturer> manufacturers = new ArrayList<>();
    private static Manufacturer manufacturer1 = new Manufacturer("Car123", "Toyoya", "Nhật Bản ");
    private static Manufacturer manufacturer2 = new Manufacturer("Car456", " Ford", "Mỹ");
    private static Manufacturer manufacturer3 = new Manufacturer("Car789", "Chevrolet", "Mỹ ");

    public Car infoCar() {
        System.out.print("Nhập biển kiếm soát: ");
        String seaOf​Control = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất: ");
        System.out.println("1. Toyota");
        System.out.println("2. Ford");
        System.out.println("3. Chevrolet");
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
                System.out.println("Lựa chọn của bạn không đúng!");
        }
        System.out.print("Nhập năm sản xuất: ");
        int yearOfManufacture = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập kiểu xe: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Nhập số chỗ ngồi: ");
        int numberOfSeats = Integer.parseInt(scanner.nextLine());
        Car car = new Car(seaOf​Control, manufacturer, yearOfManufacture, owner, numberOfSeats, vehicleType);
        return car;
    }

    @Override
    public void addCar() {
        Car car = this.infoCar();
        cars.add(car);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayALlCar() {
        if (cars.size() == 0) {
            System.err.println("Danh sách trống!");
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    @Override
    public void removeCar() {
        System.out.print("Nhập biển kiểm soát: ");
        String seaOf​Control = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getSeaOf​Control().equals(seaOf​Control)) {
                System.out.println("Bạn có muốn xóa phương tiện này không?");
                System.out.println("Nhấn Y: Yes");
                System.out.println("Nhấn N: No");
                System.out.print("Chọn: ");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    cars.remove(i);
                    System.out.println("Đã xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.err.println("Không có phương tiện nào tìm thấy!");
        }
    }

    @Override
    public void searchCar() {
        System.out.print("Nhập biển kiểm soát: ");
        String seaOf​Control = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getSeaOf​Control().contains(seaOf​Control)) {
                System.out.println(cars.get(i).toString());
            }
            flag = true;
            break;
        }
        if (!flag) {
            System.err.println("Không có phương nào tìm thấy!");
        }
    }
}

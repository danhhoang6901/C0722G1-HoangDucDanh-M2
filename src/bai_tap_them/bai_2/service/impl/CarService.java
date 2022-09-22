package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Car;
import bai_tap_them.bai_2.model.Manufacturer;
import bai_tap_them.bai_2.service.ICarService;
import bai_tap_them.bai_2.service.exception.ExceptionTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();
    private static List<Manufacturer> manufacturers = new ArrayList<>();
    private static Manufacturer manufacturer1 = new Manufacturer("C-123", "Toyoya", "Nhật Bản ");
    private static Manufacturer manufacturer2 = new Manufacturer("C-456", " Ford", "Mỹ");
    private static Manufacturer manufacturer3 = new Manufacturer("C-789", "Chevrolet", "Mỹ ");

    public Car infoCar() {
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

        String vehicleType = "";
        while (true) {
            System.out.println("Kiểu xe: ");
            System.out.println("1. SUV - xe thể thao đa dụng");
            System.out.println("2. Crossover - xe lai đa dụng");
            System.out.println("3. MPV - dòng xe đa dụng");
            System.out.println("4. Coupe - dòng xe thể thao");
            System.out.println("5. Convertible - dòng xe mui trần");
            System.out.println("6. Limousine - dòng xe sang");
            System.out.println("7. Khác");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            switch (choice) {
                case 1:
                    vehicleType = "SUV";
                    check = true;
                    break;
                case 2:
                    vehicleType = "Crossover";
                    check = true;
                    break;
                case 3:
                    vehicleType = "MPV";
                    check = true;
                    break;
                case 4:
                    vehicleType = "Coupe";
                    check = true;
                    break;
                case 5:
                    vehicleType = "Convertible";
                    check = true;
                    break;
                case 6:
                    vehicleType = "Limousine";
                    check = true;
                    break;
                case 7:
                    do {
                        System.out.print("Nhập kiểu xe: ");
                        try {
                            vehicleType = scanner.nextLine();
                            if (!vehicleType.matches("^\\D*\\s*$")) {
                                throw new ExceptionTransport("Kiểu xe không hợp lệ!");
                            }
                            break;
                        } catch (ExceptionTransport e) {
                            System.err.println(e.getMessage());
                        }
                    } while (true);
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (check) {
                break;
            }
        }

        int numberOfSeats;
        do {
            System.out.print("Nhập số chỗ ngồi: ");
            try {
                numberOfSeats = Integer.parseInt(scanner.nextLine());
                if (numberOfSeats <= 0 || numberOfSeats >= 17) {
                    throw new ExceptionTransport("Số chỗ ngồi không hợp lệ!");
                }
                break;
            } catch (ExceptionTransport e) {
                System.err.println(e.getMessage());
            }
        } while (true);

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
                System.out.println(car.getInfo());
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

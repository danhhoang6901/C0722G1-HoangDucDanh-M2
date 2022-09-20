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
    private static Manufacturer manufacturer = new Manufacturer("ABC123", "Toyoya", "Nhật Bản ");
    private static Manufacturer manufacturer1 = new Manufacturer("ABC456", " Ford", "Mỹ");
    private static Manufacturer manufacturer2 = new Manufacturer("ABC789", "Chevrolet", "Mỹ ");

//    public Car infoCar() {
//        System.out.print("Nhập biển kiếm soát: ");
//        String seaOf​Control = scanner.nextLine();
//        System.out.println("Chọn hãng sản xuất: ");
//        manufacturers.add(manufacturer);
//    }

    @Override
    public void addCar() {

    }
}

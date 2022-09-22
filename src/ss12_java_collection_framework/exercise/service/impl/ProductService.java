package ss12_java_collection_framework.exercise.service.impl;

import ss12_java_collection_framework.exercise.model.Product;
import ss12_java_collection_framework.exercise.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    public Product infoProduct() {
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá tiền sản phẩm: ");
        Integer price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price);
    }

    @Override
    public void addProduct() {
        Product product = this.infoProduct();
        products.add(product);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void editProduct() {
        System.out.print("Nhập id sản phẩm bạn muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                Product product = this.infoProduct();
                products.set(i, product);
                System.out.println("Chỉnh sửa thành công");
            }
            flag = true;
            break;
        }
        if (!flag) {
            System.err.println("Không tìm thấy sản phẩm!");
        }
    }

    @Override
    public void removeProduct() {
        System.out.print("Nhập id sản phẩm bạn muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                System.out.println("Bạn có muốn xóa sản phầm này không?");
                System.out.println("Nhấn Y: Yes ");
                System.out.println("Nhấn N: No ");
                System.out.print("Chọn: ");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    products.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.print("Không tìm thấy sản phẩm!");
        }
    }

    @Override
    public void displayAllProduct() {
        if (products.size() == 0) {
            System.err.println("Danh sách trống!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    @Override
    public void searchProduct() {
        System.out.print("Nhập id sản phẩm bạn muốn tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                System.out.println(products.get(i).toString());
            }
            flag = true;
            break;
        }
        if (!flag) {
            System.err.println("Không tìm thấy sản phẩm!");
        }
    }

    @Override
    public void sortProduct() {
        while (true) {
            System.out.println("Bạn muốn sắp xếp theo: ");
            System.out.println("1. Giá tăng dần");
            System.out.println("2. Giá giảm dần");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            boolean swap;
            boolean flag = false;
            switch (choice) {
                case 1:
                    swap = true;
                    for (int k = 0; k < products.size() - 1 && swap; k++) {
                        swap = false;
                        for (int i = 0; i < products.size() - 1 - k; i++) {

                            if (products.get(i).getPrice().compareTo(products.get(i + 1).getPrice()) > 0) {
                                swap = true;
                                Product product = products.get(i + 1);
                                products.set(i + 1, products.get(i));
                                products.set(i, product);
                            }
                        }
                    }
                    System.out.println("Sắp xếp giá tăng dần thành công");
                    flag = true;
                    break;
                case 2:
                    swap = true;
                    for (int i = 0; i < products.size() - 1 && swap; i++) {
                        swap = false;
                        for (int j = 0; j < products.size() - 1 - i; j++) {
                            if (products.get(j + 1).getPrice().compareTo(products.get(j).getPrice()) > 0) {
                                swap = true;
                                Product product = products.get(j + 1);
                                products.set(j + 1, products.get(j));
                                products.set(j, product);
                            }
                        }
                    }
                    System.out.println("Sắp xếp giá giảm dần thành công");
                    flag = true;
                    break;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
            if (flag) {
                break;
            }
        }
    }
}


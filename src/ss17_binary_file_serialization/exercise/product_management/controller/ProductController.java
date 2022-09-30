package ss17_binary_file_serialization.exercise.product_management.controller;

import ss17_binary_file_serialization.exercise.product_management.service.IProductService;
import ss17_binary_file_serialization.exercise.product_management.service.impl.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    public static Scanner scanner = new Scanner(System.in);
    public static IProductService productService = new ProductService();

    public static void productManagement() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--");
            System.out.println("Chọn các chức năng theo số để tiếp tục: ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.displayAllProduct();
                    break;
                case 3:
                    productService.searchProduct();
                    break;
                case 4:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

package bai_tap_them.ss12_java_collection_framework.exercise.controller;

import bai_tap_them.ss12_java_collection_framework.exercise.service.IProductService;
import bai_tap_them.ss12_java_collection_framework.exercise.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();

    public static void productManagement() {
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--");
            System.out.println("Chọn chức theo số để tiếp tục: ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo id");
            System.out.println("3. Xoá sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.editProduct();
                    break;
                case 3:
                    productService.removeProduct();
                    break;
                case 4:
                    productService.displayAllProduct();
                    break;
                case 5:
                    productService.searchProduct();
                    break;
                case 6:
                    productService.sortProduct();
                    break;
                case 7:
                    System.out.println("Đã thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}

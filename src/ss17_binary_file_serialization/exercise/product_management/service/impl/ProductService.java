package ss17_binary_file_serialization.exercise.product_management.service.impl;

import ss17_binary_file_serialization.exercise.product_management.model.Product;
import ss17_binary_file_serialization.exercise.product_management.service.IProductService;
import ss17_binary_file_serialization.exercise.product_management.util.ReadFileProduct;
import ss17_binary_file_serialization.exercise.product_management.util.WriteFileProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();
    public static final String SRC_PRODUCT = "src\\ss17_binary_file_serialization\\exercise\\product_management\\data\\product.csv";

    public Product infoProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập giá: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mô tả khác: ");
        String otherDescriptions = scanner.nextLine();

        return new Product(id, productName, manufacturer, price, otherDescriptions);
    }

    @Override
    public void addProduct() throws IOException, ClassNotFoundException {
        Product product = this.infoProduct();
        products.add(product);
        WriteFileProduct.writeFileProduct(SRC_PRODUCT, products);
        System.out.println("Thêm mới sản phẩm thành công");
        products = ReadFileProduct.readFileProduct(SRC_PRODUCT);
    }

    @Override
    public void displayAllProduct() throws IOException, ClassNotFoundException {
        products = ReadFileProduct.readFileProduct(SRC_PRODUCT);
        if (products.size() == 0) {
            System.out.println("Danh sách trống!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    @Override
    public void searchProduct() throws IOException, ClassNotFoundException {
        products = ReadFileProduct.readFileProduct(SRC_PRODUCT);
        System.out.print("Nhập id sản phẩm bạn muốn tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
}

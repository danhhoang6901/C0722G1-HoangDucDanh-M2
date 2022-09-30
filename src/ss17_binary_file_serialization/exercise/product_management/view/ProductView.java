package ss17_binary_file_serialization.exercise.product_management.view;

import ss17_binary_file_serialization.exercise.product_management.controller.ProductController;

import java.io.IOException;

public class ProductView {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductController.productManagement();
    }
}

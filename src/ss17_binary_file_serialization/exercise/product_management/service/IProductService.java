package ss17_binary_file_serialization.exercise.product_management.service;

import java.io.IOException;

public interface IProductService {
    void addProduct() throws IOException, ClassNotFoundException;

    void displayAllProduct() throws IOException, ClassNotFoundException;

    void searchProduct() throws IOException, ClassNotFoundException;
}

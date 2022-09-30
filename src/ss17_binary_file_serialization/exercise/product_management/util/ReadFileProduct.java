package ss17_binary_file_serialization.exercise.product_management.util;

import ss17_binary_file_serialization.exercise.product_management.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFileProduct {
    public static List<Product> readFileProduct(String src) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(src);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Product> products = (List<Product>) objectInputStream.readObject();
        objectInputStream.close();
        return products;
    }
}

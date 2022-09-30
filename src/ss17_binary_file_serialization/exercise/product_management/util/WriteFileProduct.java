package ss17_binary_file_serialization.exercise.product_management.util;

import ss17_binary_file_serialization.exercise.product_management.model.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFileProduct {
    public static void writeFileProduct(String src, List<Product> products) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(src);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(products);
        objectOutputStream.close();
    }
}

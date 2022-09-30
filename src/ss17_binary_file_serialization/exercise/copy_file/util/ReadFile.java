package ss17_binary_file_serialization.exercise.copy_file.util;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String src) {
        List<String> strings = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            strings = (List<String>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (Exception e) {
            System.out.println("File không tồn tại!");
        }
        return strings;
    }
}
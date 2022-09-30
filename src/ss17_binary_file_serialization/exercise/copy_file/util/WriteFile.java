package ss17_binary_file_serialization.exercise.copy_file.util;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFile {
    public static void writeFile(String src, List<String> strings) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(src);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(strings);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại!");
        }
    }
}

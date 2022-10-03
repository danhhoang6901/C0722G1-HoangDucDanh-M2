package ss17_binary_file_serialization.exercise.copy_file.view;

import ss17_binary_file_serialization.exercise.copy_file.util.ReadFile;
import ss17_binary_file_serialization.exercise.copy_file.util.WriteFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        strings.add("Danh");
        strings.add("Duy");
        WriteFile.writeFile("src\\ss17_binary_file_serialization\\exercise\\copy_file\\data\\source.csv", strings);
        strings = ReadFile.readFile("src\\ss17_binary_file_serialization\\exercise\\copy_file\\data\\source.csv");
        WriteFile.writeFile("src\\ss17_binary_file_serialization\\exercise\\copy_file\\data\\target.csv", strings);
        System.out.println(strings);

        FileInputStream fileInputStream = new FileInputStream("src\\ss17_binary_file_serialization\\exercise\\copy_file\\data\\source.csv");
        long size = fileInputStream.getChannel().size();
        System.out.println("Số byte trong tệp: " + size);
    }
}

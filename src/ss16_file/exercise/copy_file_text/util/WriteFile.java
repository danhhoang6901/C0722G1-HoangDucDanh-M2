package ss16_file.exercise.copy_file_text.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {
    public static void writeFile(String src, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(src,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Lỗi gì đó chưa xác định!");
        }
    }
}

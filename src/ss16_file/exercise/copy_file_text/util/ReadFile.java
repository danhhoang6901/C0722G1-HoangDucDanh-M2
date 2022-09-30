package ss16_file.exercise.copy_file_text.util;

import ss16_file.exercise.copy_file_text.exception.FileTextException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String src) throws IOException {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(src);
            if (!file.exists()) {
                throw new FileTextException("File không tồn tại!");
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
        } catch (FileTextException e) {
            System.err.println(e.getMessage());
        }
        return strings;
    }
}
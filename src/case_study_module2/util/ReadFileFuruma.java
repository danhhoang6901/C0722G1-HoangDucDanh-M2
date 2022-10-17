package case_study_module2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileFuruma {
    public static List<String> readFileRuruma(String src){
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line = "";
        List<String> strings = new ArrayList<>();
        try {
            fileReader = new FileReader(new File(src));
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}

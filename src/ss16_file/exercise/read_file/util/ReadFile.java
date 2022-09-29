package ss16_file.exercise.read_file.util;

import ss16_file.exercise.read_file.model.Nation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> readFile(String path) {
        List<String> country = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                country.add(line);
                String[] list = line.split(",");
                Nation nation = new Nation();
                nation.setId(Integer.parseInt(list[0]));
                nation.setCode(list[1]);
                nation.setName(list[2]);
                country.add(String.valueOf(nation));
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung lỗi!");
        }
        return country;
    }
}

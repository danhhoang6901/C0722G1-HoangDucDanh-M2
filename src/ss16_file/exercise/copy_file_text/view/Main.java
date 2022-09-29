package ss16_file.exercise.copy_file_text.view;

import ss16_file.exercise.copy_file_text.util.ReadFile;
import ss16_file.exercise.copy_file_text.util.WriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        strings = ReadFile.readFile("src\\ss16_file\\exercise\\copy_file_text\\data\\source_file.csv");
        WriteFile.writeFile("src\\ss16_file\\exercise\\copy_file_text\\data\\target_file.csv",strings);
    }
}

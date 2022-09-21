package bai_tap_them.bai_1.util.student;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.util.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class ReadFileStudent {
    public static List<Student> readFileStudent(String src) {
        List<String> strings = ReadFile.readFile(src);
        List<Student> students = new ArrayList<>();
        String[] info;

        for (String line : strings) {
            info = line.split(",");
            students.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], Double.parseDouble(info[5])));
        }
        return students;
    }
}

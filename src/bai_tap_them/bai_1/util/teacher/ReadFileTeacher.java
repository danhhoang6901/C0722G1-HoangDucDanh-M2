package bai_tap_them.bai_1.util.teacher;

import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.util.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class ReadFileTeacher {
    public static List<Teacher> readFileTeacher(String src) {
        List<String> strings = ReadFile.readFile(src);
        List<Teacher> teachers = new ArrayList<>();
        String[] info;

        for (String line : strings) {
            info = line.split(",");
            teachers.add(new Teacher(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4]));
        }
        return teachers;
    }
}

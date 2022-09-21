package bai_tap_them.bai_1.util.teacher;

import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.util.WriteFile;

import java.util.List;

public class WriteFileTeacher {
    public static void writeFileTeacher(String src, List<Teacher> teachers) {
        String data = "";
        for (Teacher teacher : teachers) {
            data += teacher.toString();
            data += "\n";
        }
        WriteFile.writeFile(src, data);
    }
}

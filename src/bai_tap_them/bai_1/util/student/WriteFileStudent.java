package bai_tap_them.bai_1.util.student;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.util.WriteFile;

import java.util.List;

public class WriteFileStudent {
    public static void writeFileStudent(String src, List<Student> students) {
        String data = "";
        for (Student student : students) {
            data += student.toString();
            data += "\n";
        }
        WriteFile.writeFile(src, data);
    }
}

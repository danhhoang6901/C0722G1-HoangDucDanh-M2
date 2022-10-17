package case_study_module2.util.employee;

import case_study_module2.model.person.Employee;
import case_study_module2.util.WriteFileFuruma;

import java.util.List;

public class WriteFileEmployee {
    public static void writeFileEmployee(String src, List<Employee> employees) {
        String data = "";
        for (Employee employee : employees) {
            data += employee.getInfo();
            data += "\n";
        }
        WriteFileFuruma.writeFileFuruma(src, data);
    }
}

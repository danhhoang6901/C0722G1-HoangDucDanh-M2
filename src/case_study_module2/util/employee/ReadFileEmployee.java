package case_study_module2.util.employee;

import case_study_module2.model.person.Employee;
import case_study_module2.util.ReadFileFuruma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileEmployee {
    public static List<Employee> readFileEmployee(String src) {
        List<String> strings = ReadFileFuruma.readFileRuruma(src);
        List<Employee> employees = new ArrayList<>();
        String[] info;

        for (String line : strings) {
            info = line.split(",");
            employees.add(new Employee(Integer.parseInt(info[0]), info[1], LocalDate.parse(info[2]), info[3], info[4], info[5], info[6], info[7], info[8], Integer.parseInt(info[9])));
        }
        return employees;
    }
}

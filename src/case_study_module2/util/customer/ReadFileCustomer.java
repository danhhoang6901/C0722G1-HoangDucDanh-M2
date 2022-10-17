package case_study_module2.util.customer;

import case_study_module2.model.person.Customer;
import case_study_module2.model.person.Employee;
import case_study_module2.util.ReadFileFuruma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCustomer {
    public static List<Customer> readFileCustomer(String src) {
        List<String> strings = ReadFileFuruma.readFileRuruma(src);
        List<Customer> customers = new ArrayList<>();
        String[] info;

        for (String line : strings) {
            info = line.split(",");
            customers.add(new Customer(Integer.parseInt(info[0]), info[1], LocalDate.parse(info[2]), info[3], info[4], info[5], info[6], info[7], info[8]));
        }
        return customers;
    }
}

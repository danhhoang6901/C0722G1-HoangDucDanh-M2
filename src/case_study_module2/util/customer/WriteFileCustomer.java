package case_study_module2.util.customer;

import case_study_module2.model.person.Customer;
import case_study_module2.model.person.Employee;
import case_study_module2.util.WriteFileFuruma;

import java.util.List;

public class WriteFileCustomer {
    public static void writeFileCustomer(String src, List<Customer> customers) {
        String data = "";
        for (Customer customer : customers) {
            data += customer.getInfo();
            data += "\n";
        }
        WriteFileFuruma.writeFileFuruma(src, data);
    }
}

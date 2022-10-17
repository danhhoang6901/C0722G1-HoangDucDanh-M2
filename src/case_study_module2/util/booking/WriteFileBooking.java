package case_study_module2.util.booking;

import case_study_module2.model.Booking;
import case_study_module2.model.person.Customer;
import case_study_module2.util.WriteFileFuruma;

import java.util.List;
import java.util.Set;

public class WriteFileBooking {
    public static void writeFileBooking(String src, Set<Booking> bookings) {
        String data = "";
        for (Booking booking : bookings) {
            data += booking.toString();
            data += "\n";
        }
        WriteFileFuruma.writeFileFuruma(src, data);
    }
}

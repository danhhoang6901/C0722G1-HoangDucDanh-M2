package case_study_module2.util.booking;

import case_study_module2.model.Booking;
import case_study_module2.util.ReadFileFuruma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReadFileBooking {
    public static Set<Booking> readFileBooking(String src) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<String> strings = ReadFileFuruma.readFileRuruma(src);
        Set<Booking> bookings = new TreeSet<>(new Sort());
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            try {
                bookings.add(new Booking(Integer.parseInt(info[0]), dateFormat.parse(info[1]), dateFormat.parse(info[2]), Integer.parseInt(info[3]), info[4], info[5]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return bookings;
    }
}

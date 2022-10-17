package case_study_module2.util.booking;

import case_study_module2.model.Booking;

import java.util.Comparator;

public class Sort implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        int comparison;
        comparison = o1.getStartDay().compareTo(o2.getStartDay());
        if (comparison == 0) {
            comparison = o1.getEndDate().compareTo(o2.getEndDate());
        }
        return comparison;
    }
}

package case_study_module2.service.impl;

import case_study_module2.model.Booking;
import case_study_module2.model.facility.Facility;
import case_study_module2.model.person.Customer;
import case_study_module2.service.IBookingService;
import case_study_module2.service.exception.ExceptionFuruma;
import case_study_module2.util.booking.ReadFileBooking;
import case_study_module2.util.booking.Sort;
import case_study_module2.util.booking.WriteFileBooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static Set<Booking> bookings = new TreeSet<>(new Sort());
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final String SRC_BOOKING = "src\\case_study_module2\\data\\booking.csv";

    @Override
    public void addBooking() {
        System.out.println("Danh sách khách hàng: ");
        CustomerService customerService = new CustomerService();
        customerService.displayAllCustomer();
        System.out.print("Nhập mã khách hàng bạn muốn chọn: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        Customer customer = customerService.findCustomer(customerId);
        System.out.println("Danh sách dịch vụ: ");
        FacilityService facilityService = new FacilityService();
        facilityService.displayAllFacility();
        System.out.print("Nhập mã dịch vụ bạn muốn chọn: ");
        String serviceId = scanner.nextLine();
        Facility facility = facilityService.findFacilityId(serviceId);

        int bookingId = bookings.size() + 1;

        Date startDay;
        Date date = new Date();
        String startDayCheck;
        do {
            System.out.print("Nhập ngày bắt đầu (dd/MM/yy): ");
            try {
                startDayCheck = scanner.nextLine();
                if (startDayCheck.matches("^(?:(?:31(\\\\/|-|\\\\.)(?:0?[13578]|1[02]))\\\\1|\" +\n" +
                        "\"(?:(?:29|30)(\\\\/|-|\\\\.)(?:0?[13-9]|1[0-2])\\\\2))\" +\n" +
                        " \"(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$|^(?:29(\\\\/|-|\\\\.)0?2\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\d)\" +\n" +
                        "\"?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|\" +\n" +
                        "\"^(?:0?[1-9]|1\\\\d|2[0-8])(\\\\/|-|\\\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\\\4(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$")) {
                    throw new ExceptionFuruma("Ngày bắt đầu phải đúng định dạng dd/MM/yy!");
                }
                startDay = dateFormat.parse(startDayCheck);
                if (startDay.compareTo(date) < 0) {
                    throw new ExceptionFuruma("Ngày bất đầu không được lớn hơn ngày hiện tại!");
                }
                break;
            } catch (ExceptionFuruma | ParseException e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        Date endDate;
        String endDateCheck;
        do {
            System.out.print("Nhập ngày kết thúc (dd/MM/yy): ");
            try {
                endDateCheck = scanner.nextLine();
                if (endDateCheck.matches("^(?:(?:31(\\\\\\\\/|-|\\\\\\\\.)(?:0?[13578]|1[02]))\\\\\\\\1|\\\" +\\n\" +\n" +
                        " \"\\\"(?:(?:29|30)(\\\\\\\\/|-|\\\\\\\\.)(?:0?[13-9]|1[0-2])\\\\\\\\2))\\\" +\\n\" +\n" +
                        " \" \\\"(?:(?:1[6-9]|[2-9]\\\\\\\\d)?\\\\\\\\d{2})$|^(?:29(\\\\\\\\/|-|\\\\\\\\.)0?2\\\\\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\\\\\d)\\\" +\\n\" +\n" +
                        "\"\\\"?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|\\\" +\\n\" +\n" +
                        " \"\\\"^(?:0?[1-9]|1\\\\\\\\d|2[0-8])(\\\\\\\\/|-|\\\\\\\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\\\\\\\4(?:(?:1[6-9]|[2-9]\\\\\\\\d)?\\\\\\\\d{2})$")) {
                    throw new ExceptionFuruma("Ngày kết thúc phải đúng đúng định dạng dd/MM/yyyy!");
                }
                endDate = dateFormat.parse(endDateCheck);
                if (endDate.compareTo(startDay) < 0) {
                    throw new ExceptionFuruma("Ngày kết thúc không nhỏ hơn ngày bắt đầu!");
                }
                break;
            } catch (ExceptionFuruma | ParseException e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        Booking booking = new Booking(bookingId, startDay, endDate, customer.getId(), facility.getServiceName(), facility.getRentalType());
        bookings.add(booking);
        WriteFileBooking.writeFileBooking(SRC_BOOKING, bookings);
        System.out.println("Thêm thành công");

        int value = FacilityService.facilityIntegerMap.get(facility);
        int newValue = value + 1;
        FacilityService.facilityIntegerMap.replace(facility, newValue);
    }

    @Override
    public void displayAllBooking() {
        bookings = ReadFileBooking.readFileBooking(SRC_BOOKING);
        if (bookings.size() == 0) {
            System.err.println("Danh sách trống!");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}

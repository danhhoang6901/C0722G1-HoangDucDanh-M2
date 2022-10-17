package case_study_module2.model;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Date startDay;
    private Date endDate;
    private int customerId;
    private String serviceName;
    private String typeOfService;

    public Booking() {
    }

    public Booking(int bookingId, Date startDay, Date endDate, int customerId, String serviceName, String typeOfService) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", startDay='" + startDay + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerId=" + customerId +
                ", serviceName='" + serviceName + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }
}

package case_study_module2.model.facility;

import case_study_module2.model.facility.Facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    @Override
    public String getInfo() {
        return String.format("%s,%s", super.toString(), freeServiceIncluded);
    }

    public Room() {
    }

    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String serviceId, String serviceName, int usableArea, int rentalCosts, int maximumNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(serviceId, serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", super.toString(), freeServiceIncluded);
    }
}

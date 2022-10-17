package case_study_module2.model.facility;

import case_study_module2.model.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private int swimmingPoolArea;
    private int numberOfFloors;

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s", super.toString(), roomStandard, swimmingPoolArea, numberOfFloors);
    }

    public Villa() {
    }

    public Villa(String roomStandard, int swimmingPoolArea, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String serviceId, String serviceName, int usableArea, int rentalCosts, int maximumNumberOfPeople, String rentalType, String roomStandard, int swimmingPoolArea, int numberOfFloors) {
        super(serviceId, serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(int swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", super.toString(), roomStandard, swimmingPoolArea, numberOfFloors);

    }
}

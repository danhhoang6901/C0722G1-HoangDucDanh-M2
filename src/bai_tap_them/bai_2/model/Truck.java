package bai_tap_them.bai_2.model;

public class Truck extends Transport{
    private double tonnage;

    public Truck() {
    }

    public Truck(double tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(String seaOf​Control, String manufacturer, int yearOfManufacture, String owner, double tonnage) {
        super(seaOf​Control, manufacturer, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "tonnage=" + tonnage +
                "} " + super.toString();
    }
}

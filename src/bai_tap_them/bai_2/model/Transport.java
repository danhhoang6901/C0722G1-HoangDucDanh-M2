package bai_tap_them.bai_2.model;

public abstract class Transport {
    private String seaOf​Control;
    private Manufacturer manufacturer;
    private String yearOfManufacture;
    private String owner;

    public abstract String getInfo();

    public Transport() {
    }

    public Transport(String seaOf​Control, Manufacturer manufacturer, String yearOfManufacture, String owner) {
        this.seaOf​Control = seaOf​Control;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getSeaOf​Control() {
        return seaOf​Control;
    }

    public void setSeaOf​Control(String seaOf​Control) {
        this.seaOf​Control = seaOf​Control;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%S",seaOf​Control,manufacturer,yearOfManufacture,owner);
    }
}

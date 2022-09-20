package bai_tap_them.bai_2.model;

public abstract class Transport {
    private String seaOf​Control;
    private String manufacturer;
    private int yearOfManufacture;
    private String owner;

    public Transport() {
    }

    public Transport(String seaOf​Control, String manufacturer, int yearOfManufacture, String owner) {
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
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
        return "Transport{" +
                "seaOf​Control='" + seaOf​Control + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", owner='" + owner + '\'' +
                '}';
    }
}

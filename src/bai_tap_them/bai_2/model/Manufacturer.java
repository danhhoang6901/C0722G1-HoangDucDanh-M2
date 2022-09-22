package bai_tap_them.bai_2.model;

public class Manufacturer {
    private String manufacturerCode;
    private String manufacturerName;
    private String nation;

    public Manufacturer() {
    }

    public Manufacturer(String manufacturerCode, String manufacturerName, String nation) {
        this.manufacturerCode = manufacturerCode;
        this.manufacturerName = manufacturerName;
        this.nation = nation;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", manufacturerCode, manufacturerName, nation);
    }
}

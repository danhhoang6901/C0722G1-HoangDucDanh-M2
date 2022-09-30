package ss17_binary_file_serialization.exercise.product_management.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String productName;
    private String manufacturer;
    private int price;
    private String otherDescriptions;

    public Product() {
    }

    public Product(int id, String productName, String manufacturer, int price, String otherDescriptions) {
        this.id = id;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.otherDescriptions = otherDescriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(String otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", otherDescriptions='" + otherDescriptions + '\'' +
                '}';
    }
}

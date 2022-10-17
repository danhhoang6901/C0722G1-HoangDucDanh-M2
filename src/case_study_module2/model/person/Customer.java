package case_study_module2.model.person;

import java.time.LocalDate;

public class Customer extends Person {
    private String typeOfGuest;
    private String address;

    public Customer() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s", super.toString(), typeOfGuest, address);
    }

    public Customer(String typeOfGuest, String address) {
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public Customer(int id, String name, LocalDate dateOfBirth, String gender, String identityCardNumber, String phoneNumber, String email, String typeOfGuest, String address) {
        super(id, name, dateOfBirth, gender, identityCardNumber, phoneNumber, email);
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "typeOfGuest='" + typeOfGuest + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}

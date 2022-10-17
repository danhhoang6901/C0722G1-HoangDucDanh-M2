package case_study_module2.model.person;

import java.time.LocalDate;

public class Employee extends Person {
    private String level;
    private String position;
    private int wage;

    public Employee() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s", super.toString(), level, position, wage);
    }

    public Employee(String level, String position, int wage) {
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public Employee(int id, String name, LocalDate dateOfBirth, String gender, String identityCardNumber, String phoneNumber, String email, String level, String position, int wage) {
        super(id, name, dateOfBirth, gender, identityCardNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", wage=" + wage +
                "} " + super.toString();
    }
}

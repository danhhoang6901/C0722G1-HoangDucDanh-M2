package bai_tap_them.bai_1.model;

public class Teacher extends Person {
    private String specialize;

    @Override
    public String getInfo() {
        return String.format("%s,%s", super.toString(), specialize);
    }

    public Teacher() {
    }

    public Teacher(String specialize) {
        this.specialize = specialize;
    }

    public Teacher(int id, String name, String dateOfBirth, String gender, String specialize) {
        super(id, name, dateOfBirth, gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", super.toString(), specialize);
    }
}

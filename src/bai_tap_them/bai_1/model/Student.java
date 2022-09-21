package bai_tap_them.bai_1.model;

public class Student extends Person {
    private String nameClass;
    private double score;

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s", super.toString(), nameClass, score);
    }

    public Student() {
    }

    public Student(String nameClass, double score) {
        this.nameClass = nameClass;
        this.score = score;
    }

    public Student(int id, String name, String dateOfBirth, String gender, String nameClass, double score) {
        super(id, name, dateOfBirth, gender);
        this.nameClass = nameClass;
        this.score = score;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",super.toString(),nameClass,score);
    }
}

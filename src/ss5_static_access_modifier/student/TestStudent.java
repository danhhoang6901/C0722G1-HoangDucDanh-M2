package ss5_static_access_modifier.student;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
        System.out.println(student.getClasses());
        student.setName("Hoàng Đức Danh");
        student.setClasses("C0722G1");
        System.out.println(student.getName());
        System.out.println(student.getClasses());
    }
}


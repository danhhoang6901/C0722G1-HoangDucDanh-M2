package ss10_dsa.exercise;


public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static void main(String[] args) {
        Student student = new Student(1, "Danh");
        Student student1 = new Student(2, "Sơn");
        Student student2 = new Student(3, "Vinh");
        Student student3 = new Student(4, "Uy");

        MyList<Student> studentArrayList = new MyList<>();
        MyList<Student> arrayListNew = new MyList<>();
        studentArrayList.add(student);
        studentArrayList.add(student1);
        studentArrayList.add(student2);

        arrayListNew = studentArrayList.clone();
        arrayListNew.remove(2);
        System.out.println(student.getName());
//        for (int i = 0; i <arrayListNew.size() ; i++) {
//            System.out.println(arrayListNew.get(i).getName());
//        }
//        studentArrayList.add(2, student3);
//        System.out.println(studentArrayList.contains(student3));
//        System.out.println(studentArrayList.indexOf(student1));
//        System.out.println(studentArrayList.size());
//        System.out.println(studentArrayList.get(3).getName());
//

//
//        for (int i = 0; i < studentArrayList.size(); i++) {
//            Student students = (Student) studentArrayList.elements[i];
//            System.out.println(students.getId());
//            System.out.println(students.getName());
//        }
    }
}

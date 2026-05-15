package lombok;

import java.util.ArrayList;
import java.util.UUID;

public class LombokExercise {

    public static void call() {
        System.out.println("java-ecosystem-lombok");
        System.out.println();

        System.out.println("New student with lombok");
        Student s1 = new Student(UUID.randomUUID().toString(), "Max", "Musterweg", "Dr.");
        System.out.printf("%s %s lives in the street '%s'.", s1.getGrade(), s1.getName(), s1.getAddress());
        System.out.println();

        System.out.println("Create teacher");
        Teacher t1 = new Teacher(UUID.randomUUID().toString(), "Maria", "Informatik");
        Teacher t2 = new Teacher(UUID.randomUUID().toString(), "Miriam", "Informatik");

        System.out.println("Build Students");
        Student s2 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Mario")
                .address("Höfeweg")
                .build();
        Student s3 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Karl")
                .address("Musterweg")
                .build();
        Student s4 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Lisa")
                .address("Sommerterassen")
                .build();

        Course course = Course.builder().id(UUID.randomUUID().toString()).name("Java Kurs").students(new ArrayList<>()).build();
        course.setTeacher(t2);
        course.addStudent(s1);
        course.addStudent(s2);
        course.addStudent(s4);
        System.out.println();

        System.out.println("Course teacher");
        System.out.println(course.getTeacher());
        System.out.println();

        System.out.println("Course students");
        course.getStudents().stream().map(Student::getName).forEach(System.out::println);
    }
}

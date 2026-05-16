package lombok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class LombokExercise {

    public static void call() {
        System.out.println("java-ecosystem-lombok");
        System.out.println();

        System.out.println("New student with lombok");
        Student s1 = new Student(UUID.randomUUID().toString(), "Max", "Musterweg", 2);
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
                .grade(3)
                .build();
        Student s3 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Karl")
                .address("Musterweg")
                .grade(2)
                .build();
        Student s4 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Lisa")
                .address("Sommerterassen")
                .grade(1)
                .build();
        Student s5 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Lars")
                .address("Mühlenweg")
                .grade(4)
                .build();

        Course course = Course.builder().id(UUID.randomUUID().toString()).name("Java Kurs").teacher(t1).students(new ArrayList<>()).build();
        course.addStudent(s1);
        course.addStudent(s2);
        course.addStudent(s3);
        course.addStudent(s4);
        course.addStudent(s5);
        System.out.println();

        System.out.println("Create university");
        University university = new University(UUID.randomUUID().toString(), "TU Berlin", new ArrayList<>(Collections.singletonList(course)));
        System.out.println(university.courses());
        System.out.println();

        System.out.println("Course teacher");
        System.out.println(course.getTeacher());
        System.out.println();

        System.out.println("Course students");
        course.getStudents().stream().map(Student::getName).forEach(System.out::println);
    }
}

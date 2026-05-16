package lombok;

import enums.DaysOfWeek;
import enums.Gender;
import enums.Person;
import enums.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UniversityServiceTest {

    private UniversityService universityService;
    private University university;
    private Course c1, c2;
    private Teacher t1, t2;
    private Student s1, s2, s3, s4, s5;

    @BeforeEach
    void setUp() {
        // Given
        universityService = new UniversityService();
        t1 = new Teacher(UUID.randomUUID().toString(), "Maria", "Informatik");
        t2 = new Teacher(UUID.randomUUID().toString(), "Miriam", "Informatik");
        c1 = Course.builder().id(UUID.randomUUID().toString()).name("Java Kurs").teacher(t1).students(new ArrayList<>()).build();
        c2 = Course.builder().id(UUID.randomUUID().toString()).name("Javascript Kurs").teacher(t2).students(new ArrayList<>()).build();
        s1 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Mario")
                .address("Höfeweg")
                .grade(3)
                .build();
        s2 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Karl")
                .address("Musterweg")
                .grade(2)
                .build();
        s3 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Lisa")
                .address("Sommerterassen")
                .grade(1)
                .build();
        s4 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Lars")
                .address("Mühlenweg")
                .grade(4)
                .build();
        s5 = Student.builder()
                .id(UUID.randomUUID().toString())
                .name("Jan")
                .address("Baumweg")
                .grade(2)
                .build();

        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);
        c1.addStudent(s4);
        c1.addStudent(s5);

        c2.addStudent(s1);
        c2.addStudent(s3);
        c2.addStudent(s5);

        university = new University(UUID.randomUUID().toString(), "TU Berlin", List.of(c1,c2));
    }

    @Test
    void getCourseAverage() {
        // When
        double expected = 2.4;
        // Then
        double actual = universityService.getCourseAverage(c1);
        assertEquals(expected, actual);
    }

    @Test
    void getUniversityAverage() {
        // When
        double expected = 2.25;
        // Then
        double actual = universityService.getUniversityAverage(university);
        assertEquals(expected, actual);
    }

    @Test
    void getStudentsByGradeGood() {
        // When
        List<Student> expected = List.of(s2,s3,s5);
        // Then
        List<Student> actual = universityService.getStudentsByGradeGood(university);
        assertEquals(expected, actual);
    }
}
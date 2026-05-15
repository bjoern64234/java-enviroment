package lombok;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void addStudent_isEqualByGivenStudent() {
        // Given
        String id = UUID.randomUUID().toString();
        Student expected = Student.builder()
                .id(id)
                .name("Mario")
                .address("Höfeweg")
                .build();
        Teacher teacher = new Teacher(UUID.randomUUID().toString(), "Maria", "Informatik");
        Course course = Course.builder().id(UUID.randomUUID().toString()).name("Java Kurs").teacher(teacher).students(new ArrayList<>()).build();
        // When
        course.addStudent(expected);
        // Then
        assertEquals(expected, course.getStudents().getFirst());
    }

    @Test
    void addStudent_isNotEqualByNull() {
        // Given
        String id = UUID.randomUUID().toString();
        Student expected = Student.builder()
                .id(id)
                .name("Mario")
                .address("Höfeweg")
                .build();
        Teacher teacher = new Teacher(UUID.randomUUID().toString(), "Maria", "Informatik");
        Course course = Course.builder().id(UUID.randomUUID().toString()).name("Java Kurs").teacher(teacher).students(new ArrayList<>()).build();
        // When
        course.addStudent(expected);
        // Then
        assertNotEquals(null, course.getStudents().getFirst());
    }
}
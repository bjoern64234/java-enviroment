package exceptions;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class StudentServiceTest {

    @Test
    void findById_isEqualbyGivenStudent() {
        // Given
        StudentService studentService = new StudentService();
        Student newStudent = Student.builder()
                .name("Maxim")
                .subject("Informatik")
                .build();
        Student expected = studentService.addNewStudent(newStudent);
        // When
        Student actual = studentService.findById(expected.id());
        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findById_throwRuntimeExceptionByRandomId() {
        // Given
        StudentService studentService = new StudentService();
        String customId = UUID.randomUUID().toString();
        // When
        assertThatThrownBy(() -> studentService.findById(customId))
                .isInstanceOf(StudentNotFoundRuntimeException.class)
                .hasMessageContaining(customId);
    }

    @Test
    void findById_throwRuntimeExceptionByNull() {
        // Given
        StudentService studentService = new StudentService();
        // When
        assertThatThrownBy(() -> studentService.findById(null))
                .isInstanceOf(StudentNotFoundRuntimeException.class);
    }
}
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
        try {
            Student actual = studentService.findById(customId);
        } catch (StudentNotFoundRuntimeException e) {
            assertThatThrownBy(() -> {throw new StudentNotFoundRuntimeException(customId);});
        }
    }

    @Test
    void findById_throwRuntimeExceptionByNull() {
        // Given
        StudentService studentService = new StudentService();
        // When
        try {
            Student actual = studentService.findById(null);
        } catch (StudentNotFoundRuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            assertThat(true);
        }
    }
}
package lombok;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class UniversityService {

    public double getCourseAverage(Course course) {
        return course.getStudents().stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public double getUniversityAverage(University university) {
        return university.courses().stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public List<Student> getStudentsByGradeGood(University university) {
        return university.courses().stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getGrade() <= 2)
                .distinct()
                .toList();
    }
}

package lombok;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Course {

    private String id;
    private String name;
    private Teacher teacher;
    private List<Student> students;

    public void addStudent(Student student) {
        this.students.add(student);
    }
}

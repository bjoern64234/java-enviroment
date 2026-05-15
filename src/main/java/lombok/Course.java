package lombok;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class Course {

    String id;
    String name;
    Teacher teacher;
    List<Student> students;

    public void addStudent(Student student) {
        this.students.add(student);
    }
}

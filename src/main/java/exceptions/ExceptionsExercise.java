package exceptions;

public class ExceptionsExercise {

    public static void call() {
        System.out.println("java-ecosystem-exeptions");
        System.out.println();

        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();

        Student savedStudent = studentService.addNewStudent(newStudent);

        System.out.println("Student saved: " + savedStudent);

        Student student = studentService.findById(savedStudent.id());
        System.out.println(student);

        try {
            Student isStudent = studentService.findById(null);
        } catch(StudentNotFoundRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

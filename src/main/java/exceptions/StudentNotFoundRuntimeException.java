package exceptions;

public class StudentNotFoundRuntimeException extends RuntimeException{
    public StudentNotFoundRuntimeException(String message) {
        super("The student with the id of " + message + " was not found!");
    }
}

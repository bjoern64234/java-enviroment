package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {

    public static void call() throws IOException {
        System.out.println("java-ecosystem-streams");
        System.out.println();

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        // Filter even numbers
        System.out.println("Filter even numbers");
        List<Integer> evenNumbers = numbers.stream().filter(number -> (number % 2) == 0).toList();
        System.out.println(evenNumbers);
        System.out.println();

        // Map numbers to double
        System.out.println("Map numbers to double");
        List<Integer> doubleNumbers = numbers.stream().map(number -> number * 2).toList();
        System.out.println(doubleNumbers);
        System.out.println();

        // Sort numbers desc
        System.out.println("Sort numbers asc");
        List<Integer> ascNumbers = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(ascNumbers);
        System.out.println();

        // Get sum of all numbers
        System.out.println("Get sum of all numbers");
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println();

        // Print each number
        System.out.println("Print each number");
        numbers.stream().map(number -> number * 2).forEach(System.out::println);
        System.out.println();

        // Use collect
        System.out.println("Use collect");
        List<Integer> collection = numbers.stream().map(number -> number * 2).collect(Collectors.toList());
        System.out.println(collection);
        System.out.println();

        // Read csv
        List<Student> students = Files.lines(Path.of("students.csv"))
                .skip(1)
                .filter(s -> !s.isBlank())
                .map(s -> s.split(",", 4))
                .map(student -> new Student(student[0], student[1], Integer.parseInt(student[2]), Integer.parseInt(student[3])))
                .distinct()
                .toList();
        System.out.println(students);
        System.out.println();

        students.stream().map(Student::name).toList().forEach(System.out::println);
    }
}

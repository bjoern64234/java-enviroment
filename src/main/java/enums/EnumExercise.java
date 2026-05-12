package enums;

import java.util.*;

public class EnumExercise {

    public static void call() {
        System.out.println("java-ecosystem");
        System.out.println();

        // Create person repository
        PersonRepository personRepository = new PersonRepository();

        // Get weekday
        String monday = DaysOfWeek.MONDAY.getWeekday(DaysOfWeek.MONDAY);
        System.out.println(monday);
        String sunday = DaysOfWeek.MONDAY.getWeekday(DaysOfWeek.SUNDAY);
        System.out.println(sunday);

        // Create persons
        Person p1 = new Person(UUID.randomUUID().toString(), "Max", DaysOfWeek.MONDAY, Gender.DIVERSE);
        Person p2 = new Person(UUID.randomUUID().toString(), "Maria", DaysOfWeek.SUNDAY, Gender.FEMALE);
        Person p3 = new Person(UUID.randomUUID().toString(), "Maike", DaysOfWeek.SATURDAY, Gender.MALE);
        personRepository.add(p1);
        personRepository.add(p2);
        personRepository.add(p3);
        System.out.println();

        // Which person likes weekend
        System.out.println("Persons likes weekend");
        System.out.println(personRepository.likesWeekend());

        // Get person by gender
        System.out.println("get persons count by gender");
        System.out.println(personRepository.getCountOfPersonsByGender(Gender.MALE));
        System.out.println(personRepository.getCountOfPersonsByGender(Gender.FEMALE));
        System.out.println(personRepository.getCountOfPersonsByGender(Gender.DIVERSE));
        System.out.println();

        // Get person by favorite day
        System.out.println("Get person by favorite day");
        System.out.println(personRepository.getPersonsByFavoriteDay(DaysOfWeek.MONDAY));
        System.out.println(personRepository.getPersonsByFavoriteDay(DaysOfWeek.THURSDAY));
        System.out.println();

        // Get person by id
        String id = UUID.randomUUID().toString();
        System.out.println("Get person by id " + id);
        Person p4 = new Person(id, "Mario", DaysOfWeek.MONDAY, Gender.DIVERSE);
        personRepository.add(p4);
        Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = optionalPerson.orElse(new Person(UUID.randomUUID().toString(), "FALLBACK", DaysOfWeek.MONDAY, Gender.DIVERSE));
        DaysOfWeek day = person.favoriteDay();
        System.out.println(person.name() + " day: " + day);

        // Get person by name
        String name = "Karl";
        System.out.println("Get person by name " + name);
        Person p5 = new Person(UUID.randomUUID().toString(), name, DaysOfWeek.FRIDAY, Gender.DIVERSE);
        personRepository.add(p5);
        Optional<Person> optionalPersonByName = personRepository.findByName(name);
        Person personByName = optionalPersonByName.orElse(new Person(UUID.randomUUID().toString(), "FALLBACK", DaysOfWeek.MONDAY, Gender.DIVERSE));
        DaysOfWeek day2 = personByName.favoriteDay();
        System.out.println(personByName.name() + " day: " + day2);
    }
}

package enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    private PersonRepository personRepository;
    private Person p1, p2, p3;

    @BeforeEach
    void setUp() {
        // Given
        p1 = new Person(UUID.randomUUID().toString(), "Max", DaysOfWeek.MONDAY, Gender.DIVERSE);
        p2 = new Person(UUID.randomUUID().toString(), "Maria", DaysOfWeek.SUNDAY, Gender.FEMALE);
        p3 = new Person(UUID.randomUUID().toString(), "Maike", DaysOfWeek.SATURDAY, Gender.MALE);
        personRepository = new PersonRepository();
        personRepository.add(p1);
        personRepository.add(p2);
        personRepository.add(p3);
    }

    @Test
    void add_isEqualWhenAddedPersonWasFindById() {
        // When
        String id = UUID.randomUUID().toString();
        Person expected = new Person(id, "Merle", DaysOfWeek.WEDNESDAY, Gender.FEMALE);
        personRepository.add(expected);
        // Then
        Optional<Person> person = personRepository.findById(id);
        Person actual = person.orElseThrow();
        assertEquals(expected, actual);
    }

    @Test
    void remove_isNullWhenPersonWasRemoved() {
        // When
        Person expected = personRepository.getPersons().getFirst();
        personRepository.remove(expected);
        // Then
        Optional<Person> person = personRepository.findById(expected.id());
        boolean actual = person.isEmpty();
        assertTrue(actual);
    }

    @Test
    void likesWeekend_isEqualWhenGivenPersonAdded() {
        // When
        List<Person> expected = personRepository.likesWeekend();
        // Then
        List<Person> actual = new ArrayList<>();
        actual.add(p2);
        actual.add(p3);
        assertEquals(expected, actual);
    }

    @Test
    void getPersonsByFavoriteDay_isEqualWhenGivenPersonAdded() {
        List<Person> expected = personRepository.getPersonsByFavoriteDay(DaysOfWeek.MONDAY);
        // Then
        List<Person> actual = new ArrayList<>();
        actual.add(p1);
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfPersonsByGender_isEqualWhenCountIsOne() {
        int expected = personRepository.getCountOfPersonsByGender(Gender.MALE);
        // Then
        assertEquals(1, expected);
    }
}
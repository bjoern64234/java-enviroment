package enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

    private final List<Person> persons;

    public PersonRepository(List<Person> persons) {
        this.persons = persons;
    }

    public PersonRepository() {
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public void remove(Person person) {
        this.persons.remove(person);
    }

    public List<Person> likesWeekend() {
        List<Person> likesWeekend = new ArrayList<>();

        for (Person person : this.persons) {
            if (person.favoriteDay().equals(DaysOfWeek.SATURDAY) || person.favoriteDay().equals(DaysOfWeek.SUNDAY)) {
                likesWeekend.add(person);
            }
        }

        if (likesWeekend.isEmpty()) {
            System.out.println("There is no person likes weekend");
            return null;
        }


        return likesWeekend;
    }

    public List<Person> getPersonsByFavoriteDay(DaysOfWeek daysOfWeek) {
        List<Person> personsByFavoriteDay = new ArrayList<>();

        for (Person person : this.persons) {
            if (person.favoriteDay().equals(daysOfWeek)) {
                personsByFavoriteDay.add(person);
            }
        }

        if (personsByFavoriteDay.isEmpty()) {
            System.out.println("There is no person with this favorite day");
            return null;
        }

        return personsByFavoriteDay;
    }

    public int getCountOfPersonsByGender(Gender gender) {
        int count = 0;

        for (Person person : this.persons) {
            if (person.gender().equals(gender)) {
                count++;
            }
        }

        return count;
    }

    public Optional<Person> findById(String id) {

        for (Person person : this.persons) {
            if (person.id().equals(id)) {
                return Optional.of(person);
            }
        }

        return Optional.empty();
    }

    public Optional<Person> findByName(String name) {

        for (Person person : this.persons) {
            if (person.name().equals(name)) {
                return Optional.of(person);
            }
        }

        return Optional.empty();
    }
}

package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class DatetimeExercise {

    public static void call() {
        System.out.println("java-ecosystem-datetime");
        System.out.println();

        System.out.println("Format now to format: dd.MM.yy, HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter pattern =  DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
        System.out.println(localDateTime.format(pattern));
        System.out.println();

        System.out.println("Add now two weeks ahead");
        LocalDateTime addedWeeks = localDateTime.plusWeeks(2);
        System.out.println(addedWeeks.format(pattern));
        System.out.println();

        System.out.println("Calculate different between now (localDateTime) and two weeks ahead (addedWeeks)");
        long difference = ChronoUnit.DAYS.between(localDateTime, addedWeeks);
        System.out.println("The difference between is " + difference + " -> so addedWeek ist ahead.");
        System.out.println();

        System.out.println("Calculate different between now 2011-04-01 and 2001-05-22");
        LocalDate date1 = LocalDate.of(2011,4, 1);
        LocalDate date2 = LocalDate.of(2001,5, 22);
        long diff = ChronoUnit.DAYS.between(date2, date1);
        System.out.println("The difference is: " + diff + " days.");
        System.out.println();

        System.out.println("Init animal instance and calculate days to birthday");
        Animal animal = new Animal(UUID.randomUUID().toString(), "Dog", LocalDate.of(2000, 5, 20), Instant.now(), Instant.now());
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = animal.birthday().withYear(today.getYear());

        if (!nextBirthday.isAfter(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long daysToBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("In " + daysToBirthday + " days.");
    }
}

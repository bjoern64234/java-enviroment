package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        System.out.println("Init animal instance an calculate days to birthday");
        Animal animal = new Animal(UUID.randomUUID().toString(), "Dog", LocalDate.of(2024, 5, 10));
        long dayToBirthday = ChronoUnit.DAYS.between(animal.birthday(), LocalDate.now()) % ChronoUnit.YEARS.getDuration().toDays();
        System.out.println("In " + dayToBirthday + " days.");
    }
}

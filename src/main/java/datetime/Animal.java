package datetime;

import lombok.With;

import java.time.LocalDate;

@With
public record Animal(String id, String name, LocalDate birthday) {
}

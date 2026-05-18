package datetime;

import lombok.With;

import java.time.Instant;
import java.time.LocalDate;

@With
public record Animal(String id, String name, LocalDate birthday, Instant createdAt, Instant updatedAt) {
}

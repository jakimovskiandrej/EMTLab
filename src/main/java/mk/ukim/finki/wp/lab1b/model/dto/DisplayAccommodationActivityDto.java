package mk.ukim.finki.wp.lab1b.model.dto;

public record DisplayAccommodationActivityDto(
        Long id,
        String accommodationName,
        String eventType,
        java.time.LocalDateTime timestamp
) {
}

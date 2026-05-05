package mk.ukim.finki.wp.lab1b.model.dto;

import java.time.LocalDateTime;

public record DisplayAccommodationActivityDto(
        Long id,
        Long accommodationId,
        String accommodationName,
        String eventType,
        LocalDateTime timestamp
) {}
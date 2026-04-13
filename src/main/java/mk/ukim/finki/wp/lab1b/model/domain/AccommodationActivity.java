package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accommodation_activities")
public class AccommodationActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accommodationName;

    private LocalDateTime timestamp;

    private String eventType;

    public AccommodationActivity(String accommodationName, LocalDateTime timestamp, String eventType) {
        this.accommodationName = accommodationName;
        this.timestamp = timestamp;
        this.eventType = eventType;
    }
}
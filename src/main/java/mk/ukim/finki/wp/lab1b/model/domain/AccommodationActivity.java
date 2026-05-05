package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.wp.lab1b.model.enums.EventType;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accommodation_activities")
public class AccommodationActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "event_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    public AccommodationActivity(Accommodation accommodation, LocalDateTime timestamp, EventType eventType) {
        this.accommodation = accommodation;
        this.timestamp = timestamp;
        this.eventType = eventType;
    }
}
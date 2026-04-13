package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "accommodation_stats")
@Immutable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationStats {

    @Id
    @Column(name = "category")
    private String category;

    @Column(name = "country")
    private String country;

    @Column(name = "total_accommodations")
    private Long totalAccommodations;

    @Column(name = "total_rooms")
    private Long totalRooms;

    @Column(name = "avg_rooms")
    private Double avgRooms;
}
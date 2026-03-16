package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accommodations")
public class Accommodation extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private AccommodationCategory accommodationCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccommodationCondition accommodationCondition;

    @ManyToOne
    private Host host;

    @Column(nullable = false)
    private Integer numRooms;

    public Accommodation(String name, AccommodationCategory accommodationCategory, AccommodationCondition accommodationCondition, Host host, Integer numRooms) {
        this.name = name;
        this.accommodationCategory = accommodationCategory;
        this.accommodationCondition = accommodationCondition;
        this.host = host;
        this.numRooms = numRooms;
    }
}

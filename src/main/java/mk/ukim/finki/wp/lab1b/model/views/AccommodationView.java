package mk.ukim.finki.wp.lab1b.model.views;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDateTime;

@Entity
@Getter
@Immutable
@Table(name = "accommodation_view")
public class AccommodationView {

    @Id
    private Long id;

    private String name;

    private String accommodationCategory;

    private Integer numRooms;

    private String hostName;

    private String hostSurname;

    private String country;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

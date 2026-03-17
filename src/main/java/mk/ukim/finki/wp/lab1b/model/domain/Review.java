package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reviews")
public class Review extends BaseAuditableEntity {

    private String comment;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    public Review(String comment, int rating, Accommodation accommodation) {
        this.comment = comment;
        this.rating = rating;
        this.accommodation = accommodation;
    }
}

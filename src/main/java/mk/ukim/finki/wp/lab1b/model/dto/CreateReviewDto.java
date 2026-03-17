package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import mk.ukim.finki.wp.lab1b.model.domain.Review;

public record CreateReviewDto(Long accommodationId, String comment, int rating) {

    public Review toReview(Accommodation accommodation) {
        return new Review(comment, rating, accommodation);
    }

}

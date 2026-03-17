package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.Review;
import java.util.List;

public record DisplayReviewDto(Long id, String comment, int rating, Long accommodationId) {

    public static DisplayReviewDto from(Review review) {
        return new DisplayReviewDto(review.getId(),
                review.getComment(), review.getRating(),
                review.getAccommodation().getId());
    }

    public static List<DisplayReviewDto> from(List<Review> reviews) {
        return reviews.stream().map(DisplayReviewDto::from).toList();
    }

}

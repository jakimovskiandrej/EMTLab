package mk.ukim.finki.wp.lab1b.service.application.impl;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import mk.ukim.finki.wp.lab1b.model.domain.Review;
import mk.ukim.finki.wp.lab1b.model.dto.CreateReviewDto;
import mk.ukim.finki.wp.lab1b.model.dto.DisplayReviewDto;
import mk.ukim.finki.wp.lab1b.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.wp.lab1b.service.application.ReviewApplicationService;
import mk.ukim.finki.wp.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.wp.lab1b.service.domain.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewApplicationServiceImpl implements ReviewApplicationService {

    private final ReviewService reviewService;
    private final AccommodationService accommodationService;

    public ReviewApplicationServiceImpl(ReviewService reviewService, AccommodationService accommodationService) {
        this.reviewService = reviewService;
        this.accommodationService = accommodationService;
    }

    @Override
    public Optional<DisplayReviewDto> findById(Long id) {
        return reviewService.findById(id).map(DisplayReviewDto::from);
    }

    @Override
    public List<DisplayReviewDto> findAll() {
        return DisplayReviewDto.from(reviewService.findAll());
    }

    @Override
    public DisplayReviewDto create(Long accommodationId, CreateReviewDto createReviewDto) {
        Accommodation accommodation = accommodationService
                .findById(createReviewDto.accommodationId())
                .orElseThrow(() -> new AccommodationNotFoundException(accommodationId));
        Review review = createReviewDto.toReview(accommodation);
        review = reviewService.create(review);
        return DisplayReviewDto.from(review);
    }

    @Override
    public Optional<DisplayReviewDto> update(Long id, CreateReviewDto createReviewDto) {
        return reviewService.findById(id).map((existingReview) -> {
            existingReview.setComment(existingReview.getComment());
            existingReview.setRating(existingReview.getRating());
            return DisplayReviewDto.from(existingReview);
        });
    }

    @Override
    public Optional<DisplayReviewDto> deleteById(Long id) {
        return reviewService.findById(id).map(DisplayReviewDto::from);
    }
}

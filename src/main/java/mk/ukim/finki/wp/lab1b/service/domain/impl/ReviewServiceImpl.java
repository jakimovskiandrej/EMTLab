package mk.ukim.finki.wp.lab1b.service.domain.impl;

import mk.ukim.finki.wp.lab1b.model.domain.Review;
import mk.ukim.finki.wp.lab1b.repository.ReviewRepository;
import mk.ukim.finki.wp.lab1b.service.domain.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> update(Long id, Review review) {
        return reviewRepository.findById(id)
                .map((existingReview) -> {
                    existingReview.setComment(review.getComment());
                    existingReview.setRating(review.getRating());
                    return reviewRepository.save(existingReview);
                });
    }

    @Override
    public Optional<Review> deleteById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        review.ifPresent(reviewRepository::delete);
        return review;
    }
}

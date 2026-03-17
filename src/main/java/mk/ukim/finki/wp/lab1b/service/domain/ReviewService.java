package mk.ukim.finki.wp.lab1b.service.domain;

import mk.ukim.finki.wp.lab1b.model.domain.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findById(Long id);

    List<Review> findAll();

    Review create(Review review);

    Optional<Review> update(Long id, Review review);

    Optional<Review> deleteById(Long id);
}

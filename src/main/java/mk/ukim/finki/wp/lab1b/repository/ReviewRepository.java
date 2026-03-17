package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import mk.ukim.finki.wp.lab1b.model.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByAccommodation(Accommodation accommodation);
}

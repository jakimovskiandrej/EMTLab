package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.domain.AccommodationActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationActivityRepository extends JpaRepository<AccommodationActivity, Long> {
    Page<AccommodationActivity> findAll(Pageable pageable);
}

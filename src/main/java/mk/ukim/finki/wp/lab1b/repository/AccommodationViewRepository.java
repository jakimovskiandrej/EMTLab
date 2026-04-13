package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.views.AccommodationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationViewRepository extends JpaRepository<AccommodationView, Integer> {
    @Modifying
    @Query(value = "call refresh_accommodation_view()", nativeQuery = true)
    void refresh();
}

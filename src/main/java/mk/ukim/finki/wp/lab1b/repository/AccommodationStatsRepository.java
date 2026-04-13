package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.domain.AccommodationStats;
import mk.ukim.finki.wp.lab1b.model.projection.AccommodationStatsProjection;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccommodationStatsRepository extends JpaRepository<AccommodationStats,String> {
    @Query(value = "SELECT * FROM accommodation_stats", nativeQuery = true)
    List<AccommodationStatsProjection> findStats();
}

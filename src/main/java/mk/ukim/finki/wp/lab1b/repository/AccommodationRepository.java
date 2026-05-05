package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import mk.ukim.finki.wp.lab1b.model.dto.PopularAccommodationDto;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @EntityGraph(value = "Accommodation.host-country", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Accommodation> findById(Long id);
    @Query("""
SELECT new mk.ukim.finki.wp.lab1b.model.dto.PopularAccommodationDto(
    acc.id,
    acc.name,
    COUNT(a)
)
FROM AccommodationActivity a
JOIN a.accommodation acc
WHERE a.eventType = 'RENT'
GROUP BY acc.id, acc.name
ORDER BY COUNT(a) DESC
""")
    List<PopularAccommodationDto> findMostPopularAccommodations();
}

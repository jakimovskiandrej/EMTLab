package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @EntityGraph(value = "Accommodation.host-country", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Accommodation> findById(Long id);
}

package mk.ukim.finki.wp.lab1b.repository;

import mk.ukim.finki.wp.lab1b.model.domain.Host;
import mk.ukim.finki.wp.lab1b.model.dto.PopularHostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    @Query("""
    SELECT new mk.ukim.finki.wp.lab1b.model.dto.PopularHostDto(
        h.id,
        CONCAT(h.name, ' ', h.surname),
        COUNT(a)
    )
    FROM AccommodationActivity a
    INNER JOIN a.accommodation acc
    INNER JOIN acc.host h
    WHERE a.eventType = 'RENT'
    GROUP BY h.id, h.name, h.surname
    ORDER BY COUNT(a) DESC
""")
    List<PopularHostDto> findMostPopularHosts();
}

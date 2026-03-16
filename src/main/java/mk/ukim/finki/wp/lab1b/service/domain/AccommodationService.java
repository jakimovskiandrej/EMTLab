package mk.ukim.finki.wp.lab1b.service.domain;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import java.util.*;

public interface AccommodationService {
    Optional<Accommodation> findById(Long id);

    List<Accommodation> findAll();

    Accommodation create(Accommodation accommodation);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    Optional<Accommodation> deleteById(Long id);
}

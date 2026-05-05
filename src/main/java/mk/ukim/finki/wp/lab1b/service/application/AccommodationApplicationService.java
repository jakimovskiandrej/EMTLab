package mk.ukim.finki.wp.lab1b.service.application;

import mk.ukim.finki.wp.lab1b.model.dto.*;
import org.springframework.data.domain.Page;
import java.util.*;

public interface AccommodationApplicationService {
    Optional<DisplayAccommodationDto> findById(Long id);

    List<DisplayAccommodationDto> findAll();

    DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> deleteById(Long id);

    Page<DisplayAccommodationDto> findAll(int page, int size, String sortBy);

    void rentAccommodation(Long id);

    List<PopularAccommodationDto> getMostPopularAccommodations();
}

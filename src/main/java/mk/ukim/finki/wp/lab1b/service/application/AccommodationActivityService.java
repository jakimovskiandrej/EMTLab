package mk.ukim.finki.wp.lab1b.service.application;

import mk.ukim.finki.wp.lab1b.model.dto.DisplayAccommodationActivityDto;
import org.springframework.data.domain.Page;

public interface AccommodationActivityService {
    Page<DisplayAccommodationActivityDto> findAll(int page, int size);
}

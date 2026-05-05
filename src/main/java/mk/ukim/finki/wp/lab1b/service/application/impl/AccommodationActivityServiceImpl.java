package mk.ukim.finki.wp.lab1b.service.application.impl;

import mk.ukim.finki.wp.lab1b.model.dto.DisplayAccommodationActivityDto;
import mk.ukim.finki.wp.lab1b.repository.AccommodationActivityRepository;
import mk.ukim.finki.wp.lab1b.service.application.AccommodationActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccommodationActivityServiceImpl implements AccommodationActivityService {

    private final AccommodationActivityRepository repository;

    public AccommodationActivityServiceImpl(AccommodationActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<DisplayAccommodationActivityDto> findAll(int page, int size) {

        return repository.findAll(PageRequest.of(page, size))
                .map(activity -> new DisplayAccommodationActivityDto(
                        activity.getId(),
                        activity.getAccommodation().getId(),
                        activity.getAccommodation().getName(),
                        activity.getEventType().name(),
                        activity.getTimestamp()
                ));
    }

}
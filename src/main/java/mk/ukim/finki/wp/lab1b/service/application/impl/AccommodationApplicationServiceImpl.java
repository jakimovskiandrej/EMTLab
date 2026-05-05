package mk.ukim.finki.wp.lab1b.service.application.impl;

import mk.ukim.finki.wp.lab1b.events.AccommodationRentedEvent;
import mk.ukim.finki.wp.lab1b.events.AccommodationSoldOutEvent;
import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import mk.ukim.finki.wp.lab1b.model.domain.Host;
import mk.ukim.finki.wp.lab1b.model.dto.*;
import mk.ukim.finki.wp.lab1b.model.exception.HostNotFoundException;
import mk.ukim.finki.wp.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.wp.lab1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.wp.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.wp.lab1b.service.domain.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;
    private final ApplicationEventPublisher eventPublisher;
    private final AccommodationRepository accommodationRepository;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService,
                                               HostService hostService,
                                               ApplicationEventPublisher eventPublisher,
                                               AccommodationRepository accommodationRepository) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
        this.eventPublisher = eventPublisher;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFoundException(createAccommodationDto.hostId()));
        return DisplayAccommodationDto.from(accommodationService.create(createAccommodationDto.toAccommodation(host)));
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFoundException(createAccommodationDto.hostId()));
        return accommodationService.update(id,createAccommodationDto.toAccommodation(host))
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> deleteById(Long id) {
        return accommodationService.deleteById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Page<DisplayAccommodationDto> findAll(int page, int size, String sortBy) {
        return accommodationService.findAll(page,size,sortBy)
                .map(DisplayAccommodationDto::from);
    }

    public void rentAccommodation(Long id) {
        Accommodation acc = accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        acc.setNumRooms(acc.getNumRooms() - 1);

        if (acc.getTotalRents() == null) {
            acc.setTotalRents(1);
        } else {
            acc.setTotalRents(acc.getTotalRents() + 1);
        }

        accommodationRepository.save(acc);
        eventPublisher.publishEvent(new AccommodationRentedEvent(acc));

        if (acc.getNumRooms() == 0) {
            eventPublisher.publishEvent(new AccommodationSoldOutEvent(acc));
        }
    }

    @Override
    public List<PopularAccommodationDto> getMostPopularAccommodations() {
        return accommodationService.getMostPopularAccommodations();
    }
}

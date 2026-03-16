package mk.ukim.finki.wp.lab1b.service.application.impl;

import mk.ukim.finki.wp.lab1b.model.domain.Host;
import mk.ukim.finki.wp.lab1b.model.dto.*;
import mk.ukim.finki.wp.lab1b.model.exception.HostNotFoundException;
import mk.ukim.finki.wp.lab1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.wp.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.wp.lab1b.service.domain.HostService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
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
}

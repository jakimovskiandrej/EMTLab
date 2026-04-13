package mk.ukim.finki.wp.lab1b.service.domain.impl;

import mk.ukim.finki.wp.lab1b.model.domain.Accommodation;
import mk.ukim.finki.wp.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.wp.lab1b.service.domain.AccommodationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id).map((existingAccommodation) -> {
            existingAccommodation.setName(accommodation.getName());
            existingAccommodation.setAccommodationCategory(accommodation.getAccommodationCategory());
            existingAccommodation.setAccommodationCondition(accommodation.getAccommodationCondition());
            existingAccommodation.setHost(accommodation.getHost());
            existingAccommodation.setNumRooms(accommodation.getNumRooms());
            return accommodationRepository.save(existingAccommodation);
        });
    }

    @Override
    public Optional<Accommodation> deleteById(Long id) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(id);
        accommodation.ifPresent(accommodationRepository::delete);
        return accommodation;
    }

    @Override
    public Page<Accommodation> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return accommodationRepository.findAll(pageable);
    }

}

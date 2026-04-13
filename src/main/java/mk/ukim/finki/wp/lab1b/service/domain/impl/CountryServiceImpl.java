package mk.ukim.finki.wp.lab1b.service.domain.impl;

import mk.ukim.finki.wp.lab1b.model.domain.Country;
import mk.ukim.finki.wp.lab1b.repository.CountryRepository;
import mk.ukim.finki.wp.lab1b.service.domain.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id).map((existingCountry) -> {
            existingCountry.setName(country.getName());
            existingCountry.setContinent(country.getContinent());
            return countryRepository.save(existingCountry);
        });
    }

    @Override
    public Optional<Country> deleteById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        country.ifPresent(countryRepository::delete);
        return country;
    }

    @Override
    public Page<Country> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));
        return countryRepository.findAll(pageable);
    }
}

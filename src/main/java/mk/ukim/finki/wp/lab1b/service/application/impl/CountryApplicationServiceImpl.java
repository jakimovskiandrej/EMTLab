package mk.ukim.finki.wp.lab1b.service.application.impl;

import mk.ukim.finki.wp.lab1b.model.dto.CreateCountryDto;
import mk.ukim.finki.wp.lab1b.model.dto.DisplayCountryDto;
import mk.ukim.finki.wp.lab1b.service.application.CountryApplicationService;
import mk.ukim.finki.wp.lab1b.service.domain.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());
    }

    @Override
    public DisplayCountryDto create(CreateCountryDto createCountryDto) {
        return DisplayCountryDto.from(countryService.create(createCountryDto.toCountry()));
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.update(id,createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> deleteById(Long id) {
        return countryService.deleteById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Page<DisplayCountryDto> findAll(int page, int size, String sortBy) {
        return null;
    }
}

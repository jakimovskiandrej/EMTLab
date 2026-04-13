package mk.ukim.finki.wp.lab1b.service.application;

import mk.ukim.finki.wp.lab1b.model.dto.*;
import org.springframework.data.domain.Page;

import java.util.*;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> findById(Long id);

    List<DisplayCountryDto> findAll();

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> deleteById(Long id);

    Page<DisplayCountryDto> findAll(int page, int size, String sortBy);
}

package mk.ukim.finki.wp.lab1b.service.domain;

import mk.ukim.finki.wp.lab1b.model.domain.Country;
import org.springframework.data.domain.Page;

import java.util.*;

public interface CountryService {
    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country create(Country country);

    Optional<Country> update(Long id, Country country);

    Optional<Country> deleteById(Long id);

    Page<Country> findAll(int page, int size, String sortBy);
}

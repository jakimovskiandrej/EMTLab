package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.Country;

public record CreateCountryDto(String name, String continent) {

    public Country toCountry() {
        return new Country(name, continent);
    }

}

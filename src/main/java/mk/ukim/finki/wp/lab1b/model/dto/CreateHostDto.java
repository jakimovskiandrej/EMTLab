package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.Country;
import mk.ukim.finki.wp.lab1b.model.domain.Host;

public record CreateHostDto(String name,
                            String surname,
                            Long countryId) {

    public Host toHost(Country country) {
        return new Host(name,surname,country);
    }

}

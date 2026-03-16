package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.Host;
import java.util.List;

public record DisplayHostDto(Long id,
                             String name,
                             String surname,
                             Long countryId) {

    public static DisplayHostDto from(Host host) {
        return new DisplayHostDto(host.getId(),
                host.getName(),
                host.getSurname(),
                host.getCountry().getId());
    }

    public static List<DisplayHostDto> from(List<Host> hosts) {
        return hosts.stream().map(DisplayHostDto::from).toList();
    }

}

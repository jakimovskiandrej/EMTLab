package mk.ukim.finki.wp.lab1b.model.dto;

import jakarta.validation.constraints.*;
import mk.ukim.finki.wp.lab1b.model.domain.*;

public record CreateAccommodationDto(String name,
                                     AccommodationCondition accommodationCondition,
                                     AccommodationCategory accommodationCategory,
                                     Long hostId,
                                     @Positive
                                     Integer numRooms) {

    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name,accommodationCategory,accommodationCondition,host,numRooms);
    }

}

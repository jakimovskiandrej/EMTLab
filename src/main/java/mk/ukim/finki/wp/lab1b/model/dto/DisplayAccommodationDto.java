package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.*;
import mk.ukim.finki.wp.lab1b.model.enums.AccommodationCategory;
import mk.ukim.finki.wp.lab1b.model.enums.AccommodationCondition;

import java.util.List;

public record DisplayAccommodationDto(Long id,
                                      String name,
                                      AccommodationCondition accommodationCondition,
                                      AccommodationCategory accommodationCategory,
                                      Long hostId,
                                      Integer numRooms) {

    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getAccommodationCondition(),
                accommodation.getAccommodationCategory(),
                accommodation.getHost().getId(),
                accommodation.getNumRooms()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).toList();
    }

}

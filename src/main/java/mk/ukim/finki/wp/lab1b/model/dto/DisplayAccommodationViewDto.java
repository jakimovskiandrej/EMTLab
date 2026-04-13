package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.views.AccommodationView;

import java.util.List;

public record DisplayAccommodationViewDto(
        Long id,
        String name,
        String accommodationCategory,
        Integer numRooms,
        String hostName,
        String hostSurname,
        String country
) {

    public static DisplayAccommodationViewDto from(AccommodationView accommodationView) {
        return new DisplayAccommodationViewDto(
                accommodationView.getId(),
                accommodationView.getName(),
                accommodationView.getAccommodationCategory(),
                accommodationView.getNumRooms(),
                accommodationView.getHostName(),
                accommodationView.getHostSurname(),
                accommodationView.getCountry()
        );
    }

    public static List<DisplayAccommodationViewDto> from(List<AccommodationView> accommodationViews) {
        return accommodationViews.stream()
                .map(DisplayAccommodationViewDto::from)
                .toList();
    }
}

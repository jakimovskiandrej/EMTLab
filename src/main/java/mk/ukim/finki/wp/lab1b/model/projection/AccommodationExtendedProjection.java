package mk.ukim.finki.wp.lab1b.model.projection;

public interface AccommodationExtendedProjection {
    Long getId();
    String getName();
    String getAccommodationCategory();
    Integer getNumRooms();
    String getHostName();
    String getHostSurname();
    String getCountry();
}

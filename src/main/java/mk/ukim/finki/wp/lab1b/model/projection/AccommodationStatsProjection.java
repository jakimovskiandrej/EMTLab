package mk.ukim.finki.wp.lab1b.model.projection;

public interface AccommodationStatsProjection {
    String getCategory();
    Long getTotalAccommodations();
    Integer getTotalRooms();
    Double getAvgRooms();
}

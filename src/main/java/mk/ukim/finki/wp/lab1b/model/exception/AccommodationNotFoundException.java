package mk.ukim.finki.wp.lab1b.model.exception;

public class AccommodationNotFoundException extends RuntimeException {
    public AccommodationNotFoundException(Long id) {
        super("Accommodation with id %d does not exist.".formatted(id));
    }
}

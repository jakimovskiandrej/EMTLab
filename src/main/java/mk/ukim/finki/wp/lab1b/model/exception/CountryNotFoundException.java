package mk.ukim.finki.wp.lab1b.model.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super("Country with id %d does not exist.".formatted(id));
    }
}

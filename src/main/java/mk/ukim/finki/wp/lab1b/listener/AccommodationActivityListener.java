package mk.ukim.finki.wp.lab1b.listener;

import mk.ukim.finki.wp.lab1b.events.AccommodationRentedEvent;
import mk.ukim.finki.wp.lab1b.model.domain.AccommodationActivity;
import mk.ukim.finki.wp.lab1b.model.enums.EventType;
import mk.ukim.finki.wp.lab1b.repository.AccommodationActivityRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class AccommodationActivityListener {

    private final AccommodationActivityRepository repository;

    public AccommodationActivityListener(AccommodationActivityRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void onAccommodationRented(AccommodationRentedEvent event) {
        AccommodationActivity activity = new AccommodationActivity(
                event.accommodation(),
                LocalDateTime.now(),
                EventType.RENT
        );

        repository.save(activity);
    }
}
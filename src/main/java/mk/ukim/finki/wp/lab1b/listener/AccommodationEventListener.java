package mk.ukim.finki.wp.lab1b.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.lab1b.events.AccommodationRentedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class AccommodationEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onAccommodationRented(AccommodationRentedEvent event) {

        log.info("[ASYNC - thread: {}] Accommodation rented: '{}'",
                Thread.currentThread().getName(),
                event.accommodation().getName()
        );

        simulateNotification(event);
    }

    private void simulateNotification(AccommodationRentedEvent event) {
        try {
            Thread.sleep(2000);

            log.info("Notification sent for accommodation: '{}'",
                    event.accommodation().getName()
            );

            if (event.accommodation().getNumRooms() == 0) {
                log.warn("WARNING: No rooms left for '{}'",
                        event.accommodation().getName()
                );
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
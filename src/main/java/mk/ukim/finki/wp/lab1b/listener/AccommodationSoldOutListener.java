package mk.ukim.finki.wp.lab1b.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.lab1b.events.AccommodationSoldOutEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.event.TransactionPhase;

@Component
@Slf4j
public class AccommodationSoldOutListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onAccommodationSoldOut(AccommodationSoldOutEvent event) {

        log.warn("SOLD OUT: '{}' has no available rooms!",
                event.accommodation().getName()
        );

        log.info("Accommodation '{}' is now fully booked.",
                event.accommodation().getName()
        );

        simulateSaveActivity(event);
    }

    private void simulateSaveActivity(AccommodationSoldOutEvent event) {
        log.info("Saving SOLD_OUT activity for accommodation: {}",
                event.accommodation().getName()
        );
    }
}
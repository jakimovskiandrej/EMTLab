package mk.ukim.finki.wp.lab1b.jobs;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.lab1b.repository.AccommodationViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {

    private final AccommodationViewRepository accommodationViewRepository;

    public MaterializedViewRefreshScheduler(AccommodationViewRepository accommodationViewRepository) {
        this.accommodationViewRepository = accommodationViewRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshAccommodationView() {
        log.info("Refreshing ACCOMMODATION_VIEW...");
        accommodationViewRepository.refresh();
        log.info("ACCOMMODATION_VIEW successfully refreshed.");
    }

}

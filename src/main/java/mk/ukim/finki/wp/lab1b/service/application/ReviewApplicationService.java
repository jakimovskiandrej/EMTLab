package mk.ukim.finki.wp.lab1b.service.application;

import mk.ukim.finki.wp.lab1b.model.dto.CreateReviewDto;
import mk.ukim.finki.wp.lab1b.model.dto.DisplayReviewDto;
import java.util.List;
import java.util.Optional;

public interface ReviewApplicationService {
    Optional<DisplayReviewDto> findById(Long id);

    List<DisplayReviewDto> findAll();

    DisplayReviewDto create(Long accommodationId, CreateReviewDto createReviewDto);

    Optional<DisplayReviewDto> update(Long id, CreateReviewDto createReviewDto);

    Optional<DisplayReviewDto> deleteById(Long id);
}

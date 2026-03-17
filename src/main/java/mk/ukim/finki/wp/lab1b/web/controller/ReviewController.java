package mk.ukim.finki.wp.lab1b.web.controller;

import mk.ukim.finki.wp.lab1b.model.dto.CreateReviewDto;
import mk.ukim.finki.wp.lab1b.model.dto.DisplayReviewDto;
import mk.ukim.finki.wp.lab1b.service.application.ReviewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewApplicationService reviewApplicationService;

    public ReviewController(ReviewApplicationService reviewApplicationService) {
        this.reviewApplicationService = reviewApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayReviewDto> findById(@PathVariable Long id) {
        return reviewApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayReviewDto>> findAll() {
        return ResponseEntity.ok(reviewApplicationService.findAll());
    }

    @PostMapping("/accommodation/{accommodationId}/add")
    public ResponseEntity<DisplayReviewDto> create(
            @PathVariable Long accommodationId,
            @RequestBody @Valid CreateReviewDto createReviewDto) {

        return ResponseEntity.ok(
                reviewApplicationService.create(accommodationId, createReviewDto)
        );
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayReviewDto> update(
            @PathVariable Long id,
            @RequestBody CreateReviewDto createReviewDto
    ) {
        return reviewApplicationService
                .update(id, createReviewDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayReviewDto> deleteById(@PathVariable Long id) {
        return reviewApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/accommodation/{accommodationId}/average-rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long accommodationId) {

        List<DisplayReviewDto> reviews = reviewApplicationService
                .findAll()
                .stream()
                .filter(r -> r.accommodationId().equals(accommodationId))
                .toList();

        double avgRating = reviews.stream()
                .mapToInt(DisplayReviewDto::rating)
                .average()
                .orElse(0.0);

        return ResponseEntity.ok(avgRating);
    }
}

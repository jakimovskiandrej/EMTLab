package mk.ukim.finki.wp.lab1b.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.wp.lab1b.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.lab1b.model.dto.CreateReviewDto;
import mk.ukim.finki.wp.lab1b.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.wp.lab1b.model.dto.DisplayReviewDto;
import mk.ukim.finki.wp.lab1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.wp.lab1b.service.application.ReviewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationApplicationService accommodationApplicationService;
    private final ReviewApplicationService reviewApplicationService;

    public AccommodationController(AccommodationApplicationService accommodationApplicationService, ReviewApplicationService reviewApplicationService) {
        this.accommodationApplicationService = accommodationApplicationService;
        this.reviewApplicationService = reviewApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return accommodationApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> create(@RequestBody @Valid CreateAccommodationDto createAccommodationDto) {
        return ResponseEntity.ok(accommodationApplicationService.create(createAccommodationDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayAccommodationDto> update(
            @PathVariable Long id,
            @RequestBody CreateAccommodationDto createAccommodationDto
    ) {
        return accommodationApplicationService
                .update(id, createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayAccommodationDto> deleteById(@PathVariable Long id) {
        return accommodationApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<DisplayReviewDto> addReview(
            @PathVariable Long id,
            @RequestBody @Valid CreateReviewDto createReviewDto
    ) {

        DisplayReviewDto review = reviewApplicationService.create(id, createReviewDto);

        return ResponseEntity.ok(review);
    }

}

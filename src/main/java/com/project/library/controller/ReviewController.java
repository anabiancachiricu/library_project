package com.project.library.controller;

import com.project.library.dto.BookDto;
import com.project.library.dto.ReviewDto;
import com.project.library.service.BookServiceImplementation;
import com.project.library.service.ReviewServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewServiceImplementation reviewServiceImplementation;

    @PostMapping("/add")
    public ResponseEntity<ReviewDto> addReview(@RequestBody @Valid ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewServiceImplementation.add(reviewDto));
    }

    @GetMapping("/book/{title}")
    public ResponseEntity<List<ReviewDto>> getReviewByBookTitle(@PathVariable String title) {
        return ResponseEntity.ok(reviewServiceImplementation.getReviewByBook_Title(title));
    }

    @GetMapping("/client/{lastname}")
    public ResponseEntity<List<ReviewDto>> getReviewByClientLastName(@PathVariable String lastname) {
        return ResponseEntity.ok(reviewServiceImplementation.getReviewByClient_LastName(lastname));
    }
}

package com.project.library.mapper;

import com.project.library.dto.ReviewDto;
import com.project.library.entity.Review;
import com.project.library.repository.BookRepository;
import com.project.library.repository.ClientRepository;
import com.project.library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper implements GenericMapper<Review, ReviewDto> {

    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;

    public ReviewMapper(BookRepository bookRepository,
                        ClientRepository clientRepository) {
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Review mapToClass(ReviewDto reviewDto) {
        return Review.builder()
                .book(bookRepository.findBookByBookId(reviewDto.getBookId()))
                .reviewGrade(reviewDto.getReviewGrade())
                .reviewText(reviewDto.getReviewText())
                .client(clientRepository.findClientByClientId(reviewDto.getClientId()))
                .build();
    }

    @Override
    public ReviewDto mapToDto(Review review) {
        return ReviewDto.builder()
                .reviewId(review.getReviewId())
                .bookId(review.getBook().getBookId())
                .reviewGrade(review.getReviewGrade())
                .reviewText(review.getReviewText())
                .clientId(review.getClient().getClientId())
                .build();
    }
}

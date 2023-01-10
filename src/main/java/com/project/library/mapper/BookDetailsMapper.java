package com.project.library.mapper;

import com.project.library.dto.BookDetailsDto;
import com.project.library.entity.BookDetails;
import org.springframework.stereotype.Component;

@Component
public class BookDetailsMapper implements GenericMapper<BookDetails, BookDetailsDto> {

    public BookDetails mapToClass(BookDetailsDto bookDetailsDto) {
        return BookDetails.builder()
                .description(bookDetailsDto.getDescription())
                .noOfPages(bookDetailsDto.getNoOfPages())
                .publishingYear(bookDetailsDto.getPublishingYear())
                .build();
    }

    public BookDetailsDto mapToDto(BookDetails bookDetails) {
        return BookDetailsDto.builder()
                .bookDetailsId(bookDetails.getBookDetailsId())
                .description(bookDetails.getDescription())
                .noOfPages(bookDetails.getNoOfPages())
                .publishingYear(bookDetails.getPublishingYear())
                .build();
    }
}

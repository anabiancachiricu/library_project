package com.project.library.mapper;

import com.project.library.dto.BookDto;
import com.project.library.entity.Author;
import com.project.library.entity.Book;
import com.project.library.repository.AuthorRepository;
import com.project.library.repository.BookDetailsRepository;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements GenericMapper<Book, BookDto> {
    private final AuthorRepository authorRepository;
    private final BookDetailsRepository bookDetailsRepository;

    public BookMapper(AuthorRepository authorRepository,
                      BookDetailsRepository bookDetailsRepository) {
        this.authorRepository = authorRepository;
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public Book mapToClass(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .quantity(bookDto.getQuantity())
                .author(authorRepository.findByAuthorId(bookDto.getAuthorId()))
                .bookdetails(bookDetailsRepository.findByBookDetailsId(bookDto.getBookDetailsId()))
                .build();
    }

    public BookDto mapToDto(Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .quantity(book.getQuantity())
                .authorId(book.getAuthor().getAuthorId())
                .bookDetailsId(book.getBookdetails().getBookDetailsId())
                .build();
    }
}



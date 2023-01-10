package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.BookDto;
import com.project.library.entity.Book;
import com.project.library.exception.BookNotFoundException;
import com.project.library.mapper.BookMapper;
import com.project.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementation implements GenericService<BookDto>{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    private AuthorServiceImplementation authorServiceImplementation;
    private BookDetailsServiceImplementation bookDetailsServiceImplementation;


    @Override
    public BookDto add(BookDto bookDto) {
            return bookMapper.mapToDto(bookRepository.save(bookMapper.mapToClass(bookDto)));
    }

    public List<BookDto> getBookByAuthor_LastName(String lastName) {
        List<BookDto> bookDtos = bookRepository.findBookByAuthor_LastName(lastName).stream()
                .map(book -> bookMapper.mapToDto(book)).collect(Collectors.toList());
        if (bookDtos.isEmpty()) {
            throw new BookNotFoundException(Constants.NO_BOOKS_FOUND);
        }
        return bookDtos;
    }

    public List<BookDto> getAll() {
        List<BookDto> bookDtos = bookRepository.findAll().stream()
                .map(book -> bookMapper.mapToDto(book)).collect(Collectors.toList());
        if (bookDtos.isEmpty()) {
            throw new BookNotFoundException(Constants.NO_BOOKS_FOUND);
        }
        return bookDtos;
    }

    public List<BookDto> getBookByTitle(String title) {
        List<BookDto> bookDtos = bookRepository.findBookByTitle(title).stream()
                .map(book -> bookMapper.mapToDto(book)).collect(Collectors.toList());
        if (bookDtos.isEmpty()) {
            throw new BookNotFoundException(Constants.NO_BOOKS_FOUND);
        }
        return bookDtos;
    }

    public BookDto getBookByBookId (int id){
        Book book= bookRepository.findBookByBookId(id);
        if (book== null) {
            throw new BookNotFoundException(Constants.NO_BOOK_FOUND);
        }
        return bookMapper.mapToDto(book);

    }

}

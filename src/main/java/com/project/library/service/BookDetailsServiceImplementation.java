package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.BookDetailsDto;
import com.project.library.entity.BookDetails;
import com.project.library.exception.BookDetailsNotFoundException;
import com.project.library.mapper.BookDetailsMapper;
import com.project.library.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailsServiceImplementation implements GenericService<BookDetailsDto> {

    @Autowired
    private BookDetailsRepository bookDetailsRepository;

    @Autowired
    private BookDetailsMapper bookDetailsMapper;

    @Override
    public BookDetailsDto add(BookDetailsDto bookDetailsDto) {
        return bookDetailsMapper.mapToDto(bookDetailsRepository.save(bookDetailsMapper.mapToClass(bookDetailsDto)));
    }

    public BookDetailsDto getBookDetailsById (int id){
        BookDetails bookDetails= bookDetailsRepository.findByBookDetailsId(id);
        if (bookDetails == null) {
            throw new BookDetailsNotFoundException(Constants.NO_BOOK_DETAILS_FOUND);
        }
        return bookDetailsMapper.mapToDto(bookDetails);

    }
}

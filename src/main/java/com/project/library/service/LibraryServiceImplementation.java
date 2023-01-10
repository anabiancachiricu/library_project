package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.AuthorDto;
import com.project.library.dto.BookDetailsDto;
import com.project.library.dto.LibraryDto;
import com.project.library.entity.BookDetails;
import com.project.library.entity.Library;
import com.project.library.exception.AuthorNotFoundException;
import com.project.library.exception.BookDetailsNotFoundException;
import com.project.library.mapper.LibraryMapper;
import com.project.library.mapper.ReviewMapper;
import com.project.library.repository.LibraryRepository;
import com.project.library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImplementation implements GenericService<LibraryDto>{
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private LibraryMapper libraryMapper;


    @Override
    public LibraryDto add(LibraryDto libraryDto) {
        return libraryMapper.mapToDto(libraryRepository.save(libraryMapper.mapToClass(libraryDto)));
    }

    public LibraryDto getLibraryByLibraryId (int id){
        Library library= libraryRepository.findLibrariesByLibraryId(id);
        if (library == null) {
            throw new BookDetailsNotFoundException(Constants.NO_BOOK_DETAILS_FOUND);
        }
        return libraryMapper.mapToDto(library);

    }

    public List<LibraryDto> getAll() {
        List<LibraryDto> libraryDtos = libraryRepository.findAll().stream()
                .map(library-> libraryMapper.mapToDto(library)).collect(Collectors.toList());
        if (libraryDtos.isEmpty()) {
            throw new AuthorNotFoundException(Constants.NO_AUTHOR_FOUND);
        }
        return libraryDtos;
    }
}

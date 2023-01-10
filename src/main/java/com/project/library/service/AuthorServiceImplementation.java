package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.AuthorDto;
import com.project.library.entity.Author;
import com.project.library.mapper.AuthorMapper;
import com.project.library.exception.AuthorNotFoundException;
import com.project.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImplementation implements GenericService<AuthorDto> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public AuthorDto add(AuthorDto authorDto) {
        return authorMapper.mapToDto(authorRepository.save(authorMapper.mapToClass(authorDto)));
    }

    public List<AuthorDto> getByLastName(String lastName) {
        List<AuthorDto> authorDtos = authorRepository.findByLastName(lastName).stream()
                .map(author -> authorMapper.mapToDto(author)).collect(Collectors.toList());
        if (authorDtos.isEmpty()) {
            throw new AuthorNotFoundException(Constants.NO_AUTHOR_FOUND);
        }
        return authorDtos;
    }

    public List<AuthorDto> getAll() {
        List<AuthorDto> authorDtos = authorRepository.findAll().stream()
                .map(author -> authorMapper.mapToDto(author)).collect(Collectors.toList());
        if (authorDtos.isEmpty()) {
            throw new AuthorNotFoundException(Constants.NO_AUTHOR_FOUND);
        }
        return authorDtos;
    }

    public AuthorDto getAuthorById(int id){
        Author author= authorRepository.findByAuthorId(id);
        if (author == null) {
            throw new AuthorNotFoundException(Constants.NO_AUTHOR_WITH_SELECTED_ID);
        }
        return authorMapper.mapToDto(author);

    }

}

package com.project.library.mapper;

import com.project.library.dto.AuthorDto;
import com.project.library.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements GenericMapper<Author, AuthorDto> {

    public Author mapToClass(AuthorDto authorDto) {
        return Author.builder()
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .books(authorDto.getBooks())
                .build();
    }

    public AuthorDto mapToDto(Author author) {
        return AuthorDto.builder()
                .authorId(author.getAuthorId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
    }
}

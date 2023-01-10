package com.project.library.mapper;

import com.project.library.dto.AddressDto;
import com.project.library.dto.AuthorDto;
import com.project.library.entity.Address;
import com.project.library.entity.Author;
import com.project.library.utils.AddressMocks;
import com.project.library.utils.AuthorMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AuthorMapperTest {
    @InjectMocks
    AuthorMapper authorMapper;

    @Test
    public void mapToClassTest(){
        //GIVEN
        AuthorDto authorDto = AuthorMocks.mockAuthorDto();

        //WHEN
        Author author1 = authorMapper.mapToClass(authorDto);

        //THEN
        assertTrue(author1.getFirstName().equals(authorDto.getFirstName()));
        assertTrue(author1.getLastName().equals(authorDto.getLastName()));

    }

    @Test
    public void mapToDtoTest(){
        //GIVEN
        Author author= AuthorMocks.mockAuthor();

        //WHEN
        AuthorDto authorDto = authorMapper.mapToDto(author);

        //THEN
        assertTrue(authorDto.getFirstName().equals(author.getFirstName()));
        assertTrue(authorDto.getLastName().equals(author.getLastName()));

    }
}

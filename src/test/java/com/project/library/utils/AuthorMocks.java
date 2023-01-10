package com.project.library.utils;

import com.project.library.dto.AddressDto;
import com.project.library.dto.AuthorDto;
import com.project.library.entity.Address;
import com.project.library.entity.Author;

public class AuthorMocks {

    public static Author mockAuthor()
    {
        return Author.builder()
                .authorId(1)
                .firstName("Anna")
                .lastName("Todd")
                .build();
    }

    public static AuthorDto mockAuthorDto()
    {
        return AuthorDto.builder()
                .authorId(1)
                .firstName("Anna")
                .lastName("Todd")
                .build();
    }

}

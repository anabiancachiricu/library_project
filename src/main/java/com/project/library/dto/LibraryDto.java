package com.project.library.dto;

import com.project.library.entity.Address;
import com.project.library.entity.Book;
import com.project.library.validator.OnlyLetters;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryDto {

    private int libraryId;

    @NotNull
    @NotEmpty
    @NotBlank
    @OnlyLetters
    private String name;

    @NotNull
    private int addressId;


    private List<Book> bookList;
}

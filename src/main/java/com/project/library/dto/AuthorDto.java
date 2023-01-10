package com.project.library.dto;
import com.project.library.constants.Constants;
import com.project.library.entity.Book;
import com.project.library.validator.OnlyLetters;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private int  authorId;

    @NotNull(message = Constants.FIRST_NAME_NOT_NULL_VALIDATION)
    @OnlyLetters
    private String firstName;

    @NotNull(message = Constants.LAST_NAME_NOT_NULL_VALIDATION)
    @OnlyLetters
    private String lastName;

    //@JsonIgnore
    private List<Book> books;

}

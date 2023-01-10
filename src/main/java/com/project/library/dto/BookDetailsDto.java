package com.project.library.dto;

import com.project.library.constants.Constants;
import com.project.library.validator.OnlyNumbers;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsDto {
    private int bookDetailsId;

    @NotNull(message = Constants.BOOK_DESCRIPTION_NOT_NULL_VALIDATION)
    @NotEmpty
    @NotBlank
    private String description;


    private int publishingYear;

    @NotNull(message = Constants.NO_OF_PAGES_NOT_NULL_VALIDATION)
    public int noOfPages;
}

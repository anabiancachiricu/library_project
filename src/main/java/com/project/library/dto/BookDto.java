package com.project.library.dto;

import com.project.library.constants.Constants;
import com.project.library.entity.Author;
import com.project.library.entity.BookDetails;
import com.project.library.entity.Library;
import com.project.library.entity.Review;
import com.project.library.validator.OnlyLetters;
import com.project.library.validator.OnlyNumbers;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private int bookId;

    @NotNull(message = Constants.TITLE_NOT_NULL_VALIDATION)
    @OnlyLetters
    @NotEmpty
    @NotBlank
    private String title;

    @NotNull
    @Min(value = 0, message = Constants.QUANITITY_GREATER_THAN_0)
    private int quantity;

    @NotNull
    @Min(value = 0, message = Constants.QUANITITY_GREATER_THAN_0)
    private int authorId;

    @NotNull
    @Min(value = 0, message = Constants.QUANITITY_GREATER_THAN_0)
    private int bookDetailsId;



}

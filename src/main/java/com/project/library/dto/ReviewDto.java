package com.project.library.dto;

import com.project.library.constants.Constants;
import com.project.library.entity.Book;
import com.project.library.entity.Client;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private int reviewId;

    @NotNull
    @NotBlank
    @NotEmpty
    private String reviewText;

    @NotNull
    @Min(value = 1, message = Constants.MIN_GRADE)
    @Max(value = 10, message = Constants.MAX_GRADE)
    private Float reviewGrade;

    @NotNull
    private int bookId;

    @NotNull
    private int clientId;
}

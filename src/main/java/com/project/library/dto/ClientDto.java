package com.project.library.dto;

import com.project.library.entity.BorrowHistory;
import com.project.library.entity.Review;
import com.project.library.validator.OnlyLetters;
import com.project.library.validator.OnlyNumbers;
import com.project.library.validator.PhoneNumber;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.websocket.OnOpen;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    private int clientId;
    @NotNull
    @NotEmpty
    @NotBlank
    @OnlyLetters
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @OnlyLetters
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @OnlyNumbers
    @PhoneNumber
    private String phone;

}

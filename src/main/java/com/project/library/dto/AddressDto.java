package com.project.library.dto;

import com.project.library.constants.Constants;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private int addressId;

    @NotNull(message = Constants.CITY_NOT_NULL_VALIDATION)
    @NotBlank
    @NotEmpty
    private String city;

    @NotNull(message = Constants.STREET_NOT_NULL_VALIDATION)
    @NotBlank
    @NotEmpty
    private String street;

    @NotNull(message = Constants.NUMBER_NOT_NULL_VALIDATION)
    @NotBlank
    @NotEmpty
    private int number;

}

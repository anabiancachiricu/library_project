package com.project.library.utils;

import com.project.library.dto.AddressDto;
import com.project.library.entity.Address;

public class AddressMocks {

    public static Address mockAddress()
    {
        return Address.builder()
                .addressId(1)
                .city("Ploiesti")
                .street("Lupeni")
                .number(151)
                .build();
    }

    public static AddressDto mockAddressDto()
    {
        return AddressDto.builder()
                .addressId(1)
                .city("Ploiesti")
                .street("Lupeni")
                .number(151)
                .build();
    }

}

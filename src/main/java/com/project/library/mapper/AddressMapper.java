package com.project.library.mapper;

import com.project.library.dto.AddressDto;
import com.project.library.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements GenericMapper<Address, AddressDto>{

    public Address mapToClass(AddressDto addressDto) {
        return Address.builder()
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .number(addressDto.getNumber())
                        .build();
    }

    public AddressDto mapToDto(Address address) {
        return AddressDto.builder()
                .addressId(address.getAddressId())
                .city(address.getCity())
                .street(address.getStreet())
                .number(address.getNumber())
                .build();
    }


}

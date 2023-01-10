package com.project.library.mapper;

import com.project.library.dto.AddressDto;
import com.project.library.entity.Address;
import com.project.library.utils.AddressMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AddressMapperTest {

    @InjectMocks
    AddressMapper addressMapper;

    @Test
    public void mapToClassTest(){
        //GIVEN
        AddressDto addressDto = AddressMocks.mockAddressDto();

        //WHEN
        Address adress1 = addressMapper.mapToClass(addressDto);

        //THEN
        assertTrue(adress1.getCity().equals(addressDto.getCity()));
        assertTrue(adress1.getStreet().equals(addressDto.getStreet()));
        assertTrue(adress1.getNumber()==(addressDto.getNumber()));
    }

    @Test
    public void mapToDtoTest(){
        //GIVEN
        Address address = AddressMocks.mockAddress();

        //WHEN
        AddressDto addressDto = addressMapper.mapToDto(address);

        //THEN
        assertTrue(addressDto.getCity().equals(address.getCity()));
        assertTrue(addressDto.getStreet().equals(address.getStreet()));
        assertTrue(addressDto.getNumber()==(address.getNumber()));
    }

}

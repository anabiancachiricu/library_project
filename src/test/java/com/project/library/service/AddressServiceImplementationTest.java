package com.project.library.service;

import com.project.library.dto.AddressDto;
import com.project.library.entity.Address;
import com.project.library.mapper.AddressMapper;
import com.project.library.repository.AddressRepository;
import com.project.library.utils.AddressMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplementationTest {

    @InjectMocks
    private AddressServiceImplementation addressServiceImplementation;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AddressMapper addressMapper;

    @Test
    public void testAddAddress(){
        //GIVEN
        Address address = AddressMocks.mockAddress();
        AddressDto addressDto = AddressMocks.mockAddressDto();

        //WHEN
        when(addressRepository.save(address)).thenReturn(address);
        when(addressMapper.mapToClass(addressDto)).thenReturn(address);
        when(addressMapper.mapToDto(address)).thenReturn(addressDto);

        AddressDto result = addressServiceImplementation.add(addressDto);

        //THEN
        assertTrue(result.getCity().equals(addressDto.getCity()));
        assertNotNull(result.getAddressId());
        assertEquals(result.getStreet(), addressDto.getStreet());
        assertEquals(result.getNumber(), addressDto.getNumber());
    }


}

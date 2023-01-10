package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.AddressDto;
import com.project.library.exception.AddressNotFoundException;
import com.project.library.mapper.AddressMapper;
import com.project.library.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImplementation implements GenericService<AddressDto> {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    public List<AddressDto> getByCity(String city) {
        List<AddressDto> addressDtos = addressRepository.findByCity(city).stream()
                .map(address -> addressMapper.mapToDto(address)).collect(Collectors.toList());
        if (addressDtos.isEmpty()) {
            throw new AddressNotFoundException(Constants.NO_ADDRESS_FOUND);
        }
        return addressDtos;
    }

    public AddressDto add(AddressDto addressDto) {
        return addressMapper.mapToDto(addressRepository.save(addressMapper.mapToClass(addressDto)));
    }
}

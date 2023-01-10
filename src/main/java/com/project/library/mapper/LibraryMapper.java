package com.project.library.mapper;

import com.project.library.dto.LibraryDto;
import com.project.library.entity.Address;
import com.project.library.entity.Library;
import com.project.library.repository.AddressRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class LibraryMapper implements GenericMapper<Library, LibraryDto> {
    private final AddressRepository addressRepository;

    public LibraryMapper(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Library mapToClass(LibraryDto libraryDto) {
        return Library.builder()
                .address(addressRepository.findByAddressId(libraryDto.getAddressId()))
                .name(libraryDto.getName())
                .bookList(libraryDto.getBookList())
                .build();
    }

    @Override
    public LibraryDto mapToDto(Library library) {
        return LibraryDto.builder()
                .libraryId(library.getLibraryId())
                .addressId(library.getAddress().getAddressId())
                .name(library.getName())
                .bookList(library.getBookList())
                .build();
    }
}

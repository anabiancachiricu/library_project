package com.project.library.mapper;

import com.project.library.dto.LibraryDto;
import com.project.library.entity.Library;

public class LibraryMapper implements GenericMapper<Library, LibraryDto> {

    @Override
    public Library mapToClass(LibraryDto libraryDto) {
        return Library.builder()
                .address(libraryDto.getAddress())
                .name(libraryDto.getName())
                .bookList(libraryDto.getBookList())
                .build();
    }

    @Override
    public LibraryDto mapToDto(Library library) {
        return LibraryDto.builder()
                .libraryId(library.getLibraryId())
                .address(library.getAddress())
                .name(library.getName())
                .bookList(library.getBookList())
                .build();
    }
}

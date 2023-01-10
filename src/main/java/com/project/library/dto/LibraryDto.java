package com.project.library.dto;

import com.project.library.entity.Address;
import com.project.library.entity.Book;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryDto {

    private int libraryId;
    private String name;
    private Address address;
    private List<Book> bookList;
}

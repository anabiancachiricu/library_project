package com.project.library.controller;

import com.project.library.dto.BookDetailsDto;
import com.project.library.dto.BookDto;
import com.project.library.entity.BookDetails;
import com.project.library.service.BookDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookDetails")
public class BookDetailsController {

    @Autowired
    private BookDetailsServiceImplementation bookDetailsServiceImplementation;

    @PostMapping("/add")
    public ResponseEntity<BookDetailsDto> addBookDetails(@RequestBody @Valid BookDetailsDto bookDetailsDto) {
        return ResponseEntity.ok(bookDetailsServiceImplementation.add(bookDetailsDto));
    }



}

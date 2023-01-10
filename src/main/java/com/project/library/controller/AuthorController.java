package com.project.library.controller;

import com.project.library.dto.AddressDto;
import com.project.library.dto.AuthorDto;
import com.project.library.service.AddressServiceImplementation;
import com.project.library.service.AuthorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorServiceImplementation authorServiceImplementation;


    @PostMapping("/add")
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return ResponseEntity.ok(authorServiceImplementation.add(authorDto));
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<List<AuthorDto>> getAuthorByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(authorServiceImplementation.getByLastName(lastName));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        return ResponseEntity.ok(authorServiceImplementation.getAll());
    }



}
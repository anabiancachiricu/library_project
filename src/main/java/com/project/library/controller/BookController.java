package com.project.library.controller;

import com.project.library.dto.AuthorDto;
import com.project.library.dto.BookDto;
import com.project.library.service.AuthorServiceImplementation;
import com.project.library.service.BookServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImplementation bookServiceImplementation;


    @PostMapping("/add")
    public ResponseEntity<BookDto> addBook(@RequestBody @Valid BookDto bookDto) {
        return ResponseEntity.ok(bookServiceImplementation.add(bookDto));
    }

    @GetMapping("/author/{lastName}")
    public ResponseEntity<List<BookDto>> getBookByAuthorLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(bookServiceImplementation.getBookByAuthor_LastName(lastName));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDto>> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookServiceImplementation.getBookByTitle(title));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookServiceImplementation.getAll());
    }

}

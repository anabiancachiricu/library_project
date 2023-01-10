package com.project.library.controller;

import com.project.library.dto.BookDto;
import com.project.library.dto.LibraryDto;
import com.project.library.dto.ReviewDto;
import com.project.library.service.LibraryServiceImplementation;
import com.project.library.service.ReviewServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    @Autowired
    private LibraryServiceImplementation libraryServiceImplementation;

    @PostMapping("/add")
    public ResponseEntity<LibraryDto> addLibrary(@RequestBody @Valid LibraryDto libraryDto) {
        return ResponseEntity.ok(libraryServiceImplementation.add(libraryDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LibraryDto>> getAllLibraries() {
        return ResponseEntity.ok(libraryServiceImplementation.getAll());
    }


}

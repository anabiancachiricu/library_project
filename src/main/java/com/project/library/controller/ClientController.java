package com.project.library.controller;

import com.project.library.dto.BookDetailsDto;
import com.project.library.dto.ClientDto;
import com.project.library.service.ClientServiceImplementation;
import com.project.library.service.ReviewServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImplementation clientServiceImplementation;

    @PostMapping("/add")
    public ResponseEntity<ClientDto> addClient(@RequestBody @Valid ClientDto clientDto) {
        return ResponseEntity.ok(clientServiceImplementation.add(clientDto));
    }



}

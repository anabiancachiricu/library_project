package com.project.library.controller;

import com.project.library.dto.AddressDto;
import com.project.library.service.AddressServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressServiceImplementation addressServiceImplementation;


    @PostMapping("/add")
    public ResponseEntity<AddressDto> addAddress(@RequestBody @Valid AddressDto addressDto){
        return ResponseEntity.ok(addressServiceImplementation.add(addressDto));
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<AddressDto>> getAddressByCity(@PathVariable String city){
        return ResponseEntity.ok(addressServiceImplementation.getByCity(city));
    }



}

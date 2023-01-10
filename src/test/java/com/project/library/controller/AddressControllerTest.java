package com.project.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.library.dto.AddressDto;
import com.project.library.service.AddressServiceImplementation;
import com.project.library.utils.AddressMocks;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AddressController.class)
public class AddressControllerTest {

    @MockBean
    private AddressServiceImplementation addressServiceImplementation;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testAddAddress() throws Exception {
        AddressDto addressDto = AddressMocks.mockAddressDto();
        when(addressServiceImplementation.add(any())).thenReturn(addressDto);
        String addressDtoBody = mapper.writeValueAsString(addressDto);
        MvcResult result = mockMvc.perform(post("/addresses/add")
                        .content(addressDtoBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.city").value("Ploiesti"))
                .andExpect(jsonPath("$.street").value("Lupeni"))
                .andExpect(jsonPath("$.number").value("151"))
                .andReturn();
        assertEquals(result.getResponse().getContentAsString(), addressDtoBody);
    }

    @Test
    public void testGetAddressByCity() throws Exception {
        AddressDto addressDto = AddressMocks.mockAddressDto();
        when(addressServiceImplementation.getByCity("Ploiesti")).thenReturn(Arrays.asList(addressDto));
        MvcResult result = mockMvc.perform(get("/addresses/{city}", "Ploiesti")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].street").value(addressDto.getStreet()))
                .andReturn();
        assertEquals(result.getResponse().getContentAsString(), mapper.writeValueAsString(Arrays.asList(addressDto)));
    }

}

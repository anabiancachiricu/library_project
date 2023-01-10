package com.project.library.mapper;

import com.project.library.dto.ClientDto;
import com.project.library.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements GenericMapper<Client, ClientDto> {


    @Override
    public Client mapToClass(ClientDto clientDto) {
        return Client.builder()
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .phone(clientDto.getPhone())
                .email(clientDto.getEmail())
        .build();
    }

    @Override
    public ClientDto mapToDto(Client client) {
        return ClientDto.builder()
                .clientId(client.getClientId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phone(client.getPhone())
                .email(client.getEmail())
                .build();
    }
}

package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.ClientDto;
import com.project.library.entity.Client;
import com.project.library.exception.ClientNotFoundException;
import com.project.library.mapper.ClientMapper;
import com.project.library.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImplementation implements GenericService<ClientDto> {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public ClientDto add(ClientDto clientDto) {
        return clientMapper.mapToDto(clientRepository.save(clientMapper.mapToClass(clientDto)));
    }

    public ClientDto getClientById (int id){
        Client client= clientRepository.findClientByClientId(id);
        if (client== null) {
            throw new ClientNotFoundException(Constants.NO_CLIENT_FOUND);
        }
        return clientMapper.mapToDto(client);

    }


}

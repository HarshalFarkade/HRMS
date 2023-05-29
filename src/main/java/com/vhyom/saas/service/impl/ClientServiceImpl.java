package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.ClientDto;
import com.vhyom.saas.entity.VseClient;
import com.vhyom.saas.repository.ClientRepository;
import com.vhyom.saas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public String createClient(VseClient vseClient, MultipartFile file, String path) throws IOException {

        this.clientRepository.createClient(vseClient.getClientId(), vseClient.getCompany(), vseClient.getShortCode(), vseClient.getWebsiteUrl(),
                path, vseClient.getGstin(), vseClient.getPan(), vseClient.getFirstName(), vseClient.getLastName(), vseClient.getEmailId(),
                vseClient.getMobileNumber(), vseClient.getPhoneNumber(), vseClient.getCreatedBy(), true);
        return "Client Created Successfully";
    }

    @Override
    public List<ClientDto> getAllClient() {
        return clientRepository.getAllClient();
    }

    @Override
    public ClientDto getClientByUuid(String uuid) {
        ClientDto client =clientRepository.getClientByUuid(uuid);
        if(client==null){
            System.out.println("Client not found");
        }
        return client;
    }

    @Override
    public String deleteClientByUuid(String uuid, VseClient vseClient) {
        this.clientRepository.deleteClientByUuid(vseClient.getLastModifiedBy(), LocalDateTime.now(),false,uuid);
        return "Client Delete Successfully";
    }

    @Override
    public String updateClientByUuid(String uuid, VseClient vseClient, String path, MultipartFile file) throws IOException {
        this.clientRepository.updateClientByUuid(vseClient.getCompany(), vseClient.getShortCode(), vseClient.getWebsiteUrl(), path, vseClient.getFirstName(), vseClient.getLastName(), vseClient.getEmailId(), vseClient.getMobileNumber(), vseClient.getPhoneNumber(), vseClient.getLastModifiedBy(), LocalDateTime.now(),uuid);
        return "Client Update Successfully";
    }
}

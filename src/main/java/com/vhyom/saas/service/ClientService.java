package com.vhyom.saas.service;

import com.vhyom.saas.dto.ClientDto;
import com.vhyom.saas.entity.VseClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ClientService {

    String createClient(VseClient vseClient, MultipartFile file,String path)throws IOException;

    List<ClientDto> getAllClient();

//    ClientDto getClientByUuid (String uuid);
//
//    String deleteClientByUuid(String uuid,VseClient vseClient);
//
//    String updateClientByUuid(String uuid,VseClient vseClient,String path,MultipartFile file)throws  IOException ;
}

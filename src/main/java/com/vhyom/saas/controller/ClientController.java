package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.dto.ClientDto;
import com.vhyom.saas.entity.VseClient;
import com.vhyom.saas.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Client")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Value("${custom-properites.clientlogo.directory}")
    private String path;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @PostMapping("/create/client")
    public String createClient( VseClient vseClient, @RequestPart("client")String client, @RequestPart("logo")MultipartFile file) throws IOException{
        LOGGER.info(" ClientController | createClient is started"+ file.getOriginalFilename());

        if (file.isEmpty()){
            path=null;
            vseClient= new ObjectMapper().readValue(client, VseClient.class);
            this.clientService.createClient(vseClient, file, path);
            return "Client Created Successfully";
        }else {
            vseClient = new ObjectMapper().readValue(client, VseClient.class);
            String fileName = file.getOriginalFilename();
            if (!fileName.equalsIgnoreCase("")) {
                fileName = getCurrentTime() + "_" + fileName;
            }
            String filePath = path + File.separator + fileName;
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            Files.copy(file.getInputStream(), Paths.get(filePath));
            vseClient.setLogo(fileName);
            this.clientService.createClient(vseClient, file, path);
            return "Client Created Successfully";
        }
    }

    @GetMapping("/AllClient")
    public List<ClientDto> getAllClient(){
        LOGGER.info(" ClientController | getClient is started");
        return clientService.getAllClient();
    }

    @GetMapping("/getClient/{uuid}")
    public ClientDto getClientByUuid(@PathVariable String uuid){
        LOGGER.info(" ClientController | getClient is started");
        return clientService.getClientByUuid(uuid);

    }

    @PutMapping("/deleteClient/{uuid}")
    public String deleteClientByUuid(@PathVariable String uuid,@RequestBody VseClient vseClient){
        LOGGER.info(" ClientController | DeleteClient is started");
        return clientService.deleteClientByUuid(uuid, vseClient);
    }

    @PutMapping("/updateClient/{uuid}")
    public String updateClientByUuid( VseClient  vseClient,@PathVariable String uuid,@RequestPart("client")String client,@RequestPart ("logo")MultipartFile file) throws IOException {
        LOGGER.info(" ClientController | UpdateClient is started" + file.getOriginalFilename());

        if (file.isEmpty()) {
            path = null;
            vseClient = new ObjectMapper().readValue(client, VseClient.class);
            this.clientService.updateClientByUuid(uuid,vseClient, path, file);
            return "Client Created Successfully";
        } else {

            vseClient = new ObjectMapper().readValue(client, VseClient.class);
            String fileName = file.getOriginalFilename();
            if (!fileName.equalsIgnoreCase("")) {
                fileName = getCurrentTime() + "_" + fileName;
            }
            String filePath = path + File.separator + fileName;
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            Files.copy(file.getInputStream(), Paths.get(filePath));
            vseClient.setLogo(fileName);
            this.clientService.updateClientByUuid(uuid,vseClient, path, file);
            return "Client Update Successfully";
        }
    }


    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}

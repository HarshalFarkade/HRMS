package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vhyom.saas.dto.VssCompanydto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.service.CompanyService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/company")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Value("${custom-properites.logo.directory}")
    private String path;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/company")
    public String creatCompany(@Valid VssCompany vssCompany,@RequestPart("name")String name, @RequestPart ("company") String company, @RequestPart("logo") MultipartFile file) throws IOException {
        LOGGER.info("CompanyController | createCompany is started" + file.getOriginalFilename());
        //Convert the String to Json using ObjectMapper

        if (file.isEmpty()){
            path=null;
            vssCompany= new ObjectMapper().readValue(company, VssCompany.class);
            this.companyService.createCompany(name,vssCompany, file, path);
            return "Company Created Successfully";
        }else {

            vssCompany = new ObjectMapper().readValue(company, VssCompany.class);
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
            vssCompany.setLogo(fileName);
            this.companyService.createCompany(name, vssCompany, file, path);
            return "Company Created Successfully";

        }
    }
    @GetMapping("/allCompany") /* This API will give all company*/
    public List<VssCompanydto>  getAllCompany() {
        LOGGER.info(" CompanyController | allCompany is started");
        return  companyService.getAllcompany();
    }

    @GetMapping("/getCompanyByuuid/{uuid}") /*This API Will give company by uuid*/
    public VssCompanydto getCompanyByUuid(@PathVariable String uuid){
        LOGGER.info(" CompanyController | allCompany is started");
        return companyService.getCompanyByUuid(uuid);
    }

    @PutMapping("/deleteCompanyByUuid/{uuid}")/*This api will delete the company*/
    public String deleteCompanyByUuid(@PathVariable String uuid, @RequestBody VssCompany vssCompany){
        LOGGER.info(" CompanyController | allCompany is started");
        return companyService.deletCompanyByUuid(uuid, vssCompany);
    }

    @PutMapping("/update/{uuid}")/* This API will Update the Company*/
    public String updateCompanyByUuid(@Valid VssCompany vssCompany,@RequestPart("name")String name,@PathVariable String uuid,@RequestPart("company") String company,@RequestPart("logo") MultipartFile file) throws IOException {
        LOGGER.info(" CompanyController | allCompany is started"+ file.getOriginalFilename());

        if (file.isEmpty()){
            path=null;
            vssCompany= new ObjectMapper().readValue(company, VssCompany.class);
            this.companyService.updateCompanyByUuid(name,uuid,vssCompany,path,file);
            return "Company Updated Successfully";
        } else  {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            vssCompany = new ObjectMapper().readValue(company, VssCompany.class);
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
            this.companyService.updateCompanyByUuid(name,uuid, vssCompany,path,file);
            return "Company Updated Successfully";

        }

    }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}

package com.vhyom.saas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Value("${custom-properites.logo.directory}")
    private String path;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/company")
    public String creatCompany(@RequestPart("company") String company, @RequestParam("superAdminId") Integer superAdminId, @RequestPart("logo") MultipartFile file) throws JsonProcessingException {
        LOGGER.info("CompanyController | createCompany is started" + file.getOriginalFilename());
        //Convert the String to Json using ObjectMapper
        VssCompany vssCompany = new ObjectMapper().readValue(company, VssCompany.class);
        this.companyService.createCompany(vssCompany, superAdminId, file, path);
        return "Company registered Successfully";
    }

    @GetMapping("/allCompany") /* This API will give all company*/
    public ResponseEntity<List<Object[]>> getAllCompany() {
        LOGGER.info(" CompanyController | allCompany is started");
        return new ResponseEntity<>(companyService.getAllcompany(), HttpStatus.OK);
    }
    @GetMapping("/getCompanyByuuid/{uuid}") /*This API Will give company by uuid*/
    public ResponseEntity<List<Object[]>>getCompanyByUuid(@PathVariable String uuid){
        LOGGER.info(" CompanyController | allCompany is started");
        return new ResponseEntity<>(companyService.getCompanyByUuid(uuid),HttpStatus.OK);
    }

    @PutMapping("/deleteCompanyByUuid/{uuid}")/*This api will delete the company*/
    public String deleteCompanyByUuid(@PathVariable String uuid, @RequestBody VssCompany vssCompany){
        LOGGER.info(" CompanyController | allCompany is started");
        return companyService.deletCompanyByUuid(uuid, vssCompany);
    }

    @PutMapping("/update/{uuid}")/* This API will Update the Company*/
    public String updateCompanyByUuid(@PathVariable String uuid,@RequestPart("company") String company,@RequestPart("logo") MultipartFile file) throws IOException {
        LOGGER.info(" CompanyController | allCompany is started"+ file.getOriginalFilename());
        VssCompany vssCompany = new ObjectMapper().readValue(company, VssCompany.class);
        return companyService.updateCompanyByUuid(uuid, vssCompany,path,file);
    }
}

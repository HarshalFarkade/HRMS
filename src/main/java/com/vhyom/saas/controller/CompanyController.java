package com.vhyom.saas.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.Service.CompanyService;
import com.vhyom.saas.entity.VssCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}

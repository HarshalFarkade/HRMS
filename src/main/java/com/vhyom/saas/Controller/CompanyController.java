package com.vhyom.saas.Controller;

import com.vhyom.saas.ServiceImp.CompanyServiceImp;
import com.vhyom.saas.entity.VssCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    private CompanyServiceImp companyServiceImp;

    @Value("${custom-properites.logo.directory}")
    private String path;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/company/create")
    public  String createCompany( @RequestBody VssCompany vssCompany){
        LOGGER.info("CompanyController | createCompany is started");
        return companyServiceImp.createCompany(vssCompany);
    }

}

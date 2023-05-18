package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.VssCompanydto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.repository.CompanyRepository;
import com.vhyom.saas.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String createCompany(String name,VssCompany vssCompany, MultipartFile file, String path) throws IOException {
            this.companyRepository.createCompany(name, vssCompany.getWebsiteUrl(),path, vssCompany.getFirstName(), vssCompany.getLastName(), vssCompany.getEmailId(), vssCompany.getPhoneNumber(), vssCompany.getCreatedBy());
            return "Company Created Successfully";
    }

    @Override
    public List<VssCompanydto> getAllcompany() {
        return companyRepository.findAllcompany();

    }

    @Override
    public VssCompanydto getCompanyByUuid(String uuid) {
        VssCompanydto available =  companyRepository.getCompanyByUuid(uuid);
        if(available==null){
            System.out.print("Company Not Found");
        }
        return  available;
    }

    @Override
    public String deletCompanyByUuid(String uuid, VssCompany vssCompany) {
        this.companyRepository.deleteCompanyByUuid(vssCompany.getLastModifiedBy(), LocalDateTime.now(),false,uuid);
        return " Company Delete Successfully";
    }

    @Override
    public String updateCompanyByUuid(String name,String uuid, VssCompany vssCompany, String path, MultipartFile file) throws IOException {
        this.companyRepository.updateCompanyByUuid( name,vssCompany.getWebsiteUrl(), path, vssCompany.getFirstName(), vssCompany.getLastName(), vssCompany.getPhoneNumber(), LocalDateTime.now(), vssCompany.getLastModifiedBy(),uuid);
        return " Update Successfully";
    }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}

package com.vhyom.saas.ServiceImp;

import com.vhyom.saas.Repository.CompanyRepository;
import com.vhyom.saas.Service.CompanyService;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSuperAdmin;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class CompanyServiceImp implements CompanyService {
    Date date = new Date();
    @Autowired
    private CompanyRepository companyRepository ;
    @Override
    public String createCompany(VssCompany vssCompany) {

        try {

            VssCompany existingCompany = companyRepository.findByName(vssCompany.getName());
            if (existingCompany != null) {
                throw new RuntimeException("A company with this name already exist");
            }
            this.companyRepository.createCompany(vssCompany.getName(), vssCompany.getWebsiteUrl(), vssCompany.getLogo(), vssCompany.getFirstName(), vssCompany.getLastName(), vssCompany.getPhoneNumber(),vssCompany.getCreatedOn(),vssCompany.getCreatedBy());
            this.companyRepository.save(vssCompany);
            return "Company registered successfully";

        } catch (NonUniqueResultException e) {
            return "Multiple Companies found";
        } catch (Exception e){
            System.out.println("Error" + e.toString());
            return e.toString();
        }
    }
}

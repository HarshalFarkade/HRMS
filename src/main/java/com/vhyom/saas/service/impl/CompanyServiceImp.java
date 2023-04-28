package com.vhyom.saas.service.impl;

import com.vhyom.saas.entity.VssCompany;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.vhyom.saas.repository.CompanyRepository;
import com.vhyom.saas.service.CompanyService;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyServiceImp implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String createCompany(VssCompany vssCompany, Integer superAdminId, MultipartFile file, String path) {

        try {
            String name = vssCompany.getName();
            String emailId = vssCompany.getEmailId();
            if (name == null || name.trim().isEmpty()) {
                throw new RuntimeException("Name is required.");
            } else if (name.length() > 50) {

                throw new RuntimeException("Name must be 50 characters or less.");
            }
            if (emailId == null || emailId.trim().isEmpty()) {
                throw new RuntimeException("Email is required.");

            } else if (!emailId.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {

                throw new RuntimeException("Invalid email format.");

            }
            VssCompany existingCompany = companyRepository.findByName(vssCompany.getName());
            if (existingCompany != null) {
                throw new RuntimeException("A company with this name already exist");
            }

            vssCompany.setWebsiteUrl(vssCompany.getWebsiteUrl());

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

            vssCompany.setFirstName(vssCompany.getFirstName());
            vssCompany.setLastName(vssCompany.getLastName());
            vssCompany.setPhoneNumber(vssCompany.getPhoneNumber());
            vssCompany.setActive(true);
            vssCompany.setCreatedBy(superAdminId);
            vssCompany.setCreatedOn(LocalDateTime.now());

            UUID uuid = UUID.randomUUID();
            vssCompany.setUuid(uuid.toString());
            this.companyRepository.save(vssCompany);
            return "Company registered successfully";

        } catch (NonUniqueResultException e) {
            return "Multiple Companies found";
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return e.toString();
        }
    }

    @Override
    public List<Object[]> getAllcompany() {
        return companyRepository.findAllcompany(Boolean.TRUE);
    }

    @Override
    public List<Object[]> getCompanyByUuid(String uuid) {
        List<Object[]>available=companyRepository.getCompanyByUuid(uuid);
        if(available==null){
            System.out.print("Company Not Found");
        }
        return available;
    }

    @Override
    public String deletCompanyByUuid(String uuid, VssCompany vssCompany) {
        this.companyRepository.deleteCompanyByUuid(vssCompany.getLastModifiedBy(), LocalDateTime.now(),false,uuid);
        return " Company Delete Successfully";
    }

    @Override
    public String updateCompanyByUuid(String uuid, VssCompany vssCompany, String path, MultipartFile file) throws IOException {
        this.companyRepository.updateCompanyByUuid( vssCompany.getName(),vssCompany.getWebsiteUrl(), path, vssCompany.getFirstName(), vssCompany.getLastName(), vssCompany.getPhoneNumber(), LocalDateTime.now(), vssCompany.getLastModifiedBy(),uuid);

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
        return " Update Successfully";
    }


    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}

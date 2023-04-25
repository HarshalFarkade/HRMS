package com.vhyom.saas.service.impl;

import com.vhyom.saas.Repository.CompanyRepository;
import com.vhyom.saas.Service.CompanyService;
import com.vhyom.saas.entity.VssCompany;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyServiceImp implements CompanyService {
    Date date = new Date();
    @Autowired
    private CompanyRepository companyRepository ;
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

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}

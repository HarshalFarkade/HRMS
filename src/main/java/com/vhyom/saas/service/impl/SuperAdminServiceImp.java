package com.vhyom.saas.service.impl;

import com.vhyom.saas.entity.VssSuperAdmin;
import com.vhyom.saas.repository.SuperAdminRepository;
import com.vhyom.saas.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SuperAdminServiceImp implements SuperAdminService {
    @Autowired
    private SuperAdminRepository superAdminRepository;
    @Override
    public String createSuperAdmin(VssSuperAdmin vssSuperAdmin, MultipartFile file, String path) throws IOException {
        vssSuperAdmin.setEmailId(vssSuperAdmin.getEmailId());
        vssSuperAdmin.setPassword(vssSuperAdmin.getPassword());
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
        vssSuperAdmin.setFirstName(vssSuperAdmin.getFirstName());
        vssSuperAdmin.setLastName(vssSuperAdmin.getLastName());
        vssSuperAdmin.setMobileNumber(vssSuperAdmin.getMobileNumber());
        vssSuperAdmin.setPhoneNumber(vssSuperAdmin.getPhoneNumber());
        vssSuperAdmin.setActive(true);
        vssSuperAdmin.setCreatedOn(LocalDateTime.now());
        vssSuperAdmin.setCreatedBy(vssSuperAdmin.getCreatedBy());
        UUID uuid = UUID.randomUUID();
        vssSuperAdmin.setUuid(uuid.toString());
        this.superAdminRepository.save(vssSuperAdmin);
        return "Create Successfully";
    }

   // @Override
  //  public List<Object[]> getAllsuperAdminBySortedFirstNameAsc(String firstName) {
   //     return superAdminRepository.getAllsuperAdminBySortedFirstNameAsc(Sort.by(Sort.Direction.ASC,firstName));
   // }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}


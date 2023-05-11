package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.VssSuperAdmindto;
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
        vssSuperAdmin.setProfilePhoto(filePath);
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

    @Override
   public List<VssSuperAdmindto> getAllsuperAdminBySortedFirstNameAsc(String firstName) {
        return superAdminRepository.getAllsuperAdminBySortedFirstNameAsc(Sort.by(Sort.Direction.ASC,firstName));
    }

//    @Override
//    public List<VssSuperAdmindto> getAllsuperAdminByUuid(String uuid,String firstName) {
//        return superAdminRepository.getAllsuperAdminByUuid(Sort.by(Sort.Direction.ASC,firstName),uuid);
//    }

    @Override
    public String deletesuperAdminByuuid(String uuid, VssSuperAdmin vssSuperAdmin) {
        this.superAdminRepository.deletesuperAdminByuuid(false,LocalDateTime.now(),vssSuperAdmin.getLastModifiedBy(),uuid);
        return "Delete superAdmin Successfully";
    }

    @Override
    public String updateSuperAdminByuuid(String uuid, VssSuperAdmin vssSuperAdmin, MultipartFile file, String path) throws IOException {
        this.superAdminRepository.updateSuperAdminByuuid(vssSuperAdmin.getPassword(), path, vssSuperAdmin.getFirstName(), vssSuperAdmin.getLastName(), vssSuperAdmin.getMobileNumber(), vssSuperAdmin.getPhoneNumber(), LocalDateTime.now(), vssSuperAdmin.getLastModifiedBy(), uuid);

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
        return "superAdmin Update Successfully";
    }



    @Override/*Login SuperAdmin*/
    public VssSuperAdmin getUserByEmailAndPassword(String emailId, String password) throws Exception {

        if (!validateEmail(emailId) || !validatePassword(password)) {
            throw new Exception("Invalid email or password format.");
        }
// Check if the email and password match the stored user credentials
        VssSuperAdmin user = superAdminRepository.getSuperAdminByEmailId(emailId);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new Exception("You entered an incorrect username or password.");
        }
    }

    private boolean validateEmail(String emailId) {
// Check if the email is a valid email address format
        return emailId.matches("[^@]+@[^@]+\\.[^@]+");
    }

    private boolean validatePassword(String password) {
// Check if the password meets the password requirements
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}


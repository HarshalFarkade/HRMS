package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.DashboardDto;
import com.vhyom.saas.dto.VssSuperAdmindto;
import com.vhyom.saas.entity.VssSuperAdmin;
import com.vhyom.saas.repository.SuperAdminRepository;
import com.vhyom.saas.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class SuperAdminServiceImp implements SuperAdminService {
    @Autowired
    private SuperAdminRepository superAdminRepository;
    @Override
    public String createSuperAdmin( VssSuperAdmin vssSuperAdmin,String password, MultipartFile file, String path) throws IOException {

        this.superAdminRepository.createSuperAdmin(vssSuperAdmin.getEmailId(),password, path, vssSuperAdmin.getFirstName(), vssSuperAdmin.getLastName(), vssSuperAdmin.getMobileNumber(), vssSuperAdmin.getPhoneNumber(), vssSuperAdmin.getCreatedBy());
       return "SuperAdmin Created";
    }

    @Override
   public List<VssSuperAdmindto> getAllsuperAdmin() {
        return superAdminRepository.getAllsuperAdmin();
    }

    @Override
    public VssSuperAdmindto getSuperAdminByUuid(String uuid) {
        return superAdminRepository.getSuperAdminByUuid(uuid);
    }

    @Override
    public String deletesuperAdminByuuid(String uuid, VssSuperAdmin vssSuperAdmin) {
        this.superAdminRepository.deletesuperAdminByuuid(false,new Date(),vssSuperAdmin.getLastModifiedBy(),uuid);
        return "Delete superAdmin Successfully"+LocalDateTime.now();
    }

    @Override
    public String updateSuperAdminByuuid(String uuid, VssSuperAdmin vssSuperAdmin, String password,MultipartFile file, String path) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd:HHmmss.SS");
        String formattedDate = dateFormat.format(new Date());
        this.superAdminRepository.updateSuperAdminByuuid( password, path, vssSuperAdmin.getFirstName(), vssSuperAdmin.getLastName(), vssSuperAdmin.getMobileNumber(), vssSuperAdmin.getPhoneNumber(),vssSuperAdmin.getLastModifiedBy(), new Date(),  uuid);
        return "superAdmin Update Successfully"+LocalDateTime.now();
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

    @Override
    public List<DashboardDto> getDashboardData() {
        return superAdminRepository.getDashboardData();
    }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HHmmss.SSSS");
        return dateFormat.format(date);
    }

}


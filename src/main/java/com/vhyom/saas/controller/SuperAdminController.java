package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.dto.DashboardDto;
import com.vhyom.saas.dto.VssSuperAdmindto;
import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.entity.VssSuperAdmin;
import com.vhyom.saas.service.SuperAdminService;
import com.vhyom.saas.service.impl.SuperAdminServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/superAdmin")
public class SuperAdminController {
    @Autowired
    private SuperAdminService superAdminService ;

    @Value("${custom-properites.profilePhoto.directory}")
    private String path;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/superAdmin")/* This API is for creating New superAdmin */
    public String createSuperAdmin(VssSuperAdmin vssSuperAdmin,@RequestPart("superAdmin") String superAdmin, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started" + file.getOriginalFilename());
        if (file.isEmpty()){
            path=null;
            vssSuperAdmin= new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
            this.superAdminService.createSuperAdmin(vssSuperAdmin, file, path);
            return "SuperAdin Created Successfully";
        }
        vssSuperAdmin = new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
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
        vssSuperAdmin.setProfilePhoto(fileName);
        this.superAdminService.createSuperAdmin(vssSuperAdmin, file, path);
        return "SuperAdin Created Successfully";
    }

    @GetMapping("/superAdmin/allsuperAdmin/{firstName}")/* This API is for getting all superAdmin sort by firstName */
    public  List<VssSuperAdmindto> getAllsuperAdminBySortedFirstNameAsc(@PathVariable String firstName) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminService.getAllsuperAdminBySortedFirstNameAsc(firstName);
    }

    @GetMapping("/superAdmin/allsuperAdminByUuid/{firstName}/{uuid}")/* This API is for Getting deatils of SuperAdmin as per uuid*/
    public List<VssSuperAdmindto> getAllsuperAdminByUuid(@PathVariable String uuid, @PathVariable String firstName) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminService.getAllsuperAdminByUuid(uuid, firstName);
    }

    @PutMapping("/superAdmin/deletesuperAdmin/{uuid}")/* This API is for deleting SuperAdmin */
    public String deletesuperAdminByuuid(@PathVariable String uuid, @RequestBody VssSuperAdmin vssSuperAdmin) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminService.deletesuperAdminByuuid(uuid, vssSuperAdmin);
    }

    @PutMapping("/superAdmin/updateByUuid/{uuid}")/*This API is for Update SuperAdmin Details by uuid*/
    public String updateSuperAdminByuuid(VssSuperAdmin vssSuperAdmin,@PathVariable String uuid, @RequestPart("superAdmin") String superAdmin, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started" + file.getOriginalFilename());
        if (file.isEmpty()){
            path=null;
            vssSuperAdmin= new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
            this.superAdminService.updateSuperAdminByuuid(uuid,vssSuperAdmin, file, path);
            return "Update SuperAdmin Successfully";
        }
        vssSuperAdmin = new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
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
        vssSuperAdmin.setProfilePhoto(fileName);
        this.superAdminService.updateSuperAdminByuuid(uuid,vssSuperAdmin, file, path);
        return "Update SuperAdmin Successfully";

    }

    @PostMapping("/superAdmin/login")/* This API is for  Login superAdmin */
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> request) {
        try {
            String emailId = request.get("emailId");
            String password = request.get("password");
            VssSuperAdmin vssSuperAdmin = superAdminService.getUserByEmailAndPassword(emailId, password);
            Map<String, Object> response = new HashMap<>();
            response.put("uuid", vssSuperAdmin.getUuid());
            response.put("emailId", vssSuperAdmin.getEmailId());
            response.put("first_name", vssSuperAdmin.getFirstName());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

    }

    @GetMapping("/dashboard/graph-data")
    public List<DashboardDto> getDashboardData(){
        return superAdminService.getDashboardData();
    }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dateobj = new Date();
        return df.format(dateobj);
    }
}

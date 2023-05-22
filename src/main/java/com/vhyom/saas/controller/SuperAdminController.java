package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.dto.DashboardDto;
import com.vhyom.saas.dto.VssSuperAdmindto;
import com.vhyom.saas.entity.VssSuperAdmin;
import com.vhyom.saas.service.SuperAdminService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
public class SuperAdminController {
    @Autowired
    private SuperAdminService superAdminService ;

    @Value("${custom-properites.profilePhoto.directory}")
    private String path;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/superAdmin")/* This API is for creating New superAdmin */
    public String createSuperAdmin(@Valid VssSuperAdmin vssSuperAdmin,@RequestPart("password")String password,@RequestPart("superAdmin") String superAdmin, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started" + file.getOriginalFilename());
        if (file.isEmpty()){
            path=null;
            vssSuperAdmin= new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
            this.superAdminService.createSuperAdmin(vssSuperAdmin, password,file, path);
            return "SuperAdmin Created Successfully";
        }else {
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
            this.superAdminService.createSuperAdmin(vssSuperAdmin, password, file, path);
            return "SuperAdmin Created Successfully";
        }
    }

    @GetMapping("/superAdmin/allsuperAdmin")/* This API is for getting all superAdmin sort by firstName */
    public  List<VssSuperAdmindto> getAllsuperAdmin() {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminService.getAllsuperAdmin();
    }

    @GetMapping("/superAdmin/allsuperAdminByUuid/{uuid}")/* This API is for Getting details of SuperAdmin as per uuid*/
    public VssSuperAdmindto getSuperAdminByUuid(@PathVariable String uuid) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminService.getSuperAdminByUuid(uuid);
    }

    @PutMapping("/superAdmin/deletesuperAdmin/{uuid}")/* This API is for deleting SuperAdmin */
    public String deletesuperAdminByuuid(@PathVariable String uuid, @RequestBody VssSuperAdmin vssSuperAdmin) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminService.deletesuperAdminByuuid(uuid, vssSuperAdmin);
    }

    @PutMapping("/superAdmin/updateByUuid/{uuid}")/*This API is for Update SuperAdmin Details by uuid*/
    public String updateSuperAdminByuuid(@Valid VssSuperAdmin vssSuperAdmin,@RequestPart("password")String password, @PathVariable String uuid, @RequestPart("superAdmin") String superAdmin, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started" + file.getOriginalFilename());
        if (file.isEmpty()){
            path=null;
            vssSuperAdmin= new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
            this.superAdminService.updateSuperAdminByuuid(uuid,vssSuperAdmin,password, file, path);
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
        this.superAdminService.updateSuperAdminByuuid(uuid,vssSuperAdmin, password,file, path);
        return "Update SuperAdmin Successfully";

    }

    @GetMapping("/superAdmin/login")/* This API is for  Login superAdmin */
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

package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.entity.VssSuperAdmin;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/superAdmin")
public class SuperAdminController {
    @Autowired
    private SuperAdminServiceImp superAdminServiceImp;

    @Value("${custom-properites.profilePhoto.directory}")
    private String path;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/superAdmin")/* This API is for creating superAdmin */
    public String createSuperAdmin(@RequestPart("superAdmin") String superAdmin, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started" + file.getOriginalFilename());
        VssSuperAdmin vssSuperAdmin = new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
        this.superAdminServiceImp.createSuperAdmin(vssSuperAdmin, file, path);
        return "SuperAdin Created Successfully";
    }

    @GetMapping("/superAdmin/allsuperAdmin/{firstName}")/* This API is for getting all superAdmin sort by first name */
    public ResponseEntity<List<Object[]>> getAllsuperAdminBySortedFirstNameAsc(@PathVariable String firstName) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return new ResponseEntity<>(superAdminServiceImp.getAllsuperAdminBySortedFirstNameAsc(firstName), HttpStatus.OK);
    }

    @GetMapping("/superAdmin/allsuperAdminByUuid/{firstName}/{uuid}")/* This API is for Getting deatils as per uuid*/
    public ResponseEntity<List<Object[]>> getAllsuperAdminByUuid(@PathVariable String uuid, @PathVariable String firstName) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return new ResponseEntity<>(superAdminServiceImp.getAllsuperAdminByUuid(uuid, firstName), HttpStatus.OK);
    }

    @PutMapping("/superAdmin/deletesuperAdmin/{uuid}")/* This API is for deleting SuperAdmin */
    public String deletesuperAdminByuuid(@PathVariable String uuid, @RequestBody VssSuperAdmin vssSuperAdmin) {
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return superAdminServiceImp.deletesuperAdminByuuid(uuid, vssSuperAdmin);
    }

    @PutMapping("/superAdmin/updateByUuid/{uuid}")/*This API is for Update SuperAdmin Details*/
    public String updateSuperAdminByuuid(@PathVariable String uuid, @RequestPart("superAdmin") String superAdmin, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started" + file.getOriginalFilename());
        VssSuperAdmin vssSuperAdmin = new ObjectMapper().readValue(superAdmin, VssSuperAdmin.class);
        return superAdminServiceImp.updateSuperAdminByuuid(uuid, vssSuperAdmin, file, path);

    }

    @PostMapping("/superAdmin/login")/* This API is for  Login superAdmin */
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> request) {
        try {
            String emailId = request.get("emailId");
            String password = request.get("password");
            VssSuperAdmin vssSuperAdmin = superAdminServiceImp.getUserByEmailAndPassword(emailId, password);
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
}

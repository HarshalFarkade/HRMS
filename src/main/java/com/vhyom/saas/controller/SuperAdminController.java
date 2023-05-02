package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.entity.VssSuperAdmin;
import com.vhyom.saas.service.impl.SuperAdminServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/superAdmin")
public class SuperAdminController {
    @Autowired
    private SuperAdminServiceImp superAdminServiceImp;

    @Value("${custom-properites.profilePhoto.directory}")
    private String path;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/superAdmin")/* This API is for creating superAdmin */
    public String createSuperAdmin(@RequestPart("superAdmin")String superAdmin, @RequestPart("profilePhoto")MultipartFile file ) throws IOException {
        LOGGER.info("SuperAdminController: createSuperAdmin is started"+ file.getOriginalFilename());
        VssSuperAdmin vssSuperAdmin =new ObjectMapper().readValue(superAdmin,VssSuperAdmin.class);
        this.superAdminServiceImp.createSuperAdmin(vssSuperAdmin,file,path);
        return "SuperAdin Created Successfully";
    }
    @GetMapping("/superAdmin/allsuperAdmin/{firstName}")/* This API is for getting all superAdmin sort by first name */
    public ResponseEntity<List<Object[]>>getAllsuperAdminBySortedFirstNameAsc(@PathVariable String firstName ){
        LOGGER.info("SuperAdminController: createSuperAdmin is started");
        return new ResponseEntity<>(superAdminServiceImp.getAllsuperAdminBySortedFirstNameAsc(firstName), HttpStatus.OK);
    }

}

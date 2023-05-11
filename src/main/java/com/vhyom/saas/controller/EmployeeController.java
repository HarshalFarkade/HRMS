package com.vhyom.saas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.entity.VssSuperAdmin;
import com.vhyom.saas.service.EmployeeService;
import com.vhyom.saas.service.impl.EmployeeServiceImpl;
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

@RestController
@RequestMapping("/api/v1/Employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Value("${custom-properites.profilePhotoemp.directory}")
    private String path;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/employee/createEmployee") /* This API is for creating New Employee */
    public String createEmployee(@Valid VshEmployee vshEmployee,@RequestPart("emailId")String emailId,@RequestPart("employee") String employee, @RequestPart("profilePhoto") MultipartFile file) throws IOException {
        LOGGER.info("EmployeeController: createEmployee is started" + file.getOriginalFilename());
        vshEmployee = new ObjectMapper().readValue(employee, VshEmployee.class);
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
        vshEmployee.setProfilePhoto(fileName);
        this.employeeService.createEmployee(emailId,vshEmployee, file, path);
        return "Employee Created Successfully";

    }

    public String getCurrentTime() {

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        Date dateobj = new Date();

        return df.format(dateobj);

    }
}

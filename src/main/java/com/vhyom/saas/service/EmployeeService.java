package com.vhyom.saas.service;

import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.entity.VssCompany;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;



public interface EmployeeService {
    VshEmployee createEmployee(String emailId , VshEmployee vshEmployee, MultipartFile file, String path) throws IOException;}

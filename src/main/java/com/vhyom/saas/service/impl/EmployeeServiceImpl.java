package com.vhyom.saas.service.impl;

import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.repository.EmployeeRepository;
import com.vhyom.saas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public VshEmployee createEmployee(String emailId, VshEmployee vshEmployee, MultipartFile file, String path) throws IOException {
        this.employeeRepository.createEmployee(vshEmployee.getPartnerId(),vshEmployee.getPartnerNumber(), emailId, vshEmployee.getPassword(),vshEmployee.getSalt(),path,vshEmployee.getFirstName(),vshEmployee.getLastName(),vshEmployee.getDateOfBirth(),vshEmployee.getMobileNumber(),vshEmployee.getPhoneNumber(),vshEmployee.getCreatedBy());
        return vshEmployee;
    }

}

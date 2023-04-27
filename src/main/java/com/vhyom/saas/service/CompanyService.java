package com.vhyom.saas.service;

import com.vhyom.saas.entity.VssCompany;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface CompanyService {

    String createCompany(VssCompany vssCompany, Integer superAdminId, MultipartFile file, String path);

    List<Object[]>getAllcompany();

    List<Object[]>getCompanyByUuid(String uuid);



}

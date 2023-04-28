package com.vhyom.saas.service;

import com.vhyom.saas.entity.VssCompany;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface CompanyService {

    String createCompany(VssCompany vssCompany, Integer superAdminId, MultipartFile file, String path);

    List<Object[]>getAllcompany();

    List<Object[]>getCompanyByUuid(String uuid);

    String deletCompanyByUuid(String uuid ,VssCompany vssCompany);

    String updateCompanyByUuid(String uuid, VssCompany vssCompany, String path, MultipartFile file) throws IOException;



}

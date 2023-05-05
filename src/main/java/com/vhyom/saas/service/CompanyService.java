package com.vhyom.saas.service;

import com.vhyom.saas.dto.VssCompanydto;
import com.vhyom.saas.entity.VssCompany;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface CompanyService {

    VssCompany createCompany(String name ,VssCompany vssCompany, MultipartFile file, String path) throws IOException;

    List<VssCompanydto> getAllcompany();

    VssCompanydto getCompanyByUuid(String uuid);

    String deletCompanyByUuid(String uuid ,VssCompany vssCompany);

    String updateCompanyByUuid(String uuid, VssCompany vssCompany, String path, MultipartFile file) throws IOException;



}

package com.vhyom.saas.Service;

import com.vhyom.saas.entity.VssCompany;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CompanyService {

    String createCompany(VssCompany vssCompany, Integer superAdminId, MultipartFile file, String path);
}

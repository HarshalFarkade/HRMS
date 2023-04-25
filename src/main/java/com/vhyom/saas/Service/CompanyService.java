package com.vhyom.saas.Service;

import com.vhyom.saas.entity.VssCompany;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    String createCompany(VssCompany vssCompany);
}

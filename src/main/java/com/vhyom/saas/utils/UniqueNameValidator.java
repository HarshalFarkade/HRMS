package com.vhyom.saas.utils;

import com.vhyom.saas.repository.CompanyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,String>{
    @Autowired
    private CompanyRepository companyRepository ;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !companyRepository.existsByName(value);
    }
}

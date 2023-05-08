package com.vhyom.saas.utils;

import com.vhyom.saas.repository.CompanyRepository;
import com.vhyom.saas.repository.EmployeeRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,String > {
    @Autowired
    private CompanyRepository companyRepository ;
    
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public boolean isValid( String value, ConstraintValidatorContext context) {

        if (companyRepository.existsByName(value)){
            return false;
        } else if (subscriptionRepository.existsByPlanName(value)) {
            return false;
        } else if(employeeRepository.existsByEmailId(value)){
            return false;
        }
        else {
            return true;
        }
    }


}

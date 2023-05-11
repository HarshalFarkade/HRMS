package com.vhyom.saas.utils;

import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.repository.CompanyRepository;
import com.vhyom.saas.repository.EmployeeRepository;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,Object > {
    @Autowired
    private CompanyRepository companyRepository ;
    
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;
    
    @Override
    public boolean isValid( Object value, ConstraintValidatorContext context) {

        if (companyRepository.existsByName((String) value)){
            return false;
        } else if (subscriptionRepository.existsByPlanName((String) value)) {
            return false;
        } else if(employeeRepository.existsByEmailId((String) value)){
            return false;
        }
        else {
            return true;
        }
    }


}

package com.vhyom.saas.utils;

import com.vhyom.saas.repository.CompanyRepository;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueIdValidator implements ConstraintValidator <UniqueId ,Integer>{

    @Autowired
    private CompanyRepository companyRepository ;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(subscriptionDetailsRepository.existsByCompanyId((Integer) value)){
            return false;
        }//else if(subscriptionDetailsRepository.existsBySubscriptionId((VssSubscription)value)){
        //   return false;
        //}
        return false;
    }
}

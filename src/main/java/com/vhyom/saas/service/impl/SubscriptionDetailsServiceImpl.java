package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.service.SubscriptionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionDetailsServiceImpl implements SubscriptionDetailsService {

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;


    @Override
    public String createSubscriptionDetails(VssSubscriptionDetails vssSubscriptionDetails, VssCompany company, VssSubscription subscription) {
        this.subscriptionDetailsRepository.createSubscriptionDetails(company.getId(), subscription.getId(), vssSubscriptionDetails.getStartDate(), vssSubscriptionDetails.getEndDate(), vssSubscriptionDetails.getStatus(),
                vssSubscriptionDetails.getCreatedBy());
        return "Created Successfully";
    }

    @Override
    public List<SubscriptionDetailsDto> getAllSubscriptionDetails() {
        return subscriptionDetailsRepository.getAllSubscriptionDetails();
    }

    @Override
    public SubscriptionDetailsDto getSubscriptionDetailsByUuid(String uuid) {
        return subscriptionDetailsRepository.getSubscriptionDetailsByUuid(uuid);
    }

    @Override
    public String deleteSubscriptionDetailsBYUuid(String uuid, VssSubscriptionDetails vssSubscriptionDetails) {
        this.subscriptionDetailsRepository.deleteSubscriptionDetailsBYUuid(LocalDateTime.now(),vssSubscriptionDetails.getLastModifiedBy(),false,uuid);
        return "SubscriptionDetails Deleted Successfully";
    }

    @Override
    public String updateSubscriptionDetails( VssSubscriptionDetails vssSubscriptionDetails, VssCompany company, VssSubscription subscription,String uuid) {
        this.subscriptionDetailsRepository.updateSubscriptionDetails(company,subscription,vssSubscriptionDetails.getStartDate(),vssSubscriptionDetails.getEndDate(), vssSubscriptionDetails.getStatus(), vssSubscriptionDetails.getLastModifiedBy(),LocalDateTime.now(),uuid);
        return "SubscriptionDetails Updated Successfully";
    }

}

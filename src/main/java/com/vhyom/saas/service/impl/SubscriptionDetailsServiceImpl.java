package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.service.SubscriptionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class SubscriptionDetailsServiceImpl implements SubscriptionDetailsService {

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;

    @Override
    public List<SubscriptionDetailsDto> getAllSubscriptionDetails() {
        return subscriptionDetailsRepository.getAllSubscriptionDetails();
    }


    @Override
    public List<SubscriptionDetailsDto> getSubscriptionDetailsByUuid(String uuid) {
        return subscriptionDetailsRepository.getSubscriptionDetailsByUuid(uuid);
    }

    @Override
    public String deleteSubscriptionDetailsBYUuid(String uuid, VssSubscriptionDetails vssSubscriptionDetails) {
        this.subscriptionDetailsRepository.deleteSubscriptionDetailsBYUuid(LocalDateTime.now(),vssSubscriptionDetails.getLastModifiedBy(),false,uuid);
        return "SubscriptionDetails Updated Successfully";
    }
}

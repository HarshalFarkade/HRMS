package com.vhyom.saas.service.impl;

import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.repository.SubscriptionRepository;
import com.vhyom.saas.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Override
    public String createSubsciption(VssSubscription vssSubscription) {
        this.subscriptionRepository.createSubsciption(vssSubscription.getPlanName(), vssSubscription.getPlanPrice(), vssSubscription.getPlanType(), vssSubscription.getTotalUsers(), vssSubscription.getDescription(), vssSubscription.getCreatedBy());
        return "Created Successfully";
    }

    @Override
    public List<Object[]> getAllSubscription() {
        return subscriptionRepository.getAllSubscription();
   }

    @Override
    public List<Object[]> getSubscriptionByUuid(String uuid) {
        return subscriptionRepository.getSubscriptionByUuid(uuid);
    }


}

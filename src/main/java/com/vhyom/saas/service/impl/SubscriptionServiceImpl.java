package com.vhyom.saas.service.impl;

import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.repository.SubscriptionDetailRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import com.vhyom.saas.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionDetailRepository subscriptionDetailRepository;

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
    public List<Object[]> getSubscriptionByUuid(String uuid ) {
        return subscriptionRepository.getSubscriptionByUuid(uuid);
    }

//    @Override
//    public String deleteSubscription(String uuid,VssSubscription vssSubscription) {
//            this.subscriptionRepository.deleteSubscription(false, LocalDateTime.now(),vssSubscription.getLastModifiedBy(),uuid);
//            return "Subscription Delete Successfully";
//
//    }

    @Override
    public String updateSubscriptionByUuid(String uuid, VssSubscription vssSubscription) {
        this.subscriptionRepository.updateSubscriptionByUuid(vssSubscription.getPlanName(),vssSubscription.getPlanPrice(), vssSubscription.getPlanType(), vssSubscription.getTotalUsers(), vssSubscription.getDescription(), vssSubscription.getLastModifiedBy(), LocalDateTime.now(),uuid);
        return " subscription Update Successfully";
    }


}

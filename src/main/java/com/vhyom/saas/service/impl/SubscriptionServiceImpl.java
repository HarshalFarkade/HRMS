package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.VssSubscriptiondto;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import com.vhyom.saas.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailRepository;

    @Override
    public String createSubsciption(VssSubscription vssSubscription) {
        this.subscriptionRepository.createSubsciption(vssSubscription.getPlanName(), vssSubscription.getPlanPrice(), vssSubscription.getPlanType(), vssSubscription.getTotalUsers(), vssSubscription.getDescription(), vssSubscription.getCreatedBy());
        return "Created Successfully";
    }

    @Override
    public List<VssSubscriptiondto> getAllSubscription() {
        return subscriptionRepository.getAllSubscription();
   }

    @Override
    public VssSubscriptiondto getSubscriptionByUuid(String uuid ) {
        return subscriptionRepository.getSubscriptionByUuid(uuid);
    }

    @Override
    public String deleteSubscription(String uuid,VssSubscription vssSubscription) {
            this.subscriptionRepository.deleteSubscription(false, new Date(),vssSubscription.getLastModifiedBy(),uuid);
            return "Subscription Delete Successfully";

    }

    @Override
    public String updateSubscriptionByUuid(String uuid, VssSubscription vssSubscription) {
        this.subscriptionRepository.updateSubscriptionByUuid(vssSubscription.getPlanName(),vssSubscription.getPlanPrice(), vssSubscription.getPlanType(), vssSubscription.getTotalUsers(), vssSubscription.getDescription(), vssSubscription.getLastModifiedBy(), new Date(),uuid);
        return " subscription Update Successfully";
    }


}

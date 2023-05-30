package com.vhyom.saas.service;

import com.vhyom.saas.dto.VssSubscriptiondto;
import com.vhyom.saas.entity.VssSubscription;

import java.util.List;

public interface SubscriptionService {

    String createSubscription(VssSubscription vssSubscription);

    List<VssSubscriptiondto>getAllSubscription();

    VssSubscriptiondto getSubscriptionByUuid(String uuid);

   String deleteSubscription(String uuid , VssSubscription vssSubscription);

    String updateSubscriptionByUuid(String uuid,VssSubscription vssSubscription);
}

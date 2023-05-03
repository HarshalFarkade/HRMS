package com.vhyom.saas.service;

import com.vhyom.saas.entity.VssSubscription;

import java.util.List;

public interface SubscriptionService {

    String createSubsciption(VssSubscription vssSubscription);

    List<Object[]>getAllSubscription();

    List<Object[]>getSubscriptionByUuid(String uuid);
}

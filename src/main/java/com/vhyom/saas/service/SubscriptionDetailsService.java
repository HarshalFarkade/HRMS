package com.vhyom.saas.service;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;

import java.util.List;
import java.util.Objects;

public interface SubscriptionDetailsService {

//    String createSubscriptionDetails(VssSubscriptionDetails vssSubscriptionDetails, VssCompany vssCompany, VssSubscription vssSubscription);

    List<SubscriptionDetailsDto> getAllSubscriptionDetails();

    List<SubscriptionDetailsDto> getSubscriptionDetailsByUuid(String uuid);

    String deleteSubscriptionDetailsBYUuid(String uuid, VssSubscriptionDetails vssSubscriptionDetails);
}

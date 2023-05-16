package com.vhyom.saas.service;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;

import java.util.List;

public interface SubscriptionDetailsService {


    String createSubscriptionDetails(VssSubscriptionDetails vssSubscriptionDetails, VssCompany company, VssSubscription subscription);

    List<SubscriptionDetailsDto> getAllSubscriptionDetails();

    SubscriptionDetailsDto getSubscriptionDetailsByUuid(String uuid);

    String deleteSubscriptionDetailsBYUuid(String uuid, VssSubscriptionDetails vssSubscriptionDetails);

    String updateSubscriptionDetails(VssSubscriptionDetails vssSubscriptionDetails,VssCompany vssCompany,VssSubscription vssSubscription,String uuid);


}

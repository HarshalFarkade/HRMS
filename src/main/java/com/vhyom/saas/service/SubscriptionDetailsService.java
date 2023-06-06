package com.vhyom.saas.service;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetail;

import java.util.List;

public interface SubscriptionDetailsService {


    String createSubscriptionDetails(VssSubscriptionDetail vssSubscriptionDetails, VssCompany company, VssSubscription subscription);

    List<SubscriptionDetailsDto> getAllSubscriptionDetails();

    SubscriptionDetailsDto getSubscriptionDetailsByUuid(String uuid);

    String deleteSubscriptionDetailsBYUuid(String uuid, VssSubscriptionDetail vssSubscriptionDetails);

    String updateSubscriptionDetails(VssSubscriptionDetail vssSubscriptionDetails,VssCompany company,VssSubscription vssSubscription,String uuid);


}

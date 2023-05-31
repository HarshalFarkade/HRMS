package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.service.SubscriptionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionDetailsServiceImpl implements SubscriptionDetailsService {

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;

@Transactional
@Override
public String createSubscriptionDetails(VssSubscriptionDetails vssSubscriptionDetails, VssCompany company, VssSubscription subscription) {

    Date currentDate = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDate);
    calendar.add(Calendar.YEAR, 1);
    Date nextYearDate = calendar.getTime();

    vssSubscriptionDetails.setStartDate(currentDate);
    vssSubscriptionDetails.setEndDate(nextYearDate);
    vssSubscriptionDetails.setStatus(vssSubscriptionDetails.getStatus());
    vssSubscriptionDetails.setCreatedBy(vssSubscriptionDetails.getCreatedBy());
    // Set other fields as needed

    this.subscriptionDetailsRepository.createSubscriptionDetails(company.getId(),subscription.getId(),new Date(),nextYearDate, vssSubscriptionDetails.getStatus(), vssSubscriptionDetails.getCreatedBy());
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
        this.subscriptionDetailsRepository.deleteSubscriptionDetailsBYUuid(new Date(),vssSubscriptionDetails.getLastModifiedBy(),false,uuid);
        return "SubscriptionDetails Deleted Successfully";
    }

    @Override
    public String updateSubscriptionDetails( VssSubscriptionDetails vssSubscriptionDetails, VssCompany company, VssSubscription subscription,String uuid) {
        this.subscriptionDetailsRepository.updateSubscriptionDetails(company,subscription,vssSubscriptionDetails.getStartDate(),vssSubscriptionDetails.getEndDate(), vssSubscriptionDetails.getStatus(), vssSubscriptionDetails.getLastModifiedBy(),new Date(),uuid);
        return "SubscriptionDetails Updated Successfully";
    }

}

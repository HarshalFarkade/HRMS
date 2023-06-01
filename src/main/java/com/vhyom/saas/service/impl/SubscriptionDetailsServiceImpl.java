package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.service.SubscriptionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionDetailsServiceImpl implements SubscriptionDetailsService {

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;



    @Override
    public String createSubscriptionDetails(VssSubscriptionDetails vssSubscriptionDetails, VssCompany company, VssSubscription subscription) {
        String planType = String.valueOf(subscription.getPlanType());
        Date currentDate = new Date();
        vssSubscriptionDetails.setStartDate(currentDate);
        Calendar calendar = Calendar.getInstance();
        if (planType.equals("1")) {
            calendar.add(Calendar.MONTH, 1);
        } else if (planType.equals("2")) {
            calendar.add(Calendar.MONTH, 6);
        } else if (planType.equals("3")) {
            calendar.add(Calendar.YEAR, 1);
        } else {
            return "Invalid planType";
        }
        Date endDate = calendar.getTime();
        this.subscriptionDetailsRepository.createSubscriptionDetails(company.getId(), subscription.getId(), vssSubscriptionDetails.getStartDate(), endDate, vssSubscriptionDetails.getStatus(), vssSubscriptionDetails.getCreatedBy());
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
        String planType = String.valueOf(subscription.getPlanType());
        Date currentDate = new Date();
        vssSubscriptionDetails.setStartDate(currentDate);

        Calendar calendar = Calendar.getInstance();
        if (planType.equals("1")) {
            calendar.add(Calendar.MONTH, 1);
        } else if (planType.equals("2")) {
            calendar.add(Calendar.MONTH, 6);
        } else if (planType.equals("3")) {
            calendar.add(Calendar.YEAR, 1);
        } else {

            return "Invalid planType";
        }

        Date endDate = calendar.getTime();
        this.subscriptionDetailsRepository.updateSubscriptionDetails(company,subscription,vssSubscriptionDetails.getStartDate(),endDate, vssSubscriptionDetails.getStatus(), vssSubscriptionDetails.getLastModifiedBy(),new Date(),uuid);
        return "SubscriptionDetails Updated Successfully";
    }

}

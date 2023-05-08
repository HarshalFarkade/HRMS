package com.vhyom.saas.controller;


import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.service.impl.SubscriptionDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("api/v1/subscriptionDetails")
@RestController
public class SubscriptionDetailsController {

    @Autowired
    private SubscriptionDetailsServiceImpl subscriptionDetailsService;

    @GetMapping("subscriptionDetails/getAllSubscriptionDetails") /* This API is for Getting All details of SubscriptionDetails */
    public List<SubscriptionDetailsDto> getAllSubscriptionDetails(){
        return subscriptionDetailsService.getAllSubscriptionDetails();
    }

    @GetMapping("subscriptionDetails/getSubscriptionDetails/{uuid}") /* THia API is FOr getting Details of SubscriptionDetails By uuid */
    public  List<SubscriptionDetailsDto>getSubscriptionDetailsByUuid(@PathVariable String uuid){
        return subscriptionDetailsService.getSubscriptionDetailsByUuid(uuid);
    }


    @PutMapping("subscriptionDetails/deleteSubscriptionDetails/{uuid}")/*This API is for Deleting SubscriptionDetails By uuid */
    public String deleteSubscriptionDetailsBYUuid(@PathVariable String uuid, @RequestBody VssSubscriptionDetails vssSubscriptionDetails){
        return subscriptionDetailsService.deleteSubscriptionDetailsBYUuid(uuid, vssSubscriptionDetails);
    }

}

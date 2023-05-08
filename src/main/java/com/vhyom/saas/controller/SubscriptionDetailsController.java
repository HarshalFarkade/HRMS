package com.vhyom.saas.controller;


import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.service.impl.SubscriptionDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("api/v1/subscriptionDetails")
@RestController
public class SubscriptionDetailsController {

    @Autowired
    private SubscriptionDetailsServiceImpl subscriptionDetailsService;

//    @PostMapping("subscriptionDetails/create") /* This API is for creating new SubscriptionDetails */
//    public String createSubscriptionDetails(@Valid  @RequestBody VssSubscriptionDetails vssSubscriptionDetails, @RequestParam VssCompany vssCompany, @RequestParam VssSubscription vssSubscription){
//        this.subscriptionDetailsService.createSubscriptionDetails(vssSubscriptionDetails,vssCompany,vssSubscription);
//        return "SubscriptionDetails Created Successfully";
//    }

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

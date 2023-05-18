package com.vhyom.saas.controller;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.service.SubscriptionDetailsService;
import com.vhyom.saas.service.impl.SubscriptionDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RequestMapping("api/v1/subscriptionDetails")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
public class SubscriptionDetailsController {

    @Autowired
    private SubscriptionDetailsService subscriptionDetailsService;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;

    @PostMapping("subscriptionDetails/create") /* This API is for creating new SubscriptionDetails */
    public String createSubscriptionDetails(@RequestBody VssSubscriptionDetails vssSubscriptionDetails, @RequestParam VssCompany company,@RequestParam VssSubscription subscription) {
        if(subscriptionDetailsRepository.existsByCompanyId(company)) {
            return "This Comapny Already have subcription";
        }else if(subscriptionDetailsRepository.existsBySubscriptionId(subscription)) {
            return "Subscription already available";
        }else {
            return subscriptionDetailsService.createSubscriptionDetails(vssSubscriptionDetails, company, subscription);

        }

    }

    @GetMapping("subscriptionDetails/getAllSubscriptionDetails") /* This API is for Getting All details of SubscriptionDetails */
    public List<SubscriptionDetailsDto> getAllSubscriptionDetails(){
        return subscriptionDetailsService.getAllSubscriptionDetails();
    }

    @GetMapping("subscriptionDetails/getSubscriptionDetails/{uuid}") /* THia API is FOr getting Details of SubscriptionDetails By uuid */
    public  SubscriptionDetailsDto getSubscriptionDetailsByUuid(@PathVariable String uuid){
        return subscriptionDetailsService.getSubscriptionDetailsByUuid(uuid);
    }


    @PutMapping("subscriptionDetails/deleteSubscriptionDetails/{uuid}")/*This API is for Deleting SubscriptionDetails By uuid */
    public String deleteSubscriptionDetailsBYUuid(@PathVariable String uuid, @RequestBody VssSubscriptionDetails vssSubscriptionDetails){
        return subscriptionDetailsService.deleteSubscriptionDetailsBYUuid(uuid, vssSubscriptionDetails);
    }


    @PutMapping("subscriptionDetails/updateSubscriptionDetails/{uuid}")/* This API is For updating Subscription Details*/
    public String updateSubscriptionDetails(@RequestBody VssSubscriptionDetails vssSubscriptionDetails, @RequestParam VssCompany company,@RequestParam VssSubscription subscription,@PathVariable String uuid){
        if(subscriptionDetailsRepository.existsByCompanyId(company)) {
            return "This Comapny Already have subcription";
        }else if(subscriptionDetailsRepository.existsBySubscriptionId(subscription)) {
            return "Subscription already available";
        }else {
            return subscriptionDetailsService.updateSubscriptionDetails( vssSubscriptionDetails, company, subscription,uuid);
        }
    }

}

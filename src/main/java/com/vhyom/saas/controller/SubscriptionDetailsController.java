package com.vhyom.saas.controller;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetail;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.service.SubscriptionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/subscriptionDetails")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
public class SubscriptionDetailsController {

    @Autowired
    private SubscriptionDetailsService subscriptionDetailsService;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;

    @PostMapping("/subscriptionDetails/create")
    public String createSubscriptionDetails(@RequestBody VssSubscriptionDetail vssSubscriptionDetails,
                                        @RequestParam VssCompany company,
                                        @RequestParam VssSubscription subscription) {
        if (subscriptionDetailsRepository.existsByCompanyIdAndSubscriptionId(company, subscription)) {
        return "Subscription already available for the company";
       } else {
        return subscriptionDetailsService.createSubscriptionDetails(vssSubscriptionDetails, company, subscription);
            }
      }

    @GetMapping("/subscriptionDetails/getAllSubscriptionDetails") /* This API is for Getting All details of SubscriptionDetails */
    public List<SubscriptionDetailsDto> getAllSubscriptionDetails(){
        return subscriptionDetailsService.getAllSubscriptionDetails();
    }

    @GetMapping("/subscriptionDetails/getSubscriptionDetails/{uuid}") /* THia API is FOr getting Details of SubscriptionDetails By uuid */
    public  SubscriptionDetailsDto getSubscriptionDetailsByUuid(@PathVariable String uuid){
        return subscriptionDetailsService.getSubscriptionDetailsByUuid(uuid);
    }

    @PutMapping("/subscriptionDetails/deleteSubscriptionDetails/{uuid}")/*This API is for Deleting SubscriptionDetails By uuid */
    public String deleteSubscriptionDetailsBYUuid(@PathVariable String uuid, @RequestBody VssSubscriptionDetail vssSubscriptionDetails){
        return subscriptionDetailsService.deleteSubscriptionDetailsBYUuid(uuid, vssSubscriptionDetails);
    }

    @PutMapping("/subscriptionDetails/updateSubscriptionDetails/{uuid}")/* This API is For updating Subscription Details*/
    public String updateSubscriptionDetails(@RequestBody VssSubscriptionDetail vssSubscriptionDetails,@RequestParam VssSubscription subscription,@PathVariable String uuid){
       VssSubscriptionDetail subscriptionDetails =subscriptionDetailsRepository.findByUuid(uuid);
        VssCompany company =subscriptionDetails.getCompanyId();
        if (subscriptionDetailsRepository.existsByCompanyIdAndSubscriptionId(company, subscription)) {
        return "Subscription already available for the company";
    } else {
        return subscriptionDetailsService.updateSubscriptionDetails(vssSubscriptionDetails,  company,subscription,uuid);
    }
    }

}

package com.vhyom.saas.controller;

import com.vhyom.saas.dto.VssSubscriptiondto;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import com.vhyom.saas.service.SubscriptionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/subScription")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionServiceimpl;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create")/* this Api is For  creating new Subscription*/
    public String createSubscription (@Valid @RequestBody VssSubscription vssSubscription){
        LOGGER.info("SubscriptionController: createSubscription is started");
        return subscriptionServiceimpl.createSubscription(vssSubscription);
    }

    @GetMapping("subscription/AllSubscription")/* THis Api is for getting allSubscription Details*/
    public List<VssSubscriptiondto>getAllSubscription(){
        LOGGER.info("SubScriptionController: getAllSubscription is started");
        return subscriptionServiceimpl.getAllSubscription();
    }

    @GetMapping("subscription/getSubscription/{uuid}")/* This API is for Getting Deatils of Subscription by uuid */
    public VssSubscriptiondto getSubscriptionByUuid(@PathVariable String uuid){
        LOGGER.info("SubScriptionController: getSubscription is started");
        return subscriptionServiceimpl.getSubscriptionByUuid(uuid);
    }

    @PutMapping("subscription/deleteSubscription/{uuid}") /* This API is for Delete Subscription by uuid */
    public String deleteSubscription(@PathVariable String uuid ,@RequestBody VssSubscription vssSubscription){
        LOGGER.info("SubScriptionController: deleteSubscription is started");
      VssSubscription subscription =subscriptionRepository.findByUuid(uuid);
      // we just store id with help of uuid from VssSubscription
        Integer subscriptionId=subscription.getId();

        // this will get all details from Subscription-details
        List<VssSubscriptionDetails> subscriptionDetails= subscriptionDetailRepository.findAll();

        // in this line of code we store all VssSubscription data from vssSubscription details
        List<VssSubscription> subscriptionDetailsIds = subscriptionDetails.stream().map(VssSubscriptionDetails::getSubscriptionId).collect(Collectors.toList());

        //this will store the all subscription_id from VssSubscription
        List<Integer> Id =subscriptionDetailsIds.stream().map(VssSubscription::getId).collect(Collectors.toList());

        for (Integer subscriptionDetailsId : Id) {
            if(subscriptionId==subscriptionDetailsId) {
                return "Subscription related to company can't delete";
            }
        }

        return subscriptionServiceimpl.deleteSubscription(uuid,vssSubscription);
    }

    @PutMapping("/subscription/updateSubscription/{uuid}")/*This APi is for Update Subscription by uuid */
    public String updateSubscriptionByUuid(@PathVariable String uuid ,  @Valid @RequestBody VssSubscription vssSubscription){
        LOGGER.info("SubScriptionController: UpdateSubscription is started");
        return subscriptionServiceimpl.updateSubscriptionByUuid(uuid,vssSubscription);
    }
}

package com.vhyom.saas.controller;

import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import com.vhyom.saas.repository.SubscriptionDetailsRepository;
import com.vhyom.saas.repository.SubscriptionRepository;
import com.vhyom.saas.service.impl.SubscriptionServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/subScription")
@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionServiceImpl subscriptionServiceimpl;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create")/* this Api is For  creating new Subscription*/
    public String createSubsciption (@Valid @RequestBody VssSubscription vssSubscription){
        LOGGER.info("SubScriptionController: createSubscription is started");
        return subscriptionServiceimpl.createSubsciption(vssSubscription);
    }

    @GetMapping("subscription/AllSubscription")/* THis Api is for getting allSubscription Details*/
    public ResponseEntity<List<Object[]>>getAllSubscription(){
        LOGGER.info("SubScriptionController: getAllSubscription is started");
        return new ResponseEntity<>(subscriptionServiceimpl.getAllSubscription() , HttpStatus.OK);
    }

    @GetMapping("subscription/getSubscription/{uuid}")/* This API is for Getting Deatils of Subscription by uuid */
    public ResponseEntity<List<Object[]>>getSubscriptionByUuid(@PathVariable String uuid){
        LOGGER.info("SubScriptionController: getSubscription is started");
        return new ResponseEntity<>(subscriptionServiceimpl.getSubscriptionByUuid(uuid),HttpStatus.OK);
    }


    @PutMapping("subscription/deleteSubscription/{uuid}") /* This API is for Delete Subscription by uuid */
    public String deleteSubscription(@PathVariable String uuid ,@RequestBody VssSubscription vssSubscription){
        LOGGER.info("SubScriptionController: deleteSubscription is started");
      VssSubscription subscription =subscriptionRepository.findByUuid(uuid);
        Integer subscriptionId=subscription.getId();
        List<VssSubscriptionDetails> subscriptionDetails= subscriptionDetailRepository.findAll();
        List<VssSubscription> subscriptionDetailsIds = subscriptionDetails.stream().map(VssSubscriptionDetails::getSubscriptionId).collect(Collectors.toList());
        List<Integer> Id =subscriptionDetailsIds.stream().map(VssSubscription::getId).collect(Collectors.toList());

        for (Integer subscriptionDetailsId : Id) {
            if(subscriptionId==subscriptionDetailsId) {
                return "Subscription related to company can't delete";
            }
        }

        return subscriptionServiceimpl.deleteSubscription(uuid,vssSubscription);
    }

//    @PutMapping("subscription/deleteSubscription/{uuid}") /* This API is for Delete Subscription by uuid */
//    public String deleteSubscription(@PathVariable String uuid ,@RequestBody VssSubscription vssSubscription){
//        LOGGER.info("SubScriptionController: deleteSubscription is started");
//        VssSubscription subscription = subscriptionRepository.findByUuid(uuid);
//        Integer subscriptionId = subscription.getId();
//
//        // Check if the subscription ID exists in the VssSubscriptionDetails table
//        List<VssSubscriptionDetails> subscriptionDetails = subscriptionDetailRepository.findBySubscriptionId(subscriptionId);
//
//        if (!subscriptionDetails.isEmpty()) {
//            return "Subscription related to company can't delete";
//        }
//
//        // If the subscription is not associated with any company, then delete it
//        return subscriptionServiceimpl.deleteSubscription(uuid, vssSubscription);
//    }




    @PutMapping("subscription/updateSubscription/{uuid}")/*This APi is for Update Subscription by uuid */
    public String updateSubscriptionByUuid(@PathVariable String uuid ,  @Valid @RequestBody VssSubscription vssSubscription){
        LOGGER.info("SubScriptionController: UpdateSubscription is started");
        return subscriptionServiceimpl.updateSubscriptionByUuid(uuid,vssSubscription);
    }
}

package com.vhyom.saas.controller;

import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.service.impl.SubscriptionServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/subScription")
@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionServiceImpl subscriptionServiceimpl;

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
}

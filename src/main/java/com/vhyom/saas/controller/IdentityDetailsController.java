package com.vhyom.saas.controller;

import com.vhyom.saas.dto.IdentityDetailsDto;
import com.vhyom.saas.entity.VseIdentityDetail;
import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.service.IdentityDetailsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/identityDetails")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
public class IdentityDetailsController {


    @Autowired
    private IdentityDetailsService identityDetailsService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/create/IdentityDetails")/*This API is for Creating Identity Details*/
    public String createIdentityDetails(@Valid @RequestBody VseIdentityDetail vseIdentityDetail , @RequestParam VshEmployee user){
        LOGGER.info("IdentityDetailsController | createIdentityDetails Started ");
        return identityDetailsService.createIdentityDetails(vseIdentityDetail ,user);
    }

    @GetMapping("/getAllIdentityDetails")/*This API is for Getting All  Identity Details*/
     public List<IdentityDetailsDto>getAllIdentityDetails(){
        LOGGER.info("IdentityDetailsController | getAllIdentityDetails Started ");
        return identityDetailsService.getAllIdentityDetails();
    }

    @GetMapping("/getIdentityDetailsByuuid/{uuid}")/*This API is for Get Identity Details By uuid*/
    public IdentityDetailsDto getIdentityDetailsByuuid(@PathVariable String uuid){
        LOGGER.info("IdentityDetailsController | getIdentityDetailsByuuid Started ");
        return identityDetailsService.getIdentityDetailsByuuid(uuid);
    }

    @PutMapping("/deleteIdentityDetails/{uuid}")/*This API is for Delete Identity Details by uuid*/
    public String deleteIdentityDetailsByuuid(@PathVariable String uuid, @RequestBody VseIdentityDetail vseIdentityDetail){
        LOGGER.info("IdentityDetailsController | deleteIdentityDetailsByuuid Started ");
        return identityDetailsService.deleteIdentityDetailsByuuid(uuid,vseIdentityDetail);
    }

    @PutMapping("/updateIdentityDetails/{uuid}")
    public String updateIdentityDetailsByuuid(@PathVariable String uuid, @Valid @RequestBody VseIdentityDetail vseIdentityDetail){
        LOGGER.info("IdentityDetailsController | updateIdentityDetailsByuuid Started ");
        return identityDetailsService.updateIdentityDetailsByuuid(uuid, vseIdentityDetail);
    }
}

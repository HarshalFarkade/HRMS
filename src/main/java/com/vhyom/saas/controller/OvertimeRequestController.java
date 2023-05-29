package com.vhyom.saas.controller;

import com.vhyom.saas.dto.OvertimeRequestDto;
import com.vhyom.saas.entity.VseOvertimeRequest;
import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.entity.VshOvertimeCategory;
import com.vhyom.saas.service.OvertimeRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/OvertimeRequest")
@CrossOrigin(originPatterns = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
public class OvertimeRequestController {
    @Autowired
    private OvertimeRequestService overtimeRequestService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @PostMapping("/create")
    public String createOvertimeRequest(@RequestBody VseOvertimeRequest vseOvertimeRequest,
                                        @RequestParam Integer employee,
                                        @RequestParam Integer category) {
        LOGGER.info("OvertimeRequestController: createOvertimeRequest is started");
        return overtimeRequestService.createOvertimeRequest(vseOvertimeRequest, employee, category);
    }

    @GetMapping("/getAllOvertimeRequest")
    public List<OvertimeRequestDto> getAllOvertimeRequest(){
        LOGGER.info("OvertimeRequestController: getAllOvertimeRequest is started");
        return overtimeRequestService.getAllOvertimeRequest();
    }
//
//    @GetMapping("/getOvertimeRequest/{uuid}")
//    public OvertimeRequestDto getAllOvertimeRequestByUuid(@PathVariable String uuid){
//        LOGGER.info("OvertimeRequestController: getOvertimeRequest is started");
//        return overtimeRequestService.getAllOvertimeRequestByUuid(uuid);
//    }
//
//    @PutMapping("/deleteOvertimeRequest/{uuid}")
//    public String deleteOvertimeRequestByUuid(@PathVariable String uuid,@RequestBody VseOvertimeRequest vseOvertimeRequest){
//        LOGGER.info("OvertimeRequestController: deleteOvertimeRequest is started");
//        return overtimeRequestService.deleteOvertimeRequestByUuid(uuid, vseOvertimeRequest);
//    }
//
//
//    @PutMapping("/updateOvertimeRequest/{uuid}")
//    public String updateOvertimeRequestByUuid(@PathVariable String uuid,@RequestBody VseOvertimeRequest vseOvertimeRequest,@RequestParam Integer category){
//        LOGGER.info("OvertimeRequestController: updateOvertimeRequest is started");
//        return overtimeRequestService.updateOvertimeRequestByUuid(uuid, vseOvertimeRequest, category);
//    }

}

package com.vhyom.saas.service;

import com.vhyom.saas.dto.OvertimeRequestDto;
import com.vhyom.saas.entity.VseOvertimeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OvertimeRequestService {

    String createOvertimeRequest(VseOvertimeRequest vseOvertimeRequest, Integer employee, Integer category);

//    List<OvertimeRequestDto> getAllOvertimeRequest();
//
//    OvertimeRequestDto getAllOvertimeRequestByUuid(String uuid);
//
//    String deleteOvertimeRequestByUuid(String uuid ,VseOvertimeRequest vseOvertimeRequest);
//
//    String updateOvertimeRequestByUuid(String uuid ,VseOvertimeRequest vseOvertimeRequest,Integer category);
}

package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.OvertimeRequestDto;
import com.vhyom.saas.entity.VseOvertimeRequest;
import com.vhyom.saas.repository.OvertimeRequestRepository;
import com.vhyom.saas.service.OvertimeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OvertimeRequestServiceImpl  implements OvertimeRequestService {
    @Autowired
    private OvertimeRequestRepository overtimeRequestRepository;
    @Override
    public String createOvertimeRequest(VseOvertimeRequest vseOvertimeRequest, Integer employee, Integer category) {
        this.overtimeRequestRepository.createOvertimeRequest(employee,category,vseOvertimeRequest.getFromDate(),vseOvertimeRequest.getToDate(),vseOvertimeRequest.getNotes(),vseOvertimeRequest.getCreatedBy());
        return "Create Overtime Request Successfully";
    }

    @Override
    public List<OvertimeRequestDto> getAllOvertimeRequest() {
        return overtimeRequestRepository.getAllOvertimeRequest();
    }

    @Override
    public OvertimeRequestDto getAllOvertimeRequestByUuid(String uuid) {
        OvertimeRequestDto overtime =overtimeRequestRepository.getAllOvertimeRequestByUuid(uuid);
        if (overtime==null){
            System.out.println("OverTimeRequest not found");
        }
        return overtime;
    }

    @Override
    public String deleteOvertimeRequestByUuid(String uuid ,VseOvertimeRequest vseOvertimeRequest) {
        this.overtimeRequestRepository.deleteOvertimeRequestByUuid(vseOvertimeRequest.getLastModifiedBy(), LocalDateTime.now(),false,uuid);
        return "Delete OvertimeRequest Successfully";
    }

    @Override
    public String updateOvertimeRequestByUuid(String uuid, VseOvertimeRequest vseOvertimeRequest, Integer category) {
        this.overtimeRequestRepository.updateOvertimeRequestByUuid(category,vseOvertimeRequest.getFromDate(),vseOvertimeRequest.getToDate(),vseOvertimeRequest.getNotes(),vseOvertimeRequest.getLastModifiedBy(),LocalDateTime.now(),uuid);
        return "Update OvertimeRequest Successfully";
    }
}

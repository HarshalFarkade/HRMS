package com.vhyom.saas.service.impl;

import com.vhyom.saas.dto.IdentityDetailsDto;
import com.vhyom.saas.entity.VseIdentityDetail;
import com.vhyom.saas.entity.VshEmployee;
import com.vhyom.saas.repository.IdentityDetailsRepository;
import com.vhyom.saas.service.IdentityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class IdentityDetailsServiceImpl implements IdentityDetailsService {

    @Autowired
    private IdentityDetailsRepository identityDetailsRepository ;


    @Override
    public String createIdentityDetails(VseIdentityDetail vseIdentityDetail , VshEmployee user) {
        this.identityDetailsRepository.createIdentityDetails(user.getId(),
                vseIdentityDetail.getPan(),
                vseIdentityDetail.getAadhaarNumber(),
                vseIdentityDetail.getEsicNumber(),
                vseIdentityDetail.getPassportNumber(),
                vseIdentityDetail.getPassportValidThru(),
                vseIdentityDetail.getVisaValidThru(),
                vseIdentityDetail.getDrivingLicenceNumber(),
                vseIdentityDetail.getDrivingLicenceValidThru(),
                vseIdentityDetail.getInsuranceName(),
                vseIdentityDetail.getInsuranceId(),
                vseIdentityDetail.getBankName(),
                vseIdentityDetail.getBankAccountNumber(),
                vseIdentityDetail.getBankIfscCode(),
                vseIdentityDetail.getCreatedBy());
        return "Created Successfully";
    }

    @Override
    public List<IdentityDetailsDto> getAllIdentityDetails() {
        return identityDetailsRepository.getAllIdentityDetails();
    }

    @Override
    public IdentityDetailsDto getIdentityDetailsByuuid(String uuid) {
        IdentityDetailsDto identityDetailsDto=identityDetailsRepository.getIdentityDetailsByuuid(uuid);
        if (identityDetailsDto==null){
              System.out.println("Identity Details is not Found");
        }
        return identityDetailsDto;
    }

    @Override
    public String deleteIdentityDetailsByuuid(String uuid, VseIdentityDetail vseIdentityDetail) {
        this.identityDetailsRepository.deleteIdentityDetailsByuuid(vseIdentityDetail.getLastModifiedBy(), LocalDateTime.now(),false,uuid);
        return "IdentityDetails Delete Successfully";
    }

    @Override
    public String updateIdentityDetailsByuuid(String uuid, VseIdentityDetail vseIdentityDetail) {
        this.identityDetailsRepository.updateIdentityDetailsByuuid(vseIdentityDetail.getEsicNumber(),
                vseIdentityDetail.getPassportNumber(),
                vseIdentityDetail.getPassportValidThru(),
                true,
                vseIdentityDetail.getVisaValidThru(),
                vseIdentityDetail.getDrivingLicenceValidThru(),
                vseIdentityDetail.getInsuranceName(),
                vseIdentityDetail.getInsuranceId(),
                vseIdentityDetail.getBankName(),
                vseIdentityDetail.getBankAccountNumber(),
                vseIdentityDetail.getBankIfscCode(),
                vseIdentityDetail.getLastModifiedBy(),
                LocalDateTime.now(),
                uuid);
        return "Identity Details Update Successfully";
    }
}

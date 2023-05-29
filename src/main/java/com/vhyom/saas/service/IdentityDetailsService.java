package com.vhyom.saas.service;

import com.vhyom.saas.dto.IdentityDetailsDto;
import com.vhyom.saas.entity.VseIdentityDetail;
import com.vhyom.saas.entity.VshEmployee;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface IdentityDetailsService {

    String createIdentityDetails(VseIdentityDetail vseIdentityDetail , VshEmployee user);

    List<IdentityDetailsDto>getAllIdentityDetails();

    IdentityDetailsDto getIdentityDetailsByuuid(String uuid);

    String deleteIdentityDetailsByuuid(String uuid,VseIdentityDetail vseIdentityDetail);

    String updateIdentityDetailsByuuid(String uuid,VseIdentityDetail vseIdentityDetail);
}

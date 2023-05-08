package com.vhyom.saas.repository;
import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface SubscriptionDetailsRepository extends JpaRepository<VssSubscriptionDetails ,Integer> {


    @Query("SELECT new com.vhyom.saas.dto.SubscriptionDetailsDto (subD.companyId.uuid, subD.companyId.name, subD.companyId.websiteUrl, subD.companyId.logo, subD.companyId.firstName, subD.companyId.lastName, subD.companyId.emailId, subD.companyId.phoneNumber, "
            + "subD.companyId.createdBy, subD.companyId.createdOn, subD.companyId.lastModifiedBy, subD.companyId.lastModifiedOn, subD.companyId.isActive, "
            + "subD.subscriptionId.planName, subD.subscriptionId.description, subD.subscriptionId.totalUsers,"
            + "subD.startDate, subD.endDate, subD.status) FROM VssSubscriptionDetails subD ")
    List<SubscriptionDetailsDto> getAllSubscriptionDetails();

    @Query("SELECT new com.vhyom.saas.dto.SubscriptionDetailsDto (subD.companyId.uuid, subD.companyId.name, subD.companyId.websiteUrl, subD.companyId.logo, subD.companyId.firstName, subD.companyId.lastName, subD.companyId.emailId, subD.companyId.phoneNumber, "
            + "subD.companyId.createdBy, subD.companyId.createdOn, subD.companyId.lastModifiedBy, subD.companyId.lastModifiedOn, subD.companyId.isActive, "
            + "subD.subscriptionId.planName, subD.subscriptionId.description, subD.subscriptionId.totalUsers,"
            + "subD.startDate, subD.endDate, subD.status) FROM VssSubscriptionDetails subD WHERE subD.uuid=?1")
    List<SubscriptionDetailsDto>getSubscriptionDetailsByUuid(String uuid);





}





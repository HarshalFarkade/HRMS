package com.vhyom.saas.repository;
import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public interface SubscriptionDetailsRepository extends JpaRepository<VssSubscriptionDetails ,Integer> {


    @Transactional
    @Modifying
    @Query("INSERT INTO VssSubscriptionDetails (companyId, subscriptionId, startDate, endDate, status, createdBy, isActive) " +
            "SELECT com, sub, :startDate, :endDate, :status, :createdBy, :isActive " +
            "FROM VssCompany com, VssSubscription sub " +
            "WHERE com.id = :companyIdId AND sub.id = :subscriptionIdId")
    void createSubscriptionDetails(@Param("companyIdId") Integer companyIdId,
                                   @Param("subscriptionIdId") Integer subscriptionIdId,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   @Param("status") int status,
                                   @Param("createdBy") int createdBy,
                                   @Param("isActive") boolean isActive);

    boolean existsByCompanyId(VssCompany value);
    boolean existsBySubscriptionId(VssSubscription subscription);




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


    @Transactional
    @Modifying
    @Query(value ="UPDATE VssSubscriptionDetails subD SET subD.lastModifiedOn=:lastModifiedOn,subD.lastModifiedBy=:lastModifiedBy,subD.isActive=:isActive Where subD.uuid=:uuid")
    void deleteSubscriptionDetailsBYUuid(
                                @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                                @Param("lastModifiedBy") Integer lastModifiedBy,
                                @Param("isActive") boolean isActive,
                                @Param("uuid")String uuid);


    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM VssSubscriptionDetails s WHERE s.companyId.id = :value")
    boolean existsByCompanyId(Integer value);




}





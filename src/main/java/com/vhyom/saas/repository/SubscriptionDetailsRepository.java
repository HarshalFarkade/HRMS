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

@Repository
public interface SubscriptionDetailsRepository extends JpaRepository<VssSubscriptionDetails ,Integer> {


    @Transactional
    @Modifying
    @Query("INSERT INTO VssSubscriptionDetails (companyId, subscriptionId, startDate, endDate, status, createdBy) " +
            "SELECT com, sub, :startDate, :endDate, :status, :createdBy " +
            "FROM VssCompany com, VssSubscription sub " +
            "WHERE com.id = :companyId AND sub.id = :subscriptionId")
    void createSubscriptionDetails(@Param("companyId") Integer companyIdId,
                                   @Param("subscriptionId") Integer subscriptionIdId,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   @Param("status") int status,
                                   @Param("createdBy") int createdBy);

    boolean existsByCompanyId(VssCompany value);
    boolean existsBySubscriptionId(VssSubscription subscription);



    @Query("SELECT new com.vhyom.saas.dto.SubscriptionDetailsDto(sd.uuid AS uuid, c.name AS name, c.websiteUrl AS websiteUrl, c.logo AS logo, " +
            "c.firstName AS firstName, c.lastName AS lastName, c.emailId AS emailId, c.phoneNumber AS phoneNumber, " +
            "c.createdBy AS createdBy, c.createdOn AS createdOn, c.lastModifiedBy AS lastModifiedBy, " +
            "c.lastModifiedOn AS lastModifiedOn, c.isActive AS isActive, s.planName AS planName, " +
            "s.description AS description, (SELECT CAST(SUM(s.totalUsers) AS INTEGER) FROM VssSubscription s) AS totalUsers, " +
            "(SELECT CAST(SUM(s.totalUsers) AS INTEGER) FROM VssSubscription s WHERE s.isActive = true) AS totalActiveUsers, " +
            "sd.startDate AS startDate, sd.endDate AS endDate, sd.status AS status) " +
            "FROM VssCompany c " +
            "JOIN VssSubscriptionDetails sd ON c.id = sd.companyId " +
            "JOIN VssSubscription s ON sd.subscriptionId = s.id")
    List<SubscriptionDetailsDto> getAllSubscriptionDetails();

    @Query("SELECT new com.vhyom.saas.dto.SubscriptionDetailsDto (subD.uuid , subD.companyId.name, subD.companyId.websiteUrl, subD.companyId.logo, subD.companyId.firstName, subD.companyId.lastName, subD.companyId.emailId, subD.companyId.phoneNumber, "
            + "subD.companyId.createdBy, subD.companyId.createdOn, subD.companyId.lastModifiedBy, subD.companyId.lastModifiedOn, subD.companyId.isActive, "
            + "subD.subscriptionId.planName, subD.subscriptionId.description, subD.subscriptionId.totalUsers,"+
           "(SELECT SUM(sub.totalUsers) FROM VssSubscription sub WHERE sub.isActive = true) AS totalActiveUsers, "
            + "subD.startDate, subD.endDate, subD.status) FROM VssSubscriptionDetails subD WHERE subD.uuid=?1")
    SubscriptionDetailsDto getSubscriptionDetailsByUuid(String uuid);


    @Transactional
    @Modifying
    @Query(value ="UPDATE VssSubscriptionDetails subD SET subD.lastModifiedOn=:lastModifiedOn,subD.lastModifiedBy=:lastModifiedBy,subD.isActive=:isActive Where subD.uuid=:uuid")
    void deleteSubscriptionDetailsBYUuid(
                                @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                                @Param("lastModifiedBy") Integer lastModifiedBy,
                                @Param("isActive") boolean isActive,
                                @Param("uuid")String uuid);


    @Transactional
    @Modifying
    @Query(value = "UPDATE VssSubscriptionDetails subD SET subD.companyId=:companyId,subD.subscriptionId=:subscriptionId,subD.startDate=:startDate,subD.endDate=:endDate,subD.status=:status,subD.lastModifiedBy=:lastModifiedBy,subD.lastModifiedOn=:lastModifiedOn Where subD.uuid=:uuid")
    void updateSubscriptionDetails(@Param("companyId") VssCompany companyId,
                                   @Param("subscriptionId") VssSubscription subscriptionId,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   @Param("status") int status,
                                   @Param("lastModifiedBy") Integer lastModifiedBy,
                                   @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                                   @Param("uuid") String uuid);




    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM VssSubscriptionDetails s WHERE s.companyId.id = :value")
    boolean existsByCompanyId(Integer value);


    VssSubscription findByUuid(String uuid);

    @Query("SELECT sd FROM VssSubscriptionDetails sd WHERE sd.subscriptionId = :subscriptionId")
    List<VssSubscriptionDetails> findBySubscriptionId(@Param("subscriptionId") Integer subscriptionId);

}





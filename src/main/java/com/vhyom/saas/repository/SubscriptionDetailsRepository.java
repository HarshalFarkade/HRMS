package com.vhyom.saas.repository;

import com.vhyom.saas.dto.SubscriptionDetailsDto;
import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import com.vhyom.saas.entity.VssSubscriptionDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface SubscriptionDetailsRepository extends JpaRepository<VssSubscriptionDetail,Integer> {

    @Transactional
    @Modifying
    @Query("INSERT INTO VssSubscriptionDetail (companyId, subscriptionId, startDate, endDate, status, createdBy) " +
            "SELECT com, sub, :startDate, :endDate, :status, :createdBy " +
            "FROM VssCompany com, VssSubscription sub " +
            "WHERE com.id = :companyId AND sub.id = :subscriptionId")
    void createSubscriptionDetails(@Param("companyId") Integer companyIdId,
                                   @Param("subscriptionId") Integer subscriptionIdId,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   @Param("status") int status,
                                   @Param("createdBy") int createdBy);

@Query("SELECT new com.vhyom.saas.dto.SubscriptionDetailsDto(sd.uuid AS uuid, c.name AS name, c.websiteUrl AS websiteUrl, c.logo AS logo, " +
        "c.firstName AS firstName, c.lastName AS lastName, c.emailId AS emailId, c.phoneNumber AS phoneNumber, " +
        "sd.createdBy AS createdBy, sd.createdOn AS createdOn, sd.lastModifiedBy AS lastModifiedBy, " +
        "sd.lastModifiedOn AS lastModifiedOn, sd.isActive AS isActive, s.planName AS planName, " +
        "s.description AS description, " +
        "(SELECT CAST(COUNT(su) AS INTEGER) FROM VssSubscription su WHERE su.planName = s.planName) AS totalUsers, " +
        "(SELECT CAST(COUNT(su) AS INTEGER) FROM VssSubscription su WHERE su.planName = s.planName AND su.isActive = true) AS totalActiveUsers, " +
        "sd.startDate AS startDate, sd.endDate AS endDate, sd.status AS status) " +
        "FROM VssCompany c " +
        "JOIN VssSubscriptionDetail sd ON c.id = sd.companyId " +
        "JOIN VssSubscription s ON sd.subscriptionId = s.id")
List<SubscriptionDetailsDto> getAllSubscriptionDetails();

    @Query("SELECT new com.vhyom.saas.dto.SubscriptionDetailsDto(sd.uuid AS uuid, c.name AS name, c.websiteUrl AS websiteUrl, c.logo AS logo, " +
            "c.firstName AS firstName, c.lastName AS lastName, c.emailId AS emailId, c.phoneNumber AS phoneNumber, " +
            "sd.createdBy AS createdBy, sd.createdOn AS createdOn, sd.lastModifiedBy AS lastModifiedBy, " +
            "sd.lastModifiedOn AS lastModifiedOn, sd.isActive AS isActive, s.planName AS planName, " +
            "s.description AS description,"+
            "(SELECT CAST(COUNT(su) AS INTEGER) FROM VssSubscription su WHERE su.planName = s.planName) AS totalUsers, " +
            "(SELECT CAST(COUNT(su) AS INTEGER) FROM VssSubscription su WHERE su.planName = s.planName AND su.isActive = true) AS totalActiveUsers, " +
            "sd.startDate AS startDate, sd.endDate AS endDate, sd.status AS status) " +
            "FROM VssCompany c " +
            "JOIN VssSubscriptionDetail sd ON c.id = sd.companyId " +
            "JOIN VssSubscription s ON sd.subscriptionId = s.id " +
            "WHERE sd.uuid = ?1")
    SubscriptionDetailsDto getSubscriptionDetailsByUuid(String uuid);


    @Transactional
    @Modifying
    @Query(value ="UPDATE VssSubscriptionDetail subD SET subD.lastModifiedOn=:lastModifiedOn,subD.lastModifiedBy=:lastModifiedBy,subD.isActive=:isActive Where subD.uuid=:uuid")
    void deleteSubscriptionDetailsBYUuid(
                                @Param("lastModifiedOn") Date lastModifiedOn,
                                @Param("lastModifiedBy") Integer lastModifiedBy,
                                @Param("isActive") boolean isActive,
                                @Param("uuid")String uuid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE VssSubscriptionDetail subD SET subD.companyId=:companyId,subD.subscriptionId=:subscriptionId,subD.startDate=:startDate,subD.endDate=:endDate,subD.status=:status,subD.lastModifiedBy=:lastModifiedBy,subD.lastModifiedOn=:lastModifiedOn Where subD.uuid=:uuid")
    void updateSubscriptionDetails(@Param("companyId")VssCompany companyId,
                                   @Param("subscriptionId") VssSubscription subscriptionId,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   @Param("status") int status,
                                   @Param("lastModifiedBy") Integer lastModifiedBy,
                                   @Param("lastModifiedOn") Date lastModifiedOn,
                                   @Param("uuid") String uuid);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM VssSubscriptionDetail s WHERE s.companyId.id = :value")
    boolean existsByCompanyId(Integer value);

    boolean existsByCompanyIdAndSubscriptionId(VssCompany company, VssSubscription subscription);

    VssSubscriptionDetail findByUuid(String uuid);
}





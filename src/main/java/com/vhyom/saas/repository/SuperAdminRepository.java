package com.vhyom.saas.repository;

import com.vhyom.saas.dto.DashboardDto;
import com.vhyom.saas.dto.VssSuperAdmindto;
import com.vhyom.saas.entity.VssSuperAdmin;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface SuperAdminRepository extends JpaRepository<VssSuperAdmin, Integer> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VssSuperAdmin(emailId,password,profilePhoto,firstName,lastName,mobileNumber,phoneNumber,createdBy)VALUES(:emailId,:password,:profilePhoto,:firstName,:lastName,:mobileNumber,:phoneNumber,:createdBy)")
    void createSuperAdmin(@Param("emailId")String emailID,
                          @Param("password")String password,
                          @Param("profilePhoto")String profilePhoto,
                          @Param("firstName")String firstName,
                          @Param("lastName")String lastName,
                          @Param("mobileNumber")String mobileNumber,
                          @Param("phoneNumber")String phoneNumber,
                          @Param("createdBy")Integer createdBy);

  @Query("Select  new com.vhyom.saas.dto.VssSuperAdmindto (sup.uuid,sup.emailId,sup.profilePhoto,sup.firstName,sup.lastName,sup.mobileNumber,sup.phoneNumber,sup.isActive,sup.createdOn,sup.createdBy,sup.lastModifiedOn,sup.lastModifiedBy) From VssSuperAdmin sup")
  List<VssSuperAdmindto>getAllsuperAdmin();

  @Query("Select new com.vhyom.saas.dto.VssSuperAdmindto (sup.uuid,sup.emailId,sup.profilePhoto,sup.firstName,sup.lastName,sup.mobileNumber,sup.phoneNumber,sup.isActive,sup.createdOn,sup.createdBy,sup.lastModifiedOn,sup.lastModifiedBy) From VssSuperAdmin sup where sup.uuid=?1")
  VssSuperAdmindto getSuperAdminByUuid(String uuid);

 @Transactional
 @Modifying
  @Query(value ="UPDATE VssSuperAdmin sup SET sup.isActive=:isActive,sup.lastModifiedOn=:lastModifiedOn,sup.lastModifiedBy=:lastModifiedBy Where sup.uuid=:uuid")
   void deletesuperAdminByuuid(@Param("isActive") boolean isActive,
                               @Param("lastModifiedOn")Date lastModifiedOn,
                               @Param("lastModifiedBy") Integer lastModifiedBy,
                               @Param("uuid")String uuid);
  @Transactional
  @Modifying
  @Query(value = "UPDATE VssSuperAdmin sup SET sup.password=:password,sup.profilePhoto=:profilePhoto,sup.firstName=:firstName,sup.lastName=:lastName,sup.mobileNumber=:mobileNumber,sup.phoneNumber=:phoneNumber,sup.lastModifiedBy=:lastModifiedBy ,sup.lastModifiedOn=:lastModifiedOn Where sup.uuid=:uuid")
  void updateSuperAdminByuuid(@Param("password") String password,
                              @Param("profilePhoto") String profilePhoto,
                              @Param("firstName")String firstName,
                              @Param("lastName") String lastName,
                              @Param("mobileNumber") String mobileNumber,
                              @Param("phoneNumber")String phoneNumber,
                              @Param("lastModifiedBy")Integer lastModifiedBy,
                              @Param("lastModifiedOn") Date lastModifiedOn,
                              @Param("uuid") String uuid);

  VssSuperAdmin getSuperAdminByEmailId(String emailID);


    @Query("SELECT new com.vhyom.saas.dto.DashboardDto(" +
            "COUNT(c.uuid), " +
            "COUNT(CASE WHEN c.isActive = true THEN 1 ELSE NULL END), " +
            "(SELECT COUNT(s) FROM VssSubscriptionDetail s ), " +
            "(SELECT COUNT(s) FROM VssSubscriptionDetail s Where s.isActive = true), " +
            "(SELECT SUM( s.totalUsers) FROM VssSubscription s), " +
            "(SELECT SUM( s.totalUsers) FROM VssSubscription s  WHERE s.isActive = true) " +
            ")FROM VssCompany c " )
    List<DashboardDto> getDashboardData();

}

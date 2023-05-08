package com.vhyom.saas.repository;

import com.vhyom.saas.entity.VssSuperAdmin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SuperAdminRepository extends JpaRepository<VssSuperAdmin, Integer> {
  @Query("Select sup.uuid,sup.emailId,sup.profilePhoto,sup.firstName,sup.lastName,sup.mobileNumber,sup.phoneNumber,sup.isActive,sup.createdOn,sup.createdBy,sup.lastModifiedOn,sup.lastModifiedBy From VssSuperAdmin sup")
  List<Object[]>getAllsuperAdminBySortedFirstNameAsc(Sort by);

  @Query("Select sup.uuid,sup.emailId,sup.profilePhoto,sup.firstName,sup.lastName,sup.mobileNumber,sup.phoneNumber,sup.isActive,sup.createdOn,sup.createdBy,sup.lastModifiedOn,sup.lastModifiedBy From VssSuperAdmin sup where sup.uuid=?1")
  List<Object[]>getAllsuperAdminByUuid(Sort by,String uuid);

 @Transactional
 @Modifying
  @Query(value ="UPDATE VssSuperAdmin sup SET sup.isActive=:isActive,sup.lastModifiedOn=:lastModifiedOn,sup.lastModifiedBy=:lastModifiedBy Where sup.uuid=:uuid")
   void deletesuperAdminByuuid(@Param("isActive") boolean isActive,
                               @Param("lastModifiedOn")LocalDateTime lastModifiedOn,
                               @Param("lastModifiedBy") Integer lastModifiedBy,
                               @Param("uuid")String uuid);
  @Transactional
  @Modifying
  @Query(value = "UPDATE VssSuperAdmin sup SET sup.password=:password,sup.profilePhoto=:profilePhoto,sup.firstName=:firstName,sup.lastName=:lastName,sup.mobileNumber=:mobileNumber,sup.phoneNumber=:phoneNumber,sup.lastModifiedOn=:lastModifiedOn,sup.lastModifiedBy=:lastModifiedBy Where sup.uuid=:uuid")
  void updateSuperAdminByuuid(@Param("password") String password,
                              @Param("profilePhoto") String profilePhoto,
                              @Param("firstName")String firstName,
                              @Param("lastName") String lastName,
                              @Param("mobileNumber") String mobileNumber,
                              @Param("phoneNumber")String phoneNumber,
                              @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                              @Param("lastModifiedBy")Integer lastModifiedBy,
                              @Param("uuid") String uuid);

  VssSuperAdmin getSuperAdminByEmailId(String emailID);


}

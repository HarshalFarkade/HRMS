package com.vhyom.saas.repository;

import com.vhyom.saas.entity.VssSuperAdmin;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperAdminRepository extends JpaRepository<VssSuperAdmin, Integer> {
 // @Query("Select sup.uuid,sup.emailId,sup.profilePhoto,sup.firstName,sup.lastName,sup.mobileNumber,sup.phoneNumber,sup.isActive,sup.createdOn,sup.createdBy,sup.lastModifiedOn,sup.lastModifiedBy From VssSuperAdmin sup")
 // List<Object[]>getAllsuperAdminBySortedFirstNameAsc(Sort by);

}

package com.vhyom.saas.repository;

import com.vhyom.saas.entity.VssCompany;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Repository
public interface CompanyRepository extends JpaRepository<VssCompany , Integer>{

    boolean existsByName(String value);

    @Query("select com.id,com.name,com.websiteUrl,com.logo,com.firstName,com.lastName,com.phoneNumber,com.createdOn,com.createdBy,com.lastModifiedOn,com.lastModifiedBy From VssCompany com Where com.isActive = true")
    List<Object[]>findAllcompany(Boolean aTrue);

    @Query("select com.id,com.name,com.websiteUrl,com.logo,com.firstName,com.lastName,com.phoneNumber,com.createdOn,com.createdBy,com.lastModifiedOn,com.lastModifiedBy From VssCompany com Where com.uuid=?1")
    List<Object[]> getCompanyByUuid(String uuid);

    @Transactional
    @Modifying
    @Query(value="UPDATE VssCompany com SET com.lastModifiedBy=:lastModifiedBy, com.lastModifiedOn=:lastModifiedOn, com.isActive=:isActive where com.uuid=:uuid")
    void deleteCompanyByUuid(
            @Param("lastModifiedBy") Integer lastModifiedBy,
            @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
            @Param("isActive") boolean isActive,
            @Param("uuid") String uuid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE VssCompany com SET com.name=:name,com.websiteUrl=:websiteUrl,com.logo=:logo,com.firstName=:firstName,com.lastName=:lastName,com.phoneNumber=:phoneNumber,com.lastModifiedOn=:lastModifiedOn,com.lastModifiedBy=:lastModifiedBy where com.uuid=:uuid")
    void updateCompanyByUuid(@Param("name")String name,
                             @Param("websiteUrl")String websiteUrl,
                             @Param("logo") String logo,
                             @Param("firstName")String firstName,
                             @Param("lastName")String lastName,
                             @Param("phoneNumber")String phoneNumber,
                             @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
                             @Param("lastModifiedBy") Integer lastModifiedBy,
                             @Param("uuid") String uuid);



}

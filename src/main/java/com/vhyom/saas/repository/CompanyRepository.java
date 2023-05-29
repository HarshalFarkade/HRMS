package com.vhyom.saas.repository;

import com.vhyom.saas.dto.VssCompanydto;
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
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VssCompany (name,websiteUrl,logo,firstName,lastName,emailId,phoneNumber,createdBy) VALUES(:name,:websiteUrl,:logo,:firstName,:lastName,:emailId,:phoneNumber,:createdBy)")
    void createCompany(@Param("name")String name,
                       @Param("websiteUrl")String websiteUrl,
                       @Param("logo")String logo,
                       @Param("firstName")String firstName,
                       @Param("lastName")String lastName,
                       @Param("emailId")String emailId,
                       @Param("phoneNumber") String phoneNumber,
                       @Param("createdBy")Integer createdBy);

    boolean existsByName(String value);

    @Query("select  new com.vhyom.saas.dto.VssCompanydto(com.id,com.uuid,com.name,com.websiteUrl,com.logo,com.firstName,com.lastName,com.emailId,com.phoneNumber,com.createdBy,com.createdOn,com.lastModifiedBy,com.lastModifiedOn,com.isActive) From VssCompany  com ")
    List<VssCompanydto> findAllcompany();

    @Query("select  new com.vhyom.saas.dto.VssCompanydto(com.id,com.uuid,com.name,com.websiteUrl,com.logo,com.firstName,com.lastName,com.emailId,com.phoneNumber,com.createdBy,com.createdOn,com.lastModifiedBy,com.lastModifiedOn,com.isActive) From VssCompany  com Where com.uuid=?1")
    VssCompanydto getCompanyByUuid(String uuid);

    @Transactional
    @Modifying
    @Query(value="UPDATE VssCompany com SET com.lastModifiedBy=:lastModifiedBy, com.lastModifiedOn=:lastModifiedOn, com.isActive=:isActive where com.uuid=:uuid")
    void deleteCompanyByUuid(
            @Param("lastModifiedBy") Integer lastModifiedBy,
            @Param("lastModifiedOn") Date lastModifiedOn,
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
                             @Param("lastModifiedOn") Date lastModifiedOn,
                             @Param("lastModifiedBy") Integer lastModifiedBy,
                             @Param("uuid") String uuid);



}

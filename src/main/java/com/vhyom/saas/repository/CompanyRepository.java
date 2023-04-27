package com.vhyom.saas.repository;

import com.vhyom.saas.entity.VssCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<VssCompany , Integer>{


    @Query(value="INSERT INTO VssCompany (name, website_url, logo, first_name, last_name, phone_number, createdOn,created_by) " +
            "VALUES ( :name, :websiteUrl, :logo, :firstName, :lastName, :phoneNumber,:createdOn, :createdBy)", nativeQuery = true)
    String createCompany(@Param("name")String name,
                         @Param("websiteUrl")String websiteUrl,
                         @Param("logo") String logo,
                         @Param("firstName")String firstName,
                         @Param("lastName")String lastName,
                         @Param("phoneNumber")String phoneNumber,
                         @Param("createdOn")Date createdOn,
                         @Param("createdBy") int createdBy);
    VssCompany findByName(String name);

    @Query("select com.id,com.name,com.websiteUrl,com.logo,com.firstName,com.lastName,com.phoneNumber,com.createdOn,com.createdBy,com.lastModifiedOn,com.lastModifiedBy From VssCompany com Where com.isActive = true")
    List<Object[]>findAllcompany(Boolean aTrue);
    @Query("select com.id,com.name,com.websiteUrl,com.logo,com.firstName,com.lastName,com.phoneNumber,com.createdOn,com.createdBy,com.lastModifiedOn,com.lastModifiedBy From VssCompany com Where com.uuid=?1")
    List<Object[]> getCompanyByUuid(String uuid);




}

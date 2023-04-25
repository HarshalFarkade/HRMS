package com.vhyom.saas.Repository;

import com.vhyom.saas.entity.VssCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

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



}

package com.vhyom.saas.repository;

import com.vhyom.saas.dto.ClientDto;
import com.vhyom.saas.entity.VseClient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<VseClient,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VseClient (clientId,company,shortCode,websiteUrl,logo,gstin,pan,firstName,lastName,emailId,mobileNumber,phoneNumber,createdBy,isActive)"+
    "VALUES (:clientId,:company,:shortCode,:websiteUrl,:logo,:gstin,:pan,:firstName,:lastName,:emailId,:mobileNumber,:phoneNumber,:createdBy,:isActive)")
    void createClient(@Param("clientId")String clientId,
                      @Param("company")String company,
                      @Param("shortCode")String shortCode,
                      @Param("websiteUrl")String websiteUrl,
                      @Param("logo")String logo,
                      @Param("gstin")String gstin,
                      @Param("pan")String pan,
                      @Param("firstName")String firstName,
                      @Param("lastName")String lastName,
                      @Param("emailId")String emailId,
                      @Param("mobileNumber")String mobileNumber,
                      @Param("phoneNumber")String phoneNumber,
                      @Param("createdBy")Integer createdBy,
                      @Param("isActive")boolean isActive);


    @Query("select new com.vhyom.saas.dto.ClientDto(cli.uuid,cli.clientId,cli.company,cli.shortCode,cli.websiteUrl,cli.logo,cli.gstin,cli.pan,cli.firstName,cli.lastName,cli.emailId,cli.mobileNumber,cli.phoneNumber,cli.createdBy,cli.createdOn,cli.lastModifiedBy,cli.lastModifiedOn,cli.isActive) From VseClient cli")
    List<ClientDto> getAllClient();

//    @Query("select new com.vhyom.saas.dto.ClientDto(cli.uuid,cli.clientId,cli.company,cli.shortCode,cli.websiteUrl,cli.logo,cli.gstin,cli.pan,cli.firstName,cli.lastName,cli.emailId,cli.mobileNumber,cli.phoneNumber,cli.createdBy,cli.createdOn,cli.lastModifiedBy,cli.lastModifiedOn,cli.isActive) From VseClient cli Where cli.uuid=?1")
//    ClientDto getClientByUuid(String uuid);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VseClient cli SET cli.lastModifiedBy=:lastModifiedBy, cli.lastModifiedOn=:lastModifiedOn, cli.isActive=:isActive Where cli.uuid=:uuid")
//    void deleteClientByUuid(@Param("lastModifiedBy")Integer lastModifiedBy,
//                            @Param("lastModifiedOn")LocalDateTime lastModifiedOn,
//                            @Param("isActive")boolean isActive,
//                            @Param("uuid")String uuid);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VseClient cli SET cli.company=:company, cli.shortCode=:shortCode, cli.websiteUrl=:websiteUrl, cli.logo=:logo, cli.firstName=:firstName, cli.lastName=:lastName, cli.emailId=:emailId,cli.mobileNumber=:mobileNumber,cli.phoneNumber=:phoneNumber,cli.lastModifiedBy=:lastModifiedBy,cli.lastModifiedOn=:lastModifiedOn Where cli.uuid=:uuid")
//    void updateClientByUuid(@Param("company")String company,
//                      @Param("shortCode")String shortCode,
//                      @Param("websiteUrl")String websiteUrl,
//                      @Param("logo")String logo,
//                      @Param("firstName")String firstName,
//                      @Param("lastName")String lastName ,
//                      @Param("emailId")String emailId,
//                      @Param("mobileNumber")String mobileNumber,
//                      @Param("phoneNumber") String phoneNumber,
//                      @Param("lastModifiedBy")Integer lastModifiedBy,
//                      @Param("lastModifiedOn") LocalDateTime lastModifiedOn,
//                      @Param("uuid")String uuid);

}

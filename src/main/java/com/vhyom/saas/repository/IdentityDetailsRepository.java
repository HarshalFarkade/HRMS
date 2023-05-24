package com.vhyom.saas.repository;

import com.vhyom.saas.dto.IdentityDetailsDto;
import com.vhyom.saas.entity.VseIdentityDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Repository
public interface IdentityDetailsRepository extends JpaRepository<VseIdentityDetail,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VseIdentityDetail(user, pan, aadhaarNumber, esicNumber, passportNumber, passportValidThru,  visaValidThru, drivingLicenceNumber, drivingLicenceValidThru, insuranceName, insuranceId, bankName, bankAccountNumber, bankIfscCode, createdBy) " +
            "SELECT emp, :pan, :aadhaarNumber, :esicNumber, :passportNumber, :passportValidThru,  :visaValidThru, :drivingLicenceNumber, :drivingLicenceValidThru, :insuranceName, :insuranceId, :bankName, :bankAccountNumber, :bankIfscCode, :createdBy " +
            "FROM VshEmployee emp " +
            "WHERE emp.id = :user")
    void createIdentityDetails(@Param("user") Integer user,
                               @Param("pan")String pan,
                               @Param("aadhaarNumber")String aadhaarNumber,
                               @Param("esicNumber")String esicNumber,
                               @Param("passportNumber")String passportNumber,
                               @Param("passportValidThru")LocalDate passportValidThru,
                               //@Param("visaStatus")Boolean visaStatus,
                               @Param("visaValidThru")LocalDate visaValidThru,
                               @Param("drivingLicenceNumber")String drivingLicenceNumber,
                               @Param("drivingLicenceValidThru") LocalDate drivingLicenceValidThru,
                               @Param("insuranceName")String insuranceName,
                               @Param("insuranceId")String insuranceId,
                               @Param("bankName")String bankName,
                               @Param("bankAccountNumber")String bankAccountNumber,
                               @Param("bankIfscCode")String bankIfscCode,
                               @Param("createdBy")Integer  createdBy);

    @Query("SELECT new com.vhyom.saas.dto.IdentityDetailsDto(Ind.uuid,Ind.user.id,Ind.pan,Ind.aadhaarNumber,Ind.esicNumber,Ind.passportNumber,Ind.passportValidThru,Ind.visaValidThru,"+
    "Ind.drivingLicenceNumber,Ind.drivingLicenceValidThru,Ind.insuranceName,Ind.insuranceId,Ind.bankName,Ind.bankAccountNumber,Ind.bankIfscCode,Ind.createdBy,Ind.createdOn,Ind.lastModifiedBy,Ind.lastModifiedOn,Ind.isActive) FROM VseIdentityDetail Ind")
    List<IdentityDetailsDto> getAllIdentityDetails();

    @Query("SELECT new com.vhyom.saas.dto.IdentityDetailsDto(Ind.uuid,Ind.user.id,Ind.pan,Ind.aadhaarNumber,Ind.esicNumber,Ind.passportNumber,Ind.passportValidThru,Ind.visaValidThru,"+
            "Ind.drivingLicenceNumber,Ind.drivingLicenceValidThru,Ind.insuranceName,Ind.insuranceId,Ind.bankName,Ind.bankAccountNumber,Ind.bankIfscCode,Ind.createdBy,Ind.createdOn,Ind.lastModifiedBy,Ind.lastModifiedOn,Ind.isActive) FROM VseIdentityDetail Ind WHERE Ind.uuid=?1")
    IdentityDetailsDto getIdentityDetailsByuuid(String uuid);

    @Transactional
    @Modifying
    @Query(value ="UPDATE VseIdentityDetail Ind SET Ind.lastModifiedBy=:lastModifiedBy,Ind.lastModifiedOn=:lastModifiedOn,Ind.isActive=:isActive WHERE Ind.uuid=:uuid")
    void deleteIdentityDetailsByuuid(@Param("lastModifiedBy")Integer lastModifiedBy,
                                     @Param("lastModifiedOn")LocalDateTime lastModifiedOn,
                                     @Param("isActive") boolean isActive,
                                     @Param("uuid")String uuid);


    @Transactional
    @Modifying
    @Query(value = "UPDATE VseIdentityDetail Ind SET Ind.esicNumber=:esicNumber,Ind.passportNumber=:passportNumber,Ind.passportValidThru=:passportValidThru," +
            "Ind.visaStatus=:visaStatus,Ind.visaValidThru=:visaValidThru,Ind.drivingLicenceValidThru=:drivingLicenceValidThru,Ind.insuranceName=:insuranceName," +
            "Ind.insuranceId=:insuranceId,Ind.bankName=:bankName,Ind.bankAccountNumber=:bankAccountNumber,Ind.bankIfscCode=:bankIfscCode,Ind.lastModifiedBy=:lastModifiedBy,Ind.lastModifiedOn=:lastModifiedOn WHERE Ind.uuid=:uuid")
    void updateIdentityDetailsByuuid(@Param("esicNumber")String esicNumber,
                                     @Param("passportNumber")String passportNumber,
                                     @Param("passportValidThru") LocalDate  passportValidThru,
                                     @Param("visaStatus")boolean visaStatus,
                                     @Param("visaValidThru")LocalDate visaValidThru,
                                     @Param("drivingLicenceValidThru")LocalDate drivingLicenceValidThru,
                                     @Param("insuranceName")String insuranceName,
                                     @Param("insuranceId")String insuranceId,
                                     @Param("bankName")String bankName,
                                     @Param("bankAccountNumber")String bankAccountNumber,
                                     @Param("bankIfscCode")String bankIfscCode,
                                     @Param("lastModifiedBy") Integer lastModifiedBy,
                                     @Param("lastModifiedOn")LocalDateTime lastModifiedOn,
                                     @Param("uuid")String uuid);
    

    boolean existsByAadhaarNumber(String value);

    boolean existsByEsicNumber(String value);

    boolean existsByBankAccountNumber(String value);
}

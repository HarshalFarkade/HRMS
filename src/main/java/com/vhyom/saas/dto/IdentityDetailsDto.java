package com.vhyom.saas.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class IdentityDetailsDto {
    private String uuid;
    private Integer user;
    private String pan;
    private String aadhaarNumber;
    private String esicNumber;
    private String passportNumber;
    private LocalDate passportValidThru;
    private LocalDate visaValidThru;
    private String drivingLicenceNumber;
    private LocalDate drivingLicenceValidThru;
    private String insuranceName;
    private String insuranceId;
    private String bankName;
    private String bankAccountNumber;
    private String bankIfscCode;
    private Integer createdBy;
    private LocalDateTime createdOn;
    private Integer lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private Boolean isActive ;

}

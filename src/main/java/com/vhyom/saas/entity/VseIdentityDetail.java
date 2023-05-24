package com.vhyom.saas.entity;

import com.vhyom.saas.utils.UniqueName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vse_identity_details")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VseIdentityDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "uuid", nullable = false)
    private String uuid;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private VshEmployee user;
    @Size(max = 25)
    @Column(name = "pan", length = 25)
    private String pan;
    @Size(max = 25)
    @Column(name = "aadhaar_number", length = 25)
    @UniqueName(message = "aadhaarNumber Already Exist")
    private String aadhaarNumber;
    @Size(max = 25)
    @Column(name = "esic_number", length = 25)
    @UniqueName(message = "esicNumber Already Exist")
    private String esicNumber;
    @Size(max = 25)
    @Column(name = "passport_number", length = 25)
    private String passportNumber;
    @Column(name = "passport_valid_thru")
    private LocalDate passportValidThru;
    @NotNull
    @Column(name = "visa_status", nullable = false)
    private Boolean visaStatus = false;
    @Column(name = "visa_valid_thru")
    private LocalDate visaValidThru;
    @Size(max = 25)
    @Column(name = "driving_licence_number", length = 25)
    private String drivingLicenceNumber;
    @Column(name = "driving_licence_valid_thru")
    private LocalDate drivingLicenceValidThru;
    @Size(max = 50)
    @Column(name = "insurance_name", length = 50)
    private String insuranceName;
    @Size(max = 50)
    @Column(name = "insurance_id", length = 50)
    private String insuranceId;
    @Size(max = 50)
    @Column(name = "bank_name", length = 50)
    private String bankName;
    @Size(max = 25)
    @Column(name = "bank_account_number", length = 25)
    @UniqueName(message = "bankAccountNumber Already Exist")
    private String bankAccountNumber;
    @Size(max = 25)
    @Column(name = "bank_ifsc_code", length = 25)
    private String bankIfscCode;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;
    @Column(name = "last_modified_on")
    private LocalDateTime lastModifiedOn;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive ;

}
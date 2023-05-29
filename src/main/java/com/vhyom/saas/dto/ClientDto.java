package com.vhyom.saas.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String uuid;
    private String clientId;
    private String company;
    private String shortCode;
    private String websiteUrl;
    private String logo;
    private String gstin;
    private String pan;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private String phoneNumber;
    private Integer createdBy;
    private LocalDateTime createdOn;
    private Integer lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private Boolean isActive;


}

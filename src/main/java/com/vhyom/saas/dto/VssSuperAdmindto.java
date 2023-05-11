package com.vhyom.saas.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VssSuperAdmindto {
    private String uuid;
    private String emailId;
    private String profilePhoto;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String phoneNumber;
    private boolean isActive;
    private LocalDateTime createdOn;
    private Integer createdBy;
    private LocalDateTime lastModifiedOn;
    private Integer lastModifiedBy;
}

package com.vhyom.saas.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Date createdOn;
    private Integer createdBy;
    private Date lastModifiedOn;
    private Integer lastModifiedBy;
}

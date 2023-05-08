package com.vhyom.saas.dto;

import com.vhyom.saas.entity.VssCompany;
import com.vhyom.saas.entity.VssSubscription;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDetailsDto {


    private String uuid;
    private String name;
    private String websiteUrl;
    private String logo;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
    private int createdBy;
    private LocalDateTime createdOn;
    private Integer lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private boolean isActive;
    private String planName;
    private String description;
    private Integer totalUsers;
    private Date startDate;
    private Date endDate;
    private int status;
}

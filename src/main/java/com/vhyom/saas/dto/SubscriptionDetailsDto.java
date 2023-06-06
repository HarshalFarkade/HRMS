package com.vhyom.saas.dto;

import lombok.*;
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
    private Integer createdBy;
    private Date createdOn;
    private Integer lastModifiedBy;
    private Date lastModifiedOn;
    private boolean isActive;
    private String planName;
    private String description;
    private Integer totalUsers;
    private Integer totalActiveUsers ;
    private Date startDate;
    private Date endDate;
    private int  status;
}

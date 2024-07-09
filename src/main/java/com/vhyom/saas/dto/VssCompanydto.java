package com.vhyom.saas.dto;

import lombok.*;
import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VssCompanydto {

    private Integer id;
    private String uuid;
    private String name;
    private String websiteUrl;
    private String logo;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
    private int createdBy;
    private Date createdOn;
    private Integer lastModifiedBy;
    private Date lastModifiedOn;
    private boolean isActive;
}

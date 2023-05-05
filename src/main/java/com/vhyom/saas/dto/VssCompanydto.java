package com.vhyom.saas.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VssCompanydto {

    private Integer id;
    private String name;
    private String websiteUrl;
    private String logo;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int createdBy;
    private LocalDateTime createdOn;
    private Integer lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private boolean isActive;
}

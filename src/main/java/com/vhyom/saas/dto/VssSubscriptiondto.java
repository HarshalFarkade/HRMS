package com.vhyom.saas.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VssSubscriptiondto {
    private Integer id;
    private String uuid;
    private String planName;
    private BigDecimal planPrice;
    private Integer planType;
    private Integer totalUsers;
    private String description;
    private int createdBy;
    private Date createdOn;
    private Integer lastModifiedBy;
    private Date lastModifiedOn;
    private boolean isActive;
}

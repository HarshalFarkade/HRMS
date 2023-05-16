package com.vhyom.saas.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class VssSubscriptiondto {
    private String uuid;
    private String planName;
    private BigDecimal planPrice;
    private Integer planType;
    private Integer totalUsers;
    private String description;
    private int createdBy;
    private LocalDateTime createdOn;
    private Integer lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private boolean isActive;
}

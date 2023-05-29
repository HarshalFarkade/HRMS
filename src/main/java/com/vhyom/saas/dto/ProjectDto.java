package com.vhyom.saas.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String uuid;
    private Integer client;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal rate;
    private Integer rateType;
    private Integer projectManager;
    private Integer teamLeader;
    private Integer createdBy;
    private LocalDateTime createdOn;
    private Integer lastModifiedBy;
    private LocalDateTime lastModifiedOn;
    private Boolean isActive;
}

package com.vhyom.saas.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OvertimeRequestDto {
    private String uuid;
    private Integer user;
    private Integer category;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String notes;
    private Integer createdBy;
    private LocalDate createdOn;
    private Integer lastModifiedBy;
    private LocalDate lastModifiedOn;
    private boolean isActive;



}

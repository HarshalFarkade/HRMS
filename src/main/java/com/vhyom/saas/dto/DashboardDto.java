package com.vhyom.saas.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDto {

    private Long totalCompany;
    private Long totalActiveCompany;
    private Long totalSubscription;
    private Long totalActiveSubscription;
    private Long totalUsers;
    private Long totalActiveUsers;
}

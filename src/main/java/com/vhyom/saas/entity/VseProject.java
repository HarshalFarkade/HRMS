package com.vhyom.saas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "vse_project")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VseProject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    @Column(name = "uuid", nullable = false)
    private String uuid;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private VseClient client;
    @Size(max = 150)
    @Column(name = "name", length = 150)
    private String name;
    @Size(max = 500)
    @Column(name = "description", length = 500)
    private String description;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @NotNull
    @Column(name = "rate", nullable = false, precision = 18)
    private BigDecimal rate;
    @Column(name = "rate_type")
    private Integer rateType;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_manager", nullable = false)
    private VshEmployee projectManager;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_leader", nullable = false)
    private VshEmployee teamLeader;
    @NotNull
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    @NotNull
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;
    @Column(name = "last_modified_on")
    private LocalDateTime lastModifiedOn;
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}
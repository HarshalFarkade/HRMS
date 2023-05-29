package com.vhyom.saas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vsh_overtime_category")
public class VshOvertimeCategory {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Size(max = 25)
    @NotNull
    @Column(name = "name", nullable = false, length = 25)
    private String name;
    @NotNull
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    @NotNull
    @Column(name = "created_on", nullable = false)
    private Instant createdOn;
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;
    @Column(name = "last_modified_on")
    private Instant lastModifiedOn;
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

}
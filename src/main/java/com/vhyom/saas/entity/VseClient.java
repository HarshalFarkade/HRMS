package com.vhyom.saas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vse_client")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VseClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    @Column(name = "uuid", nullable = false)
    private String uuid;
    @Size(max = 50)
    @NotNull
    @Column(name = "client_id", nullable = false, length = 50)
    private String clientId;
    @Size(max = 150)
    @Column(name = "company", length = 150)
    private String company;
    @Size(max = 25)
    @Column(name = "short_code", length = 25)
    private String shortCode;
    @Size(max = 100)
    @Column(name = "website_url", length = 100)
    private String websiteUrl;
    @Size(max = 100)
    @Column(name = "logo", length = 100)
    private String logo;
    @Size(max = 25)
    @Column(name = "gstin", length = 25)
    private String gstin;
    @Size(max = 25)
    @Column(name = "pan", length = 25)
    private String pan;
    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Size(max = 100)
    @Column(name = "email_id", length = 100)
    private String emailId;
    @Size(max = 25)
    @Column(name = "mobile_number", length = 25)
    private String mobileNumber;
    @Size(max = 25)
    @Column(name = "phone_number", length = 25)
    private String phoneNumber;
    @Column(name = "created_by")
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
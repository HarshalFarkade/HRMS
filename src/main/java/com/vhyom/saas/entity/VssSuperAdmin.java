package com.vhyom.saas.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author Narendra
 */
@Entity
@Table(name = "vss_super_admin")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@NamedQueries({
    @NamedQuery(name = "VssSuperAdmin.findAll", query = "SELECT v FROM VssSuperAdmin v"),
    @NamedQuery(name = "VssSuperAdmin.findById", query = "SELECT v FROM VssSuperAdmin v WHERE v.id = :id"),
    @NamedQuery(name = "VssSuperAdmin.findByUuid", query = "SELECT v FROM VssSuperAdmin v WHERE v.uuid = :uuid"),
    @NamedQuery(name = "VssSuperAdmin.findByEmailId", query = "SELECT v FROM VssSuperAdmin v WHERE v.emailId = :emailId"),
    @NamedQuery(name = "VssSuperAdmin.findByPassword", query = "SELECT v FROM VssSuperAdmin v WHERE v.password = :password"),
    @NamedQuery(name = "VssSuperAdmin.findBySalt", query = "SELECT v FROM VssSuperAdmin v WHERE v.salt = :salt"),
    @NamedQuery(name = "VssSuperAdmin.findByProfilePhoto", query = "SELECT v FROM VssSuperAdmin v WHERE v.profilePhoto = :profilePhoto"),
    @NamedQuery(name = "VssSuperAdmin.findByFirstName", query = "SELECT v FROM VssSuperAdmin v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "VssSuperAdmin.findByLastName", query = "SELECT v FROM VssSuperAdmin v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "VssSuperAdmin.findByMobileNumber", query = "SELECT v FROM VssSuperAdmin v WHERE v.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "VssSuperAdmin.findByPhoneNumber", query = "SELECT v FROM VssSuperAdmin v WHERE v.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "VssSuperAdmin.findByCreatedBy", query = "SELECT v FROM VssSuperAdmin v WHERE v.createdBy = :createdBy"),
    @NamedQuery(name = "VssSuperAdmin.findByCreatedOn", query = "SELECT v FROM VssSuperAdmin v WHERE v.createdOn = :createdOn"),
    @NamedQuery(name = "VssSuperAdmin.findByLastModifiedBy", query = "SELECT v FROM VssSuperAdmin v WHERE v.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "VssSuperAdmin.findByLastModifiedOn", query = "SELECT v FROM VssSuperAdmin v WHERE v.lastModifiedOn = :lastModifiedOn"),
    @NamedQuery(name = "VssSuperAdmin.findByIsActive", query = "SELECT v FROM VssSuperAdmin v WHERE v.isActive = :isActive")})
public class VssSuperAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 36)
    private String uuid;
    @Basic(optional = false)
    @Column(name = "email_id", nullable = false, length = 100)
    private String emailId;
    @Column(length = 255)
    private String password;
    @Column(length = 255)
    private String salt;
    @Column(name = "profile_photo", length = 100)
    private String profilePhoto;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "mobile_number", length = 25)
    private String mobileNumber;
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdOn;
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;
    @Column(name = "last_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModifiedOn;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}

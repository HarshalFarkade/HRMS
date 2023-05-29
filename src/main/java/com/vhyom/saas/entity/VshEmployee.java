package com.vhyom.saas.entity;

import java.io.Serializable;
import com.vhyom.saas.utils.UniqueName;
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
import java.util.Date;
import jakarta.validation.constraints.Email;
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
@Table(name = "vsh_employee")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "VshEmployee.findAll", query = "SELECT v FROM VshEmployee v"),
        @NamedQuery(name = "VshEmployee.findById", query = "SELECT v FROM VshEmployee v WHERE v.id = :id"),
        @NamedQuery(name = "VshEmployee.findByUuid", query = "SELECT v FROM VshEmployee v WHERE v.uuid = :uuid"),
        @NamedQuery(name = "VshEmployee.findByPartnerId", query = "SELECT v FROM VshEmployee v WHERE v.partnerId = :partnerId"),
        @NamedQuery(name = "VshEmployee.findByPartnerNumber", query = "SELECT v FROM VshEmployee v WHERE v.partnerNumber = :partnerNumber"),
        @NamedQuery(name = "VshEmployee.findByEmailId", query = "SELECT v FROM VshEmployee v WHERE v.emailId = :emailId"),
        @NamedQuery(name = "VshEmployee.findByPassword", query = "SELECT v FROM VshEmployee v WHERE v.password = :password"),
        @NamedQuery(name = "VshEmployee.findBySalt", query = "SELECT v FROM VshEmployee v WHERE v.salt = :salt"),
        @NamedQuery(name = "VshEmployee.findByProfilePhoto", query = "SELECT v FROM VshEmployee v WHERE v.profilePhoto = :profilePhoto"),
        @NamedQuery(name = "VshEmployee.findByFirstName", query = "SELECT v FROM VshEmployee v WHERE v.firstName = :firstName"),
        @NamedQuery(name = "VshEmployee.findByLastName", query = "SELECT v FROM VshEmployee v WHERE v.lastName = :lastName"),
        @NamedQuery(name = "VshEmployee.findByDateOfBirth", query = "SELECT v FROM VshEmployee v WHERE v.dateOfBirth = :dateOfBirth"),
        @NamedQuery(name = "VshEmployee.findByMobileNumber", query = "SELECT v FROM VshEmployee v WHERE v.mobileNumber = :mobileNumber"),
        @NamedQuery(name = "VshEmployee.findByPhoneNumber", query = "SELECT v FROM VshEmployee v WHERE v.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "VshEmployee.findByCreatedBy", query = "SELECT v FROM VshEmployee v WHERE v.createdBy = :createdBy"),
        @NamedQuery(name = "VshEmployee.findByCreatedOn", query = "SELECT v FROM VshEmployee v WHERE v.createdOn = :createdOn"),
        @NamedQuery(name = "VshEmployee.findByLastModifiedBy", query = "SELECT v FROM VshEmployee v WHERE v.lastModifiedBy = :lastModifiedBy"),
        @NamedQuery(name = "VshEmployee.findByLastModifiedOn", query = "SELECT v FROM VshEmployee v WHERE v.lastModifiedOn = :lastModifiedOn"),
        @NamedQuery(name = "VshEmployee.findByIsActive", query = "SELECT v FROM VshEmployee v WHERE v.isActive = :isActive")})
public class VshEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 36)
    private String uuid;
    @Column(name = "partner_id")
    private Integer partnerId;
    @Column(name = "partner_number", length = 50)
    private String partnerNumber;
    @Basic(optional = false)
    @Column(name = "email_id", nullable = false, length = 100)
    @Email
    @UniqueName(message = "Email Already Exist")
    private String emailId;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String salt;
    @Column(name = "profile_photo", length = 100)
    private String profilePhoto;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "mobile_number", length = 25)
    private String mobileNumber;
    @Column(name = "phone_number", length = 25)
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
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

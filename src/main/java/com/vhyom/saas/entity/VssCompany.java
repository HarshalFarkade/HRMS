package com.vhyom.saas.entity;

import java.io.Serializable;
import java.util.Collection;

import com.vhyom.saas.utils.UniqueName;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "vss_company")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@NamedQueries({
    @NamedQuery(name = "VssCompany.findAll", query = "SELECT v FROM VssCompany v"),
    @NamedQuery(name = "VssCompany.findById", query = "SELECT v FROM VssCompany v WHERE v.id = :id"),
    @NamedQuery(name = "VssCompany.findByUuid", query = "SELECT v FROM VssCompany v WHERE v.uuid = :uuid"),
    @NamedQuery(name = "VssCompany.findByName", query = "SELECT v FROM VssCompany v WHERE v.name = :name"),
    @NamedQuery(name = "VssCompany.findByWebsiteUrl", query = "SELECT v FROM VssCompany v WHERE v.websiteUrl = :websiteUrl"),
    @NamedQuery(name = "VssCompany.findByLogo", query = "SELECT v FROM VssCompany v WHERE v.logo = :logo"),
    @NamedQuery(name = "VssCompany.findByFirstName", query = "SELECT v FROM VssCompany v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "VssCompany.findByLastName", query = "SELECT v FROM VssCompany v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "VssCompany.findByEmailId", query = "SELECT v FROM VssCompany v WHERE v.emailId = :emailId"),
    @NamedQuery(name = "VssCompany.findByPhoneNumber", query = "SELECT v FROM VssCompany v WHERE v.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "VssCompany.findByCreatedBy", query = "SELECT v FROM VssCompany v WHERE v.createdBy = :createdBy"),
    @NamedQuery(name = "VssCompany.findByCreatedOn", query = "SELECT v FROM VssCompany v WHERE v.createdOn = :createdOn"),
    @NamedQuery(name = "VssCompany.findByLastModifiedBy", query = "SELECT v FROM VssCompany v WHERE v.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "VssCompany.findByLastModifiedOn", query = "SELECT v FROM VssCompany v WHERE v.lastModifiedOn = :lastModifiedOn"),
    @NamedQuery(name = "VssCompany.findByIsActive", query = "SELECT v FROM VssCompany v WHERE v.isActive = :isActive")})
public class VssCompany implements Serializable {

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
    @Column(nullable = false, length = 150)
    @UniqueName(message = "Name Already Taken")
    private String name;
    @Column(name = "website_url", length = 100)
    private String websiteUrl;
    @Column(length = 100)
    private String logo;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email_id", nullable = false, length = 100)
    private String emailId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<VssSubscriptionDetails> vssSubscriptionDetailsCollection;
}

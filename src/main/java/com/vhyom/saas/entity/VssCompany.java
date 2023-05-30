package com.vhyom.saas.entity;

import com.vhyom.saas.utils.UniqueName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


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
    @NotEmpty(message = "Please Provide Company Name")
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
   // @Email(message = "Please provide a valid email address")
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
   // @NotNull(message = "Please Provide EmailId")
    private String emailId;
    @Column(name = "phone_number", length = 25)
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;
    @Column(name = "last_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<VssSubscriptionDetails> vssSubscriptionDetailsCollection;
}

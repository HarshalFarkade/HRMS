package com.vhyom.saas.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Narendra
 */
@Entity
@Table(name = "vss_subscription_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@NamedQueries({
    @NamedQuery(name = "VssSubscriptionDetails.findAll", query = "SELECT v FROM VssSubscriptionDetails v"),
    @NamedQuery(name = "VssSubscriptionDetails.findById", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.id = :id"),
    @NamedQuery(name = "VssSubscriptionDetails.findByUuid", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.uuid = :uuid"),
    @NamedQuery(name = "VssSubscriptionDetails.findByStartDate", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.startDate = :startDate"),
    @NamedQuery(name = "VssSubscriptionDetails.findByEndDate", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.endDate = :endDate"),
    @NamedQuery(name = "VssSubscriptionDetails.findByStatus", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.status = :status"),
    @NamedQuery(name = "VssSubscriptionDetails.findByCreatedBy", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.createdBy = :createdBy"),
    @NamedQuery(name = "VssSubscriptionDetails.findByCreatedOn", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.createdOn = :createdOn"),
    @NamedQuery(name = "VssSubscriptionDetails.findByLastModifiedBy", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "VssSubscriptionDetails.findByLastModifiedOn", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.lastModifiedOn = :lastModifiedOn"),
    @NamedQuery(name = "VssSubscriptionDetails.findByIsActive", query = "SELECT v FROM VssSubscriptionDetails v WHERE v.isActive = :isActive")})
public class VssSubscriptionDetails implements Serializable {

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
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private int status;
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
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private VssCompany companyId;
    @JoinColumn(name = "subscription_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private VssSubscription subscriptionId;
}

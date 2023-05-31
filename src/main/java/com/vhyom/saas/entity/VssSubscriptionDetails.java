package com.vhyom.saas.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.vhyom.saas.utils.UniqueId;
import com.vhyom.saas.utils.UniqueName;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

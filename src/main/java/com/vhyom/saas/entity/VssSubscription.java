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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.aspectj.bridge.IMessage;

/**
 *
 * @author Narendra
 */
@Entity
@Table(name = "vss_subscription")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@NamedQueries({
    @NamedQuery(name = "VssSubscription.findAll", query = "SELECT v FROM VssSubscription v"),
    @NamedQuery(name = "VssSubscription.findById", query = "SELECT v FROM VssSubscription v WHERE v.id = :id"),
    @NamedQuery(name = "VssSubscription.findByUuid", query = "SELECT v FROM VssSubscription v WHERE v.uuid = :uuid"),
    @NamedQuery(name = "VssSubscription.findByPlanName", query = "SELECT v FROM VssSubscription v WHERE v.planName = :planName"),
    @NamedQuery(name = "VssSubscription.findByPlanPrice", query = "SELECT v FROM VssSubscription v WHERE v.planPrice = :planPrice"),
    @NamedQuery(name = "VssSubscription.findByPlanType", query = "SELECT v FROM VssSubscription v WHERE v.planType = :planType"),
    @NamedQuery(name = "VssSubscription.findByTotalUsers", query = "SELECT v FROM VssSubscription v WHERE v.totalUsers = :totalUsers"),
    @NamedQuery(name = "VssSubscription.findByDescription", query = "SELECT v FROM VssSubscription v WHERE v.description = :description"),
    @NamedQuery(name = "VssSubscription.findByCreatedBy", query = "SELECT v FROM VssSubscription v WHERE v.createdBy = :createdBy"),
    @NamedQuery(name = "VssSubscription.findByCreatedOn", query = "SELECT v FROM VssSubscription v WHERE v.createdOn = :createdOn"),
    @NamedQuery(name = "VssSubscription.findByLastModifiedBy", query = "SELECT v FROM VssSubscription v WHERE v.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "VssSubscription.findByLastModifiedOn", query = "SELECT v FROM VssSubscription v WHERE v.lastModifiedOn = :lastModifiedOn"),
    @NamedQuery(name = "VssSubscription.findByIsActive", query = "SELECT v FROM VssSubscription v WHERE v.isActive = :isActive")})
public class VssSubscription implements Serializable {

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
    @Column(name = "plan_name", nullable = false, length = 50)
    @UniqueName(message = " planName must be different")
    @NotNull (message ="Please provide Plan name ")
    private String planName;
    @Column(name = "plan_price", precision = 18, scale = 2)
    private BigDecimal planPrice;
    @Column(name = "plan_type")
    //@UniqueName(message = " plan type must be different")
    private Integer planType;
    @Column(name = "total_users")
    private Integer totalUsers;
    @Column(length = 100)
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriptionId")
    private Collection<VssSubscriptionDetails> vssSubscriptionDetailsCollection;
}

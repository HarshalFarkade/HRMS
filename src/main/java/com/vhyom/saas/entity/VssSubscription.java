package com.vhyom.saas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;


/**
 *
 * @author Narendra Jha
 */
@Entity
@Table(name = "vss_subscription")
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
    private String planName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "plan_price", precision = 18, scale = 2)
    private BigDecimal planPrice;
    @Column(name = "plan_type")
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

    public VssSubscription() {
    }

    public VssSubscription(Integer id) {
        this.id = id;
    }

    public VssSubscription(Integer id, String uuid, String planName, int createdBy, Date createdOn, boolean isActive) {
        this.id = id;
        this.uuid = uuid;
        this.planName = planName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public BigDecimal getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(BigDecimal planPrice) {
        this.planPrice = planPrice;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Collection<VssSubscriptionDetails> getVssSubscriptionDetailsCollection() {
        return vssSubscriptionDetailsCollection;
    }

    public void setVssSubscriptionDetailsCollection(Collection<VssSubscriptionDetails> vssSubscriptionDetailsCollection) {
        this.vssSubscriptionDetailsCollection = vssSubscriptionDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VssSubscription)) {
            return false;
        }
        VssSubscription other = (VssSubscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vhyom.saas.entity.VssSubscription[ id=" + id + " ]";
    }
    
}

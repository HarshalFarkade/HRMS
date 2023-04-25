package com.vhyom.saas.entity;

import java.io.Serializable;
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
 * @author Narendra
 */
@Entity
@Table(name = "vss_subscription_details")
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

    public VssSubscriptionDetails() {
    }

    public VssSubscriptionDetails(Integer id) {
        this.id = id;
    }

    public VssSubscriptionDetails(Integer id, String uuid, Date startDate, Date endDate, int status, int createdBy, Date createdOn, boolean isActive) {
        this.id = id;
        this.uuid = uuid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public VssCompany getCompanyId() {
        return companyId;
    }

    public void setCompanyId(VssCompany companyId) {
        this.companyId = companyId;
    }

    public VssSubscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(VssSubscription subscriptionId) {
        this.subscriptionId = subscriptionId;
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
        if (!(object instanceof VssSubscriptionDetails)) {
            return false;
        }
        VssSubscriptionDetails other = (VssSubscriptionDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vhyom.saas.entity.VssSubscriptionDetails[ id=" + id + " ]";
    }
    
}

package com.vhyom.saas.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Narendra
 */
@Entity
@Table(name = "vss_company", catalog = "VS10000-VHYOM_SaaS", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"uuid"})})
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

    public VssCompany() {
    }

    public VssCompany(Integer id) {
        this.id = id;
    }

    public VssCompany(Integer id, String uuid, String name, String emailId, int createdBy, Date createdOn, boolean isActive) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.emailId = emailId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        if (!(object instanceof VssCompany)) {
            return false;
        }
        VssCompany other = (VssCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vhyom.saas.entity.VssCompany[ id=" + id + " ]";
    }
    
}

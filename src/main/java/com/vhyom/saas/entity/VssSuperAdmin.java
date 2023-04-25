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
@Table(name = "vss_super_admin")
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
    private Date createdOn;
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;
    @Column(name = "last_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public VssSuperAdmin() {
    }

    public VssSuperAdmin(Integer id) {
        this.id = id;
    }

    public VssSuperAdmin(Integer id, String uuid, String emailId, Date createdOn, boolean isActive) {
        this.id = id;
        this.uuid = uuid;
        this.emailId = emailId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VssSuperAdmin)) {
            return false;
        }
        VssSuperAdmin other = (VssSuperAdmin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vhyom.saas.entity.VssSuperAdmin[ id=" + id + " ]";
    }
    
}

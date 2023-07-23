/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Radhika Maniya
 */
@Entity
@Table(name = "enquiry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enquiry.findAll", query = "SELECT e FROM Enquiry e"),
    @NamedQuery(name = "Enquiry.findByEnquiryID", query = "SELECT e FROM Enquiry e WHERE e.enquiryID = :enquiryID"),
    @NamedQuery(name = "Enquiry.findByContactNumber", query = "SELECT e FROM Enquiry e WHERE e.contactNumber = :contactNumber"),
    @NamedQuery(name = "Enquiry.findByEmailID", query = "SELECT e FROM Enquiry e WHERE e.emailID = :emailID"),
    @NamedQuery(name = "Enquiry.findByMessage", query = "SELECT e FROM Enquiry e WHERE e.message = :message")})
public class Enquiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EnquiryID")
    private Integer enquiryID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactNumber")
    private long contactNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EmailID")
    private String emailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Message")
    private String message;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private User userID;

    public Enquiry() {
    }

    public Enquiry(Integer enquiryID) {
        this.enquiryID = enquiryID;
    }

    public Enquiry(Integer enquiryID, long contactNumber, String emailID, String message) {
        this.enquiryID = enquiryID;
        this.contactNumber = contactNumber;
        this.emailID = emailID;
        this.message = message;
    }

    public Integer getEnquiryID() {
        return enquiryID;
    }

    public void setEnquiryID(Integer enquiryID) {
        this.enquiryID = enquiryID;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquiryID != null ? enquiryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquiry)) {
            return false;
        }
        Enquiry other = (Enquiry) object;
        if ((this.enquiryID == null && other.enquiryID != null) || (this.enquiryID != null && !this.enquiryID.equals(other.enquiryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Enquiry[ enquiryID=" + enquiryID + " ]";
    }
    
}

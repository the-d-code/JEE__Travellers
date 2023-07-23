/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Radhika Maniya
 */
@Entity
@Table(name = "packagebooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packagebooking.findAll", query = "SELECT p FROM Packagebooking p"),
    @NamedQuery(name = "Packagebooking.findByPackageBookingID", query = "SELECT p FROM Packagebooking p WHERE p.packageBookingID = :packageBookingID"),
    @NamedQuery(name = "Packagebooking.findByNoOfTravelers", query = "SELECT p FROM Packagebooking p WHERE p.noOfTravelers = :noOfTravelers"),
    @NamedQuery(name = "Packagebooking.findByEmailID", query = "SELECT p FROM Packagebooking p WHERE p.emailID = :emailID"),
    @NamedQuery(name = "Packagebooking.findByContactNumber", query = "SELECT p FROM Packagebooking p WHERE p.contactNumber = :contactNumber"),
    @NamedQuery(name = "Packagebooking.findByBookingDate", query = "SELECT p FROM Packagebooking p WHERE p.bookingDate = :bookingDate")})
public class Packagebooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PackageBookingID")
    private Integer packageBookingID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfTravelers")
    private int noOfTravelers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EmailID")
    private String emailID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactNumber")
    private int contactNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BookingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;
    @JoinColumn(name = "PackageID", referencedColumnName = "PackageID")
    @ManyToOne(optional = false)
    private Packages packageID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private User userID;

    public Packagebooking() {
    }

    public Packagebooking(Integer packageBookingID) {
        this.packageBookingID = packageBookingID;
    }

    public Packagebooking(Integer packageBookingID, int noOfTravelers, String emailID, int contactNumber, Date bookingDate) {
        this.packageBookingID = packageBookingID;
        this.noOfTravelers = noOfTravelers;
        this.emailID = emailID;
        this.contactNumber = contactNumber;
        this.bookingDate = bookingDate;
    }

    public Integer getPackageBookingID() {
        return packageBookingID;
    }

    public void setPackageBookingID(Integer packageBookingID) {
        this.packageBookingID = packageBookingID;
    }

    public int getNoOfTravelers() {
        return noOfTravelers;
    }

    public void setNoOfTravelers(int noOfTravelers) {
        this.noOfTravelers = noOfTravelers;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Packages getPackageID() {
        return packageID;
    }

    public void setPackageID(Packages packageID) {
        this.packageID = packageID;
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
        hash += (packageBookingID != null ? packageBookingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packagebooking)) {
            return false;
        }
        Packagebooking other = (Packagebooking) object;
        if ((this.packageBookingID == null && other.packageBookingID != null) || (this.packageBookingID != null && !this.packageBookingID.equals(other.packageBookingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Packagebooking[ packageBookingID=" + packageBookingID + " ]";
    }
    
}

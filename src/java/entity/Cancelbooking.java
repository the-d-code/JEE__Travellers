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
@Table(name = "cancelbooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancelbooking.findAll", query = "SELECT c FROM Cancelbooking c"),
    @NamedQuery(name = "Cancelbooking.findByCancelBookingID", query = "SELECT c FROM Cancelbooking c WHERE c.cancelBookingID = :cancelBookingID"),
    @NamedQuery(name = "Cancelbooking.findByReasonForCancel", query = "SELECT c FROM Cancelbooking c WHERE c.reasonForCancel = :reasonForCancel"),
    @NamedQuery(name = "Cancelbooking.findByDate", query = "SELECT c FROM Cancelbooking c WHERE c.date = :date")})
public class Cancelbooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CancelBookingID")
    private Integer cancelBookingID;
    @Size(max = 500)
    @Column(name = "ReasonForCancel")
    private String reasonForCancel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private User userID;
    @JoinColumn(name = "PackageID", referencedColumnName = "PackageID")
    @ManyToOne(optional = false)
    private Packages packageID;
    @JoinColumn(name = "PaymentID", referencedColumnName = "PaymentID")
    @ManyToOne(optional = false)
    private Payment paymentID;

    public Cancelbooking() {
    }

    public Cancelbooking(Integer cancelBookingID) {
        this.cancelBookingID = cancelBookingID;
    }

    public Cancelbooking(Integer cancelBookingID, Date date) {
        this.cancelBookingID = cancelBookingID;
        this.date = date;
    }

    public Integer getCancelBookingID() {
        return cancelBookingID;
    }

    public void setCancelBookingID(Integer cancelBookingID) {
        this.cancelBookingID = cancelBookingID;
    }

    public String getReasonForCancel() {
        return reasonForCancel;
    }

    public void setReasonForCancel(String reasonForCancel) {
        this.reasonForCancel = reasonForCancel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Packages getPackageID() {
        return packageID;
    }

    public void setPackageID(Packages packageID) {
        this.packageID = packageID;
    }

    public Payment getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Payment paymentID) {
        this.paymentID = paymentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cancelBookingID != null ? cancelBookingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancelbooking)) {
            return false;
        }
        Cancelbooking other = (Cancelbooking) object;
        if ((this.cancelBookingID == null && other.cancelBookingID != null) || (this.cancelBookingID != null && !this.cancelBookingID.equals(other.cancelBookingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cancelbooking[ cancelBookingID=" + cancelBookingID + " ]";
    }
    
}

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
@Table(name = "packagerating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packagerating.findAll", query = "SELECT p FROM Packagerating p"),
    @NamedQuery(name = "Packagerating.findByPackageRatingID", query = "SELECT p FROM Packagerating p WHERE p.packageRatingID = :packageRatingID"),
    @NamedQuery(name = "Packagerating.findByRatingStar", query = "SELECT p FROM Packagerating p WHERE p.ratingStar = :ratingStar"),
    @NamedQuery(name = "Packagerating.findByDescription", query = "SELECT p FROM Packagerating p WHERE p.description = :description")})
public class Packagerating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PackageRatingID")
    private Integer packageRatingID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RatingStar")
    private int ratingStar;
    @Size(max = 50)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "PackageID", referencedColumnName = "PackageID")
    @ManyToOne(optional = false)
    private Packages packageID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private User userID;

    public Packagerating() {
    }

    public Packagerating(Integer packageRatingID) {
        this.packageRatingID = packageRatingID;
    }

    public Packagerating(int ratingStar) {
        this.ratingStar = ratingStar;
    }

    public Integer getPackageRatingID() {
        return packageRatingID;
    }

    public void setPackageRatingID(Integer packageRatingID) {
        this.packageRatingID = packageRatingID;
    }

    public int getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(int ratingStar) {
        this.ratingStar = ratingStar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (packageRatingID != null ? packageRatingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packagerating)) {
            return false;
        }
        Packagerating other = (Packagerating) object;
        if ((this.packageRatingID == null && other.packageRatingID != null) || (this.packageRatingID != null && !this.packageRatingID.equals(other.packageRatingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Packagerating[ packageRatingID=" + packageRatingID + " ]";
    }
    
}

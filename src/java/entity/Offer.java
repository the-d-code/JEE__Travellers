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
@Table(name = "offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferID", query = "SELECT o FROM Offer o WHERE o.offerID = :offerID"),
    @NamedQuery(name = "Offer.findByOfferName", query = "SELECT o FROM Offer o WHERE o.offerName = :offerName"),
    @NamedQuery(name = "Offer.findByIsSpecial", query = "SELECT o FROM Offer o WHERE o.isSpecial = :isSpecial"),
    @NamedQuery(name = "Offer.findByDescription", query = "SELECT o FROM Offer o WHERE o.description = :description"),
    @NamedQuery(name = "Offer.findByPrice", query = "SELECT o FROM Offer o WHERE o.price = :price")})
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OfferID")
    private Integer offerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OfferName")
    private String offerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSpecial")
    private boolean isSpecial;
    @Size(max = 150)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private int price;

    public Offer() {
    }

    public Offer(Integer offerID) {
        this.offerID = offerID;
    }

     public Offer(String offerName, boolean isSpecial,String description,Integer Price) {
        
        this.offerName = offerName;
        this.isSpecial = isSpecial;
        this.description = description;
        this.price = Price;
    }

    public Integer getOfferID() {
        return offerID;
    }

    public void setOfferID(Integer offerID) {
        this.offerID = offerID;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offerID != null ? offerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerID == null && other.offerID != null) || (this.offerID != null && !this.offerID.equals(other.offerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Offer[ offerID=" + offerID + " ]";
    }
    
}















///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entity;
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Radhika Maniya
// */
//@Entity
//@Table(name = "offer")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
//    @NamedQuery(name = "Offer.findByOfferID", query = "SELECT o FROM Offer o WHERE o.offerID = :offerID"),
//    @NamedQuery(name = "Offer.findByOfferName", query = "SELECT o FROM Offer o WHERE o.offerName = :offerName"),
//    @NamedQuery(name = "Offer.findByIsSpecial", query = "SELECT o FROM Offer o WHERE o.isSpecial = :isSpecial"),
//    @NamedQuery(name = "Offer.findByDescription", query = "SELECT o FROM Offer o WHERE o.description = :description"),
//    @NamedQuery(name = "Offer.findByPrice", query = "SELECT o FROM Offer o WHERE o.price = :price")})
//public class Offer implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "OfferID")
//    private Integer offerID;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
//    @Column(name = "OfferName")
//    private String offerName;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "IsSpecial")
//    private boolean isSpecial;
//    @Size(max = 150)
//    @Column(name = "Description")
//    private String description;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "Price")
//    private int price;
//
//    public Offer() {
//    }
//
//    public Offer(Integer offerID) {
//        this.offerID = offerID;
//    }
//
//    public Offer(String offerName, boolean isSpecial, int price) {
//        
//        this.offerName = offerName;
//        this.isSpecial = isSpecial;
//        this.price = price;
//    }
//
//    public Integer getOfferID() {
//        return offerID;
//    }
//
//    public void setOfferID(Integer offerID) {
//        this.offerID = offerID;
//    }
//
//    public String getOfferName() {
//        return offerName;
//    }
//
//    public void setOfferName(String offerName) {
//        this.offerName = offerName;
//    }
//
//    public boolean getIsSpecial() {
//        return isSpecial;
//    }
//
//    public void setIsSpecial(boolean isSpecial) {
//        this.isSpecial = isSpecial;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (offerID != null ? offerID.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Offer)) {
//            return false;
//        }
//        Offer other = (Offer) object;
//        if ((this.offerID == null && other.offerID != null) || (this.offerID != null && !this.offerID.equals(other.offerID))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "entity.Offer[ offerID=" + offerID + " ]";
//    }
//    
//}

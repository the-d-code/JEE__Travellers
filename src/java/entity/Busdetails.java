/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Radhika Maniya
 */
@Entity
@Table(name = "busdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busdetails.findAll", query = "SELECT b FROM Busdetails b"),
    @NamedQuery(name = "Busdetails.findByBusID", query = "SELECT b FROM Busdetails b WHERE b.busID = :busID"),
    @NamedQuery(name = "Busdetails.findByBusName", query = "SELECT b FROM Busdetails b WHERE b.busName = :busName"),
    @NamedQuery(name = "Busdetails.findByTotalSeats", query = "SELECT b FROM Busdetails b WHERE b.totalSeats = :totalSeats"),
    @NamedQuery(name = "Busdetails.findByCostPerSeat", query = "SELECT b FROM Busdetails b WHERE b.costPerSeat = :costPerSeat"),
    @NamedQuery(name = "Busdetails.findByAvailableSeat", query = "SELECT b FROM Busdetails b WHERE b.availableSeat = :availableSeat"),
    @NamedQuery(name = "Busdetails.findByImage1", query = "SELECT b FROM Busdetails b WHERE b.image1 = :image1"),
    @NamedQuery(name = "Busdetails.findByImage2", query = "SELECT b FROM Busdetails b WHERE b.image2 = :image2"),
    @NamedQuery(name = "Busdetails.findByImage3", query = "SELECT b FROM Busdetails b WHERE b.image3 = :image3"),
    @NamedQuery(name = "Busdetails.findByDescription", query = "SELECT b FROM Busdetails b WHERE b.description = :description")})
public class Busdetails implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BusName")
    private String busName;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "TotalSeats")
    private int totalSeats;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostPerSeat")
    private int costPerSeat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AvailableSeat")
    private int availableSeat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Image1")
    private String image1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Image2")
    private String image2;
    @Size(max = 150)
    @Column(name = "Image3")
    private String image3;
    @Size(max = 5000)
    @Column(name = "Description")
    private String description;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusID")
    private Integer busID;
    @JoinColumn(name = "FromCityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City fromCityID;
    @JoinColumn(name = "ToCityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City toCityID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busID")
    private Collection<Packages> packagesCollection;

    public Busdetails() {
    }

    public Busdetails(Integer busID) {
        this.busID = busID;
    }

    public Busdetails(Integer busID, String busName, int totalSeats, int costPerSeat, int availableSeat, String image1, String image2) {
        this.busID = busID;
        this.busName = busName;
        this.totalSeats = totalSeats;
        this.costPerSeat = costPerSeat;
        this.availableSeat = availableSeat;
        this.image1 = image1;
        this.image2 = image2;
    }

    public Integer getBusID() {
        return busID;
    }

    public void setBusID(Integer busID) {
        this.busID = busID;
    }


    public City getFromCityID() {
        return fromCityID;
    }

    public void setFromCityID(City fromCityID) {
        this.fromCityID = fromCityID;
    }

    public City getToCityID() {
        return toCityID;
    }

    public void setToCityID(City toCityID) {
        this.toCityID = toCityID;
    }

    @XmlTransient
    public Collection<Packages> getPackagesCollection() {
        return packagesCollection;
    }

    public void setPackagesCollection(Collection<Packages> packagesCollection) {
        this.packagesCollection = packagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busID != null ? busID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busdetails)) {
            return false;
        }
        Busdetails other = (Busdetails) object;
        if ((this.busID == null && other.busID != null) || (this.busID != null && !this.busID.equals(other.busID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Busdetails[ busID=" + busID + " ]";
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getCostPerSeat() {
        return costPerSeat;
    }

    public void setCostPerSeat(int costPerSeat) {
        this.costPerSeat = costPerSeat;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

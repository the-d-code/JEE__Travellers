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
import javax.persistence.Lob;
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
@Table(name = "managehotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Managehotel.findAll", query = "SELECT m FROM Managehotel m"),
    @NamedQuery(name = "Managehotel.findByHotelID", query = "SELECT m FROM Managehotel m WHERE m.hotelID = :hotelID"),
    @NamedQuery(name = "Managehotel.findByHotelName", query = "SELECT m FROM Managehotel m WHERE m.hotelName = :hotelName"),
    @NamedQuery(name = "Managehotel.findByCostPerRoom", query = "SELECT m FROM Managehotel m WHERE m.costPerRoom = :costPerRoom"),
    @NamedQuery(name = "Managehotel.findByImage1", query = "SELECT m FROM Managehotel m WHERE m.image1 = :image1"),
    @NamedQuery(name = "Managehotel.findByImage2", query = "SELECT m FROM Managehotel m WHERE m.image2 = :image2"),
    @NamedQuery(name = "Managehotel.findByImage3", query = "SELECT m FROM Managehotel m WHERE m.image3 = :image3"),
    @NamedQuery(name = "Managehotel.findByDescription", query = "SELECT m FROM Managehotel m WHERE m.description = :description")})
public class Managehotel implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HotelName")
    private String hotelName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostPerRoom")
    private int costPerRoom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Image1")
    private String image1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Image2")
    private String image2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Image3")
    private String image3;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "Description")
    private String description;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HotelID")
    private Integer hotelID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelID")
    private Collection<Packages> packagesCollection;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private State stateID;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City cityID;

    public Managehotel() {
    }

    public Managehotel(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public Managehotel(Integer hotelID, String hotelName, int costPerRoom, String image1, String image2, String image3, String description) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.costPerRoom = costPerRoom;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.description = description;
    }

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }


    @XmlTransient
    public Collection<Packages> getPackagesCollection() {
        return packagesCollection;
    }

    public void setPackagesCollection(Collection<Packages> packagesCollection) {
        this.packagesCollection = packagesCollection;
    }

    public State getStateID() {
        return stateID;
    }

    public void setStateID(State stateID) {
        this.stateID = stateID;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Managehotel)) {
            return false;
        }
        Managehotel other = (Managehotel) object;
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Managehotel[ hotelID=" + hotelID + " ]";
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getCostPerRoom() {
        return costPerRoom;
    }

    public void setCostPerRoom(int costPerRoom) {
        this.costPerRoom = costPerRoom;
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

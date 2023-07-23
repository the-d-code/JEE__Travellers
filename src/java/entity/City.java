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
@Table(name = "city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findByCityID", query = "SELECT c FROM City c WHERE c.cityID = :cityID"),
    @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")})
public class City implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CityName")
    private String cityName;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CityID")
    private Integer cityID;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private State stateID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromCityID")
    private Collection<Busdetails> busdetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toCityID")
    private Collection<Busdetails> busdetailsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<SubPlaces> subPlacesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Managehotel> managehotelCollection;

    public City() {
    }

    public City(Integer cityID) {
        this.cityID = cityID;
    }

    public City(Integer cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }


    public State getStateID() {
        return stateID;
    }

    public void setStateID(State stateID) {
        this.stateID = stateID;
    }

    @XmlTransient
    public Collection<Busdetails> getBusdetailsCollection() {
        return busdetailsCollection;
    }

    public void setBusdetailsCollection(Collection<Busdetails> busdetailsCollection) {
        this.busdetailsCollection = busdetailsCollection;
    }

    @XmlTransient
    public Collection<Busdetails> getBusdetailsCollection1() {
        return busdetailsCollection1;
    }

    public void setBusdetailsCollection1(Collection<Busdetails> busdetailsCollection1) {
        this.busdetailsCollection1 = busdetailsCollection1;
    }

    @XmlTransient
    public Collection<SubPlaces> getSubPlacesCollection() {
        return subPlacesCollection;
    }

    public void setSubPlacesCollection(Collection<SubPlaces> subPlacesCollection) {
        this.subPlacesCollection = subPlacesCollection;
    }

    @XmlTransient
    public Collection<Managehotel> getManagehotelCollection() {
        return managehotelCollection;
    }

    public void setManagehotelCollection(Collection<Managehotel> managehotelCollection) {
        this.managehotelCollection = managehotelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.City[ cityID=" + cityID + " ]";
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
}

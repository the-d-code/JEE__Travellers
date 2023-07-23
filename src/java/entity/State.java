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
@Table(name = "state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s"),
    @NamedQuery(name = "State.findByStateID", query = "SELECT s FROM State s WHERE s.stateID = :stateID"),
    @NamedQuery(name = "State.findByStateName", query = "SELECT s FROM State s WHERE s.stateName = :stateName")})
public class State implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StateName")
    private String stateName;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StateID")
    private Integer stateID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<City> cityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<Packages> packagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<SubPlaces> subPlacesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<Places> placesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<Managehotel> managehotelCollection;

    public State() {
    }

    public State(Integer stateID) {
        this.stateID = stateID;
    }

    public State(String stateName) {
        this.stateName = stateName;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }


    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    @XmlTransient
    public Collection<Packages> getPackagesCollection() {
        return packagesCollection;
    }

    public void setPackagesCollection(Collection<Packages> packagesCollection) {
        this.packagesCollection = packagesCollection;
    }

    @XmlTransient
    public Collection<SubPlaces> getSubPlacesCollection() {
        return subPlacesCollection;
    }

    public void setSubPlacesCollection(Collection<SubPlaces> subPlacesCollection) {
        this.subPlacesCollection = subPlacesCollection;
    }

    @XmlTransient
    public Collection<Places> getPlacesCollection() {
        return placesCollection;
    }

    public void setPlacesCollection(Collection<Places> placesCollection) {
        this.placesCollection = placesCollection;
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
        hash += (stateID != null ? stateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.stateID == null && other.stateID != null) || (this.stateID != null && !this.stateID.equals(other.stateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.State[ stateID=" + stateID + " ]";
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
}

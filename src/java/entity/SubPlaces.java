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
@Table(name = "sub places")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubPlaces.findAll", query = "SELECT s FROM SubPlaces s"),
    @NamedQuery(name = "SubPlaces.findBySubPlaceID", query = "SELECT s FROM SubPlaces s WHERE s.subPlaceID = :subPlaceID"),
    @NamedQuery(name = "SubPlaces.findBySubPlaceName", query = "SELECT s FROM SubPlaces s WHERE s.subPlaceName = :subPlaceName"),
    @NamedQuery(name = "SubPlaces.findByDescription", query = "SELECT s FROM SubPlaces s WHERE s.description = :description")})
public class SubPlaces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SubPlaceID")
    private Integer subPlaceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SubPlaceName")
    private String subPlaceName;
    @Size(max = 2000)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "PlaceID", referencedColumnName = "PlaceID")
    @ManyToOne(optional = false)
    private Places placeID;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private Category categoryID;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private State stateID;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City cityID;

    public SubPlaces() {
    }

    public SubPlaces(Integer subPlaceID) {
        this.subPlaceID = subPlaceID;
    }

    public SubPlaces(Integer subPlaceID, String subPlaceName) {
        this.subPlaceID = subPlaceID;
        this.subPlaceName = subPlaceName;
    }

    public Integer getSubPlaceID() {
        return subPlaceID;
    }

    public void setSubPlaceID(Integer subPlaceID) {
        this.subPlaceID = subPlaceID;
    }

    public String getSubPlaceName() {
        return subPlaceName;
    }

    public void setSubPlaceName(String subPlaceName) {
        this.subPlaceName = subPlaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Places getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Places placeID) {
        this.placeID = placeID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
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
        hash += (subPlaceID != null ? subPlaceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubPlaces)) {
            return false;
        }
        SubPlaces other = (SubPlaces) object;
        if ((this.subPlaceID == null && other.subPlaceID != null) || (this.subPlaceID != null && !this.subPlaceID.equals(other.subPlaceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubPlaces[ subPlaceID=" + subPlaceID + " ]";
    }
    
}

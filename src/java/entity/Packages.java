/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Radhika Maniya
 */
@Entity
@Table(name = "packages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findByPackageID", query = "SELECT p FROM Packages p WHERE p.packageID = :packageID"),
    @NamedQuery(name = "Packages.findByPackageName", query = "SELECT p FROM Packages p WHERE p.packageName = :packageName"),
    @NamedQuery(name = "Packages.findByNoOfDays", query = "SELECT p FROM Packages p WHERE p.noOfDays = :noOfDays"),
    @NamedQuery(name = "Packages.findByNoOfNights", query = "SELECT p FROM Packages p WHERE p.noOfNights = :noOfNights"),
    @NamedQuery(name = "Packages.findByPackageCharge", query = "SELECT p FROM Packages p WHERE p.packageCharge = :packageCharge"),
    @NamedQuery(name = "Packages.findByFromDate", query = "SELECT p FROM Packages p WHERE p.fromDate = :fromDate"),
    @NamedQuery(name = "Packages.findByToDate", query = "SELECT p FROM Packages p WHERE p.toDate = :toDate"),
    @NamedQuery(name = "Packages.findByImage1", query = "SELECT p FROM Packages p WHERE p.image1 = :image1"),
    @NamedQuery(name = "Packages.findByImage2", query = "SELECT p FROM Packages p WHERE p.image2 = :image2"),
    @NamedQuery(name = "Packages.findByImage3", query = "SELECT p FROM Packages p WHERE p.image3 = :image3"),
    @NamedQuery(name = "Packages.findByImage4", query = "SELECT p FROM Packages p WHERE p.image4 = :image4"),
    @NamedQuery(name = "Packages.findByScheduleDescription", query = "SELECT p FROM Packages p WHERE p.scheduleDescription = :scheduleDescription")})
public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PackageID")
    private Integer packageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PackageName")
    private String packageName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfDays")
    private int noOfDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoOfNights")
    private int noOfNights;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PackageCharge")
    private int packageCharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FromDate")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ToDate")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Image1")
    private String image1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Image2")
    private String image2;
    @Size(max = 50)
    @Column(name = "Image3")
    private String image3;
    @Size(max = 50)
    @Column(name = "Image4")
    private String image4;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ScheduleDescription")
    private String scheduleDescription;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private Category categoryID;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private State stateID;
    @JoinColumn(name = "BusID", referencedColumnName = "BusID")
    @ManyToOne(optional = false)
    private Busdetails busID;
    @JoinColumn(name = "HotelID", referencedColumnName = "HotelID")
    @ManyToOne(optional = false)
    private Managehotel hotelID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageID")
    private Collection<Packagebooking> packagebookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageID")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageID")
    private Collection<Packagerating> packageratingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageID")
    private Collection<Cancelbooking> cancelbookingCollection;

    public Packages() {
    }

    public Packages(Integer packageID) {
        this.packageID = packageID;
    }

    public Packages(Integer packageID, String packageName, int noOfDays, int noOfNights, int packageCharge, Date fromDate, Date toDate, String image1, String image2) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.noOfDays = noOfDays;
        this.noOfNights = noOfNights;
        this.packageCharge = packageCharge;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.image1 = image1;
        this.image2 = image2;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public void setPackageID(Integer packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public int getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(int noOfNights) {
        this.noOfNights = noOfNights;
    }

    public int getPackageCharge() {
        return packageCharge;
    }

    public void setPackageCharge(int packageCharge) {
        this.packageCharge = packageCharge;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        this.scheduleDescription = scheduleDescription;
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

    public Busdetails getBusID() {
        return busID;
    }

    public void setBusID(Busdetails busID) {
        this.busID = busID;
    }

    public Managehotel getHotelID() {
        return hotelID;
    }

    public void setHotelID(Managehotel hotelID) {
        this.hotelID = hotelID;
    }

    @XmlTransient
    public Collection<Packagebooking> getPackagebookingCollection() {
        return packagebookingCollection;
    }

    public void setPackagebookingCollection(Collection<Packagebooking> packagebookingCollection) {
        this.packagebookingCollection = packagebookingCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<Packagerating> getPackageratingCollection() {
        return packageratingCollection;
    }

    public void setPackageratingCollection(Collection<Packagerating> packageratingCollection) {
        this.packageratingCollection = packageratingCollection;
    }

    @XmlTransient
    public Collection<Cancelbooking> getCancelbookingCollection() {
        return cancelbookingCollection;
    }

    public void setCancelbookingCollection(Collection<Cancelbooking> cancelbookingCollection) {
        this.cancelbookingCollection = cancelbookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageID != null ? packageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.packageID == null && other.packageID != null) || (this.packageID != null && !this.packageID.equals(other.packageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Packages[ packageID=" + packageID + " ]";
    }
    
}

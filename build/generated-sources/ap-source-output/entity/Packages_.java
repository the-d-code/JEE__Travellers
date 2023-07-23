package entity;

import entity.Busdetails;
import entity.Cancelbooking;
import entity.Category;
import entity.Managehotel;
import entity.Packagebooking;
import entity.Packagerating;
import entity.Payment;
import entity.State;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Packages.class)
public class Packages_ { 

    public static volatile SingularAttribute<Packages, Busdetails> busID;
    public static volatile SingularAttribute<Packages, String> image3;
    public static volatile SingularAttribute<Packages, String> image4;
    public static volatile SingularAttribute<Packages, Integer> packageCharge;
    public static volatile CollectionAttribute<Packages, Packagerating> packageratingCollection;
    public static volatile SingularAttribute<Packages, Date> toDate;
    public static volatile SingularAttribute<Packages, State> stateID;
    public static volatile SingularAttribute<Packages, Integer> packageID;
    public static volatile SingularAttribute<Packages, Managehotel> hotelID;
    public static volatile SingularAttribute<Packages, String> image1;
    public static volatile SingularAttribute<Packages, String> image2;
    public static volatile CollectionAttribute<Packages, Payment> paymentCollection;
    public static volatile SingularAttribute<Packages, Integer> noOfDays;
    public static volatile SingularAttribute<Packages, Date> fromDate;
    public static volatile SingularAttribute<Packages, String> scheduleDescription;
    public static volatile CollectionAttribute<Packages, Cancelbooking> cancelbookingCollection;
    public static volatile SingularAttribute<Packages, Integer> noOfNights;
    public static volatile CollectionAttribute<Packages, Packagebooking> packagebookingCollection;
    public static volatile SingularAttribute<Packages, String> packageName;
    public static volatile SingularAttribute<Packages, Category> categoryID;

}
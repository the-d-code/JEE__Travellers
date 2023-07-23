package entity;

import entity.Packages;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Packagebooking.class)
public class Packagebooking_ { 

    public static volatile SingularAttribute<Packagebooking, Integer> packageBookingID;
    public static volatile SingularAttribute<Packagebooking, Integer> contactNumber;
    public static volatile SingularAttribute<Packagebooking, Packages> packageID;
    public static volatile SingularAttribute<Packagebooking, Integer> noOfTravelers;
    public static volatile SingularAttribute<Packagebooking, String> emailID;
    public static volatile SingularAttribute<Packagebooking, Date> bookingDate;
    public static volatile SingularAttribute<Packagebooking, User> userID;

}
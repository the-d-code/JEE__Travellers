package entity;

import entity.Packages;
import entity.Payment;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Cancelbooking.class)
public class Cancelbooking_ { 

    public static volatile SingularAttribute<Cancelbooking, String> reasonForCancel;
    public static volatile SingularAttribute<Cancelbooking, Date> date;
    public static volatile SingularAttribute<Cancelbooking, Payment> paymentID;
    public static volatile SingularAttribute<Cancelbooking, Packages> packageID;
    public static volatile SingularAttribute<Cancelbooking, User> userID;
    public static volatile SingularAttribute<Cancelbooking, Integer> cancelBookingID;

}
package entity;

import entity.Cancelbooking;
import entity.Packages;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Date> date;
    public static volatile SingularAttribute<Payment, Integer> amount;
    public static volatile SingularAttribute<Payment, String> bankIFSC;
    public static volatile CollectionAttribute<Payment, Cancelbooking> cancelbookingCollection;
    public static volatile SingularAttribute<Payment, Integer> paymentID;
    public static volatile SingularAttribute<Payment, Integer> accountNo;
    public static volatile SingularAttribute<Payment, Packages> packageID;
    public static volatile SingularAttribute<Payment, User> userID;

}
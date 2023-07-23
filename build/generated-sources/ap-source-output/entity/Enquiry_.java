package entity;

import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Enquiry.class)
public class Enquiry_ { 

    public static volatile SingularAttribute<Enquiry, Long> contactNumber;
    public static volatile SingularAttribute<Enquiry, String> emailID;
    public static volatile SingularAttribute<Enquiry, Integer> enquiryID;
    public static volatile SingularAttribute<Enquiry, String> message;
    public static volatile SingularAttribute<Enquiry, User> userID;

}
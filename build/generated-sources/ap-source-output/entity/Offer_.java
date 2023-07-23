package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Offer.class)
public class Offer_ { 

    public static volatile SingularAttribute<Offer, String> offerName;
    public static volatile SingularAttribute<Offer, Boolean> isSpecial;
    public static volatile SingularAttribute<Offer, Integer> price;
    public static volatile SingularAttribute<Offer, Integer> offerID;
    public static volatile SingularAttribute<Offer, String> description;

}
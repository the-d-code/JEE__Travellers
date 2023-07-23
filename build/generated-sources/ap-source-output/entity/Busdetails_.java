package entity;

import entity.City;
import entity.Packages;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Busdetails.class)
public class Busdetails_ { 

    public static volatile SingularAttribute<Busdetails, Integer> busID;
    public static volatile SingularAttribute<Busdetails, String> image3;
    public static volatile CollectionAttribute<Busdetails, Packages> packagesCollection;
    public static volatile SingularAttribute<Busdetails, String> busName;
    public static volatile SingularAttribute<Busdetails, String> description;
    public static volatile SingularAttribute<Busdetails, City> fromCityID;
    public static volatile SingularAttribute<Busdetails, Integer> availableSeat;
    public static volatile SingularAttribute<Busdetails, String> image1;
    public static volatile SingularAttribute<Busdetails, Integer> costPerSeat;
    public static volatile SingularAttribute<Busdetails, String> image2;
    public static volatile SingularAttribute<Busdetails, Integer> totalSeats;
    public static volatile SingularAttribute<Busdetails, City> toCityID;

}
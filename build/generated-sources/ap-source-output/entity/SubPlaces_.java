package entity;

import entity.Category;
import entity.City;
import entity.Places;
import entity.State;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(SubPlaces.class)
public class SubPlaces_ { 

    public static volatile SingularAttribute<SubPlaces, String> subPlaceName;
    public static volatile SingularAttribute<SubPlaces, State> stateID;
    public static volatile SingularAttribute<SubPlaces, Places> placeID;
    public static volatile SingularAttribute<SubPlaces, Integer> subPlaceID;
    public static volatile SingularAttribute<SubPlaces, String> description;
    public static volatile SingularAttribute<SubPlaces, City> cityID;
    public static volatile SingularAttribute<SubPlaces, Category> categoryID;

}
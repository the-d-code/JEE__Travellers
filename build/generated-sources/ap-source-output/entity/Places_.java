package entity;

import entity.Category;
import entity.State;
import entity.SubPlaces;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Places.class)
public class Places_ { 

    public static volatile SingularAttribute<Places, State> stateID;
    public static volatile SingularAttribute<Places, Integer> placeID;
    public static volatile CollectionAttribute<Places, SubPlaces> subPlacesCollection;
    public static volatile SingularAttribute<Places, String> description;
    public static volatile SingularAttribute<Places, String> placeName;
    public static volatile SingularAttribute<Places, Category> categoryID;

}
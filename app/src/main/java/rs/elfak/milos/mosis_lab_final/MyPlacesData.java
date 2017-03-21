package rs.elfak.milos.mosis_lab_final;

import java.util.ArrayList;

/**
 * Created by Milos on 3/20/2017.
 */
public class MyPlacesData {
    private ArrayList<MyPlace> myPlaces;


    public MyPlacesData(){
        myPlaces = new ArrayList<MyPlace>();
        myPlaces.add(new MyPlace("Place A"));
        myPlaces.add(new MyPlace("Place B"));
        myPlaces.add(new MyPlace("Place C"));
        myPlaces.add(new MyPlace("Place D"));
    }

    private static class SingletonHolder{
        public static final MyPlacesData instance = new MyPlacesData();
    }

    public static MyPlacesData getInstance(){
        return SingletonHolder.instance;
    }

    public ArrayList<MyPlace> getMyPlaces(){
        return myPlaces;
    }

    public void AddNewPlace(MyPlace place){
        this.myPlaces.add(place);
    }

    public MyPlace getPlace(int index){
        return this.myPlaces.get(index);
    }

    public void DeletePlace(int index){
        myPlaces.remove(index);
    }
}

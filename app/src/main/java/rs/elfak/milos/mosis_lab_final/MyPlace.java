package rs.elfak.milos.mosis_lab_final;

/**
 * Created by Milos on 3/20/2017.
 */
public class MyPlace {
    String name;
    String description;
    String longitude;
    String latitude;
    long ID;


    public MyPlace (String nme, String descr)
    {
        this.name = nme;
        this.description = descr;
    }

    public MyPlace(String nme){
        this.name = nme;
        this.description = "";
    }

    public String getName(){
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String nme){
        this.name = nme;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

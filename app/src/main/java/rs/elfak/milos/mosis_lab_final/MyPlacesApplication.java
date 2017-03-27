package rs.elfak.milos.mosis_lab_final;

import android.app.Application;
import android.content.Context;

/**
 * Created by Milos on 3/27/2017.
 */

public class MyPlacesApplication extends Application {
    private static MyPlacesApplication instance;

    public MyPlacesApplication()
    {

    }

    public static Context getContext()
    {
        return instance;
    }


}

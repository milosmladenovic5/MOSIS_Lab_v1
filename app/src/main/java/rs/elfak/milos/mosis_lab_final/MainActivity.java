package rs.elfak.milos.mosis_lab_final;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int NEW_PLACE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.show_map_item) {
            Toast.makeText(this, "Show map!", Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.about_item) {
           Intent i = new Intent(this,About.class);
            startActivity(i);
        }
        else if(id==R.id.new_place_item)
        {
            Intent i = new Intent(this, EditMyPlace.class);
            startActivityForResult(i,NEW_PLACE);
        }
        else if(id==R.id.my_places_list_item)
        {
            Intent i = new Intent(this,MyPlacesList.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK)
        {
            Toast.makeText(this,"New place added",Toast.LENGTH_SHORT).show();
        }
    }
}

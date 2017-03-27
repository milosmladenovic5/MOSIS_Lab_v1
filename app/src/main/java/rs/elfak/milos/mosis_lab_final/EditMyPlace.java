package rs.elfak.milos.mosis_lab_final;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMyPlace extends AppCompatActivity implements View.OnClickListener, View.OnCreateContextMenuListener{
    boolean editMode = true;
    int position =-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_place);


        Intent callingIntent = getIntent();
        Bundle positionBundle = callingIntent.getExtras();

        if(positionBundle!=null){
            position = positionBundle.getInt("position");
            editMode = true;
        }
        else{
            editMode = false;
        }

        final Button finishedButton = (Button) findViewById(R.id.editmyplace_finished_button);
        finishedButton.setOnClickListener(this);


        Button cancelButton = (Button) findViewById(R.id.editmyplace_cancel_button);
        cancelButton.setOnClickListener(this);

        EditText editNameText = (EditText)findViewById(R.id.editmyplace_name_edit);
        EditText editDescText = (EditText)findViewById(R.id.editmyplace_desc_edit);

        if(editMode==false){
            finishedButton.setEnabled(false);
            finishedButton.setText("Add");
        }
        else if(position>=0){
            finishedButton.setEnabled(true);
            finishedButton.setText("Save");
            MyPlace place = MyPlacesData.getInstance().getPlace(position);
            editNameText.setText(place.name);
            editDescText.setText(place.description);

        }


        editNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                finishedButton.setEnabled(s.length()>1);
            }
        });
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

        if(id==R.id.show_map_item)
            Toast.makeText(this,"Show map!", Toast.LENGTH_SHORT);
        else if (id==R.id.about_item) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }
        else if(id==R.id.my_places_list_item)
        {
            Intent i = new Intent(this,MyPlacesList.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.editmyplace_finished_button:
                EditText etName = (EditText)findViewById(R.id.editmyplace_name_edit);
                String nme = etName.getText().toString();

                EditText descName = (EditText)findViewById(R.id.editmyplace_desc_edit);
                String descr =  descName.getText().toString();

                EditText latName = (EditText) findViewById(R.id.editmyplace_lat_edit);
                String latitude = latName.getText().toString();

                EditText longName = (EditText) findViewById(R.id.editmyplace_long_edit);
                String longitude = longName.getText().toString();


                if(!editMode)
                {
                    MyPlace place = new MyPlace(nme,descr);
                    place.setLongitude(longitude);
                    place.setLatitude(latitude);
                    MyPlacesData.getInstance().AddNewPlace(place);
                }
                else
                {
                    MyPlace place =  MyPlacesData.getInstance().getPlace(position);
                    place.setName(nme);
                    place.setDescription(descr);
                    place.setLatitude(latitude);
                    place.setLongitude(longitude);
                    MyPlacesData.getInstance().updatePlace(place);
                }
                
                setResult(Activity.RESULT_OK);
                finish();
                break;
            case R.id.editmyplace_cancel_button:
                setResult(Activity.RESULT_CANCELED);
                finish();
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}

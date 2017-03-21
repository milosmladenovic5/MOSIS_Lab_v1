package rs.elfak.milos.mosis_lab_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewMyPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_place);
        int position = -1;

        try {
            Intent listIntent = getIntent();
            Bundle positionBundle = listIntent.getExtras();
            position = positionBundle.getInt("position");
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }

        if (position >= 0)
        {
            MyPlace place = MyPlacesData.getInstance().getPlace(position);
            TextView placeName = (TextView) findViewById(R.id.viewmyplace_name_text);
            placeName.setText(place.getName());

            TextView placeDesc  = (TextView) findViewById(R.id.viewmyplace_desc_text);
            placeDesc.setText(place.getDescription());
        }

        final Button finishedButton = (Button) findViewById(R.id.viewmyplace_finished_button);
        finishedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

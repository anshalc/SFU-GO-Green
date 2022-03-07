package com.example.sfugogreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MapActivity extends AppCompatActivity {

    // references to the UI elements
    TextView    t_latitude, ct_latitude, t_longitude, ct_longitude, location_name;

    ImageButton next_button, previous_button,location_button, green_button, black_button,
                orange_button, blue_button;

    ImageView   map_button;

    Button btShow;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //assigning UI elements to the variables
        t_latitude = findViewById(R.id.Latitude);
        ct_latitude = findViewById(R.id.currentLatitude);
        t_longitude = findViewById(R.id.Longitude);
        ct_longitude = findViewById(R.id.currentLongitude);
        location_name = findViewById(R.id.locationText);
        map_button = findViewById(R.id.actualMapButton);
        next_button = findViewById(R.id.nextButton);
        previous_button = findViewById(R.id.previousButton);
        location_button = findViewById(R.id.locationButton);
        green_button = findViewById(R.id.greenButton);
        blue_button = findViewById(R.id.blueButton);
        black_button = findViewById(R.id.blackButton);
        orange_button = findViewById(R.id.orangeButton);


        //information on yellow bin
        orange_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MapActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog3);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();

            }
        });

        //information on blue bin
        blue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MapActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog2);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();

            }
        });

        //information on black bin
        black_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MapActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog1);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();

            }
        });

        //information on green bin
        green_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MapActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog4);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();
            }
        });


        //To access the user location
        ActivityCompat.requestPermissions(MapActivity.this,new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},123);

        //To get the latitudes,longitudes and premise of the user
        GPStracker g = new GPStracker(getApplicationContext());
        Location l = g.getLocation();

        double lat = l.getLatitude();
        double lon = l.getLongitude();

        //Google API to get address using the latitude and longitude
        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(lat, lon, 1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String premise = addresses.get(0).getPremises();

        //to assign latitude, longitude and the premise to the UI
        location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ct_latitude.setText(String.valueOf(lat));
                ct_longitude.setText(String.valueOf(lon));
                location_name.setText(String.valueOf(premise));
            }
        });

        //to get the shortlisted images of the map;
        getMapImages m = new getMapImages(premise);

        //to get to the next shortlisted image
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map_button.setImageResource(m.drawable[i]);
                i++;
                if(i==m.drawable.length)
                    i = 0;
            }
        });

        //to get to the previous shortlisted image
        previous_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map_button.setImageResource(m.drawable[i]);
                if(i == 0)
                {
                    i = m.drawable.length;
                }
                i--;
            }
        });

    }
}
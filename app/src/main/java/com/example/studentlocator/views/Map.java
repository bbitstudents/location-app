package com.example.studentlocator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentlocator.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback {
private GoogleMap mMap;
private String studentName;
private String hostelName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent receivedIntent=getIntent();
        studentName=receivedIntent.getStringExtra("student");
//        received hostel coordinates
        hostelName=receivedIntent.getStringExtra("hostelName");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    /**
     * Map of taita taveta universiy
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
//        LatLng ttu = new LatLng(-3.419265, 38.503615);
        if (hostelName=="BLOCK E"){
            LatLng ttu = new LatLng(-3.4188149287425387, 38.503260668532086);

//        LatLng ttu = new LatLng(-3.419265, 38.503615);
//        mMap.setMinZoomPreference(15);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
        //        the following if statement is hardcoded
        if (hostelName=="BLOCK E"){
            LatLng ttu = new LatLng(-3.4186249048281327, 38.502599093933476);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
        if (hostelName=="BLOCK F"){
            LatLng ttu = new LatLng(-3.4185977602259396, 38.50301226098268);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
        if (hostelName=="Mwangeka"){
            LatLng ttu = new LatLng(-3.418981474097939, 38.503742252380775);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
        if (hostelName=="Mekatilili"){
            LatLng ttu = new LatLng(-3.4185379204118913,  38.50316131928332);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
        if (hostelName=="Runda"){
            LatLng ttu = new LatLng( -3.4197450077881224, 38.50253659525014);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }

        if (hostelName=="BLOCK A"){
            LatLng ttu = new LatLng(-3.4192670857557914, 38.50443685523095);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }

        if (hostelName=="BLOCK B"){
            LatLng ttu = new LatLng(-3.420302906030167, 38.50183319646997);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }

        if (hostelName=="BLOCK C"){
            LatLng ttu = new LatLng(-3.419819352400741, 38.50314997553838);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
        else {
            LatLng ttu = new LatLng(-3.419849733395809, 38.503155255605506);
            mMap.addMarker(new MarkerOptions().position(ttu).title("Click continually to locate your colleague "+studentName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ttu));
        }
    }
}

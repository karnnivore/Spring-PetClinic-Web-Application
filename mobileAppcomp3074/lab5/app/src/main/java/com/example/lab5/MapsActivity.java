package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private EditText locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationText = findViewById(R.id.location_text);
        Button btn = findViewById(R.id.btn_location);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = locationText.getText().toString();
                if (!name.isEmpty()) {
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> list = geocoder.getFromLocationName(name, 1);
                        if (list != null && !list.isEmpty()) {
                            Address a = list.get(0);
                            LatLng location = new LatLng(a.getLatitude(), a.getLongitude());
                            if (mMap != null) {
                                //adds new marker to the map
                                mMap.addMarker(new MarkerOptions().position(location).title(name));
                                //mMap.animateCamera(CameraUpdateFactory.newLatLng(location));
                                //displays the marker
                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //we have permission
            getLocation();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode ==1
            &&permissions.length ==1
            &&permissions[0]==Manifest.permission.ACCESS_FINE_LOCATION
            &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            //we have permisison
            getLocation();
        }else {
            Log.d("PERMISSION", "Permission denied");
        }
    }
    void getLocation() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //we have permission
            LocationManager locationManager =
                    (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            String provider = LocationManager.GPS_PROVIDER;
            //get Permisison to use location services
            if (!locationManager.isProviderEnabled(provider)){
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }

            Location location = locationManager.getLastKnownLocation(provider);
            if(mMap!= null) {
                LatLng pos = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(pos).title("Last Known Position"));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(pos));
            }

            locationManager.requestLocationUpdates(provider, 100, 1, this);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng clc = new LatLng(43.6761344,-79.4106897);
        mMap.addMarker(new MarkerOptions().position(clc).title("Casa Loma Campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(clc, 17));
        getLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getLocation();
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(mMap!= null) {
            LatLng pos = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(pos).title("Last Known Position"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(pos));
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}
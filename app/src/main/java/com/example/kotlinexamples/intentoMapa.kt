package com.example.kotlinexamples


import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class intentoMapa : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private lateinit var userLocation: FusedLocationProviderClient;
    private lateinit var lastLocation: Location;

    companion object{
        private const val permisoDeLocalizacion = 1;
    }


    private lateinit var map: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intento_mapa)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        userLocation = LocationServices.getFusedLocationProviderClient(this)


    }

    override fun onMarkerClick(p0: Marker?) = false;


    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap

        map.setOnMarkerClickListener (this)
        map.uiSettings.isZoomControlsEnabled = true
        setUpMap()
    }

private fun placeMarcker(location: LatLng){

val marckerOption = MarkerOptions().position(location)
    marckerOption.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))

    map.addMarker(marckerOption)

}


    private fun setUpMap(){

        if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                 intentoMapa.permisoDeLocalizacion
            )
            return
        }
       map.isMyLocationEnabled = true;
        userLocation.lastLocation.addOnSuccessListener ( this){location ->
            
            if(location != null){
                lastLocation = location
                val currentLatLong = LatLng(location.latitude, location.longitude)

                placeMarcker(currentLatLong)

                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong,13f))

            }

        }
    }
}

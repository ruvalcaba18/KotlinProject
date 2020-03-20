package com.example.kotlinexamples

import android.os.AsyncTask
import com.google.android.gms.maps.GoogleMap


class GetNearbyPlacesData : AsyncTask<Object,String,String>() {

    var nerDataPlaces: String = "";
    private lateinit var mapa : GoogleMap;
    var url: String = "";



    override fun doInBackground(vararg p0: Object?): String {
        TODO("not implemented")
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }

}
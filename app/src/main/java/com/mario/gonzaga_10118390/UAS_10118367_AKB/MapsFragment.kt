
package com.mario.gonzaga_10118390.UAS_10118367_AKB

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.*
import com.jovanovic.stefan.UAS_10118367_AKB.R


// 12-08-2021 - 10118390 - Mario Gonzaga Muharjani - IF9


class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mDatabase: DatabaseReference
    private var markerList = mutableListOf<Marker?>()
    private var mapsModelList = mutableListOf<MapsModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_maps, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mDatabase = FirebaseDatabase.getInstance().reference
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        // Add a marker in Tangkuban Perahu and move the camera

        /** Add a marker in Tangkuban Perahu and move the camera
        val sydney = LatLng(-6.75869989624159, 107.60952315730118)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Tangkunan Perahu"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val melbourneLatLng = LatLng(-6.75869989624159, 107.60952315730118)
        val melbourne = mMap.addMarker(
            MarkerOptions()
                .position(melbourneLatLng)
                .title("Melbourne")
                .snippet("Population: 4,137,400")
        )
        melbourne?.showInfoWindow()
        */

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-6.914744, 107.609810), 10.0f))

        mDatabase.child("tempatwisata").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                p0.toException().printStackTrace()
            }

            override fun onDataChange(p0: DataSnapshot) {
                p0.children.forEach {dataSnapshot ->
                    val mapsModel = dataSnapshot.getValue(MapsModel::class.java) as MapsModel
                    mapsModelList.add(mapsModel)
                    val longLat = LatLng(mapsModel.latitude, mapsModel.longitude)
                    markerList.add(
                        mMap.addMarker(MarkerOptions().position(longLat).title(mapsModel.nama))
                    )

                }

            }

        })

        // add on click listerner for marker on maps
        mMap.setOnMarkerClickListener { markerMap ->
            markerList.forEachIndexed { index, marker ->
                if (markerMap == marker){
                    val intent = Intent(requireContext(), DetailActivity::class.java)
                    intent.putExtra("mapsModel", mapsModelList[index])
                    startActivity(intent)
                }
            }
            true
        }
    }
}
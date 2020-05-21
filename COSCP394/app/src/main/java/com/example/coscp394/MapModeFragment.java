package com.example.coscp394;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapModeFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap mMap;
    boolean buy;

    public MapModeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle b = this.getArguments();
        buy = b.getBoolean("buy");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        mapView = new MapView (getContext());
        View v = inflater.inflate(R.layout.fragment_buy_map, container, false);
        mapView = v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        if (mapView != null)
            mapView.getMapAsync(this);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (mapView != null)
            mapView.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latbrock = new LatLng(43.1175731,-79.2476925);
        LatLng lathouse = new LatLng(43.1175720,-79.2472234);
        Marker brock = mMap.addMarker(new MarkerOptions().position(latbrock).title("House One"));
        Marker house = mMap.addMarker(new MarkerOptions().position(lathouse).title("House Two"));
        mMap.setMinZoomPreference(6);
        mMap.setMaxZoomPreference(20);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latbrock,15));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                if (marker.getTitle().equalsIgnoreCase("House One"))
                    marker.setSnippet("$4,000,000");
                else
                    marker.setSnippet("$2,500,000");

                return false;
            }
        });
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker)
            {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("buy",buy);
                startActivity(intent);
            }
        });
    }
}

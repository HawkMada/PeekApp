package com.example.coscp394;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.coscp394.MainActivity.rentLocations;
import static com.example.coscp394.MainActivity.rentPrices;
import static com.example.coscp394.MainActivity.rent_images;


public class RentFragment extends Fragment {

    Button filterButton;
    ListView listView;
    ImageButton mapMode;

    public RentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_rent, container, false);

        mapMode = v.findViewById(R.id.mapmode_rent);
        mapMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle b = new Bundle();
                b.putBoolean("buy", false);
                MapModeFragment mmf = new MapModeFragment();
                mmf.setArguments(b);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mmf)
                        .addToBackStack("return").commit();
            }
        });

        listView = v.findViewById(R.id.listview_rent);
        CustomAdapter2 customAdapter2 = new CustomAdapter2();
        listView.setAdapter(customAdapter2);
        filterButton = v.findViewById(R.id.rent_filterbutton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putBoolean("buy", false);
                FilterFragment ff = new FilterFragment();
                ff.setArguments(b);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ff)
                        .addToBackStack("return").commit();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("buy", false);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart()
    {
        super.onStart();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

class CustomAdapter2 extends BaseAdapter {

    @Override
    public int getCount() {
        return rent_images.length;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customlayout, parent, false);
        }

        ImageView imageView= view.findViewById(R.id.imageview_buy);
        TextView textView_location= view.findViewById(R.id.textView_location);
        TextView textView_price= view.findViewById(R.id.textView_price);

        imageView.setImageResource(rent_images[position]);
        textView_location.setText(rentLocations[position]);
        textView_price.setText(rentPrices[position]);

        return view;
    }
}
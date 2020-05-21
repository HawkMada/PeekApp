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

import static com.example.coscp394.MainActivity.houseLocations;
import static com.example.coscp394.MainActivity.housePrices;
import static com.example.coscp394.MainActivity.images;


public class BuyFragment extends Fragment {

    Button filterButton;
    ListView listView;
    ImageButton mapMode;

    public BuyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_buy, container, false);

        mapMode = v.findViewById(R.id.mapmode);
        mapMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle b = new Bundle();
                b.putBoolean("buy", true);
                MapModeFragment mmf = new MapModeFragment();
                mmf.setArguments(b);
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mmf)
                       .addToBackStack("return").commit();
            }
        });

        listView = v.findViewById(R.id.listview_buy);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        filterButton = v.findViewById(R.id.buy_filterbutton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putBoolean("buy", true);
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
                intent.putExtra("buy", true);
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
    public void onDetach() {
        super.onDetach();
    }

}
class CustomAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return images.length;
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

        imageView.setImageResource(images[position]);
        textView_location.setText(houseLocations[position]);
        textView_price.setText(housePrices[position]);

        return view;
    }
}
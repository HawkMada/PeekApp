package com.example.coscp394;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FilterFragment extends Fragment {

    Button applyButton;
    boolean buy;

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        buy = bundle.getBoolean("buy");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_filter, container, false);

        applyButton = v.findViewById(R.id.apply_button);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BuyFragment()).addToBackStack("return").commit();
            }
        });

        EditText min = v.findViewById(R.id.minPrice);
        EditText max = v.findViewById(R.id.maxPrice);
        TextView mintv = v.findViewById(R.id.minPriceTV);
        TextView maxtv = v.findViewById(R.id.maxPriceTV);


        if (!buy)
        {
            min.setText("100");
            max.setText("1,000");
            mintv.setText("Min Price ($/mo)");
            maxtv.setText("Max Price ($/mo)");
        }


        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void goBack(View view)
    {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,new BuyFragment()).commit();
    }
}


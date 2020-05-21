package com.example.coscp394;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int[] images = {R.drawable.houseone, R.drawable.housetwo, R.drawable.housethree, R.drawable.housefour, R.drawable.housefive, R.drawable.housesix, R.drawable.houseseven, R.drawable.houseeight, R.drawable.housenine, R.drawable.houseten};
    public static int[] rent_images = {R.drawable.houseone, R.drawable.housethree, R.drawable.housefive, R.drawable.housesix, R.drawable.houseseven, R.drawable.houseeight, R.drawable.housenine, R.drawable.houseten};
    public static String[] houseLocations = {"Milton, ON","Burlington, ON", "Oakville, ON", "Oakville, ON", "Burlington, ON", "Milton, ON", "Oakville, ON", "Stoney Creek, ON", "Lincoln, ON", "Niagara-On-The-Lake, ON"};
    public static String[] rentLocations = {"Milton, ON", "Oakville, ON", "Burlington, ON", "Milton, ON", "Oakville, ON", "Stoney Creek, ON", "Lincoln, ON", "Niagara-On-The-Lake, ON"};
    public static String[] housePrices = {"$425,000", "$720,000", "$1,250,000", "$850,000", "$1,850,000", "$1,125,000", "$680,000", "$505,000", "$430,000", "$930,000"};
    public static String[] rentPrices = {"$1,000/month", "$700/month", "$2,500/month", "$5,000/month", "$850/month", "$1,250/month", "$4,000/month", "$2,400/month"};

    private TextView mTextMessage;
    private FrameLayout layout;
    private Button filterButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_buy:
                    selectedFragment = new BuyFragment();
                    break;
                case R.id.navigation_rent:
                    selectedFragment = new RentFragment();
                    break;
                case R.id.navigation_sell:
                    selectedFragment = new SellFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterButton = super.findViewById(R.id.buy_filterbutton);
        layout = super.findViewById(R.id.fragment_container);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new BuyFragment()).commit();

    }
}

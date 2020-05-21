package com.example.coscp394;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends Activity {

    Button contactseller;
    CheckBox fav;
    boolean savestate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean b = getIntent().getExtras().getBoolean("buy");
        setContentView(R.layout.activity_details);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        savestate = sharedPref.getBoolean("isfave",false);
        TextView tv = findViewById(R.id.detail_price);
        fav = findViewById(R.id.favourite);
        fav.setChecked(savestate);
        if (!b)
            tv.setText("$1,000/month");

        contactseller = findViewById(R.id.contact_seller);
        contactseller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","abc@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Interested in your home");
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hi, " +
                        " \n" +
                        " \n" +
                        "Is your home still for sale?");
                String[] addresses = new String [1];
                addresses[0] = "abc@gmail.com";
                emailIntent.putExtra(Intent.EXTRA_EMAIL, addresses); // String[] addresses
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("isfave", fav.isChecked());
        editor.apply();
    }
}

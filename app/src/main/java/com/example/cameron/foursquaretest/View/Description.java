package com.example.cameron.foursquaretest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cameron.foursquaretest.R;

/**
 * Created by Cameron on 28/02/2016.
 */
public class Description extends Activity {

    LinearLayout frameLayout;
    TextView tvName, tvRestaurant, tvDesc, tvloc;
    ImageView imgmain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        Intent intent = getIntent();

        tvName = (TextView) findViewById(R.id.name);
        tvRestaurant = (TextView) findViewById(R.id.restaurants);
        tvDesc = (TextView) findViewById(R.id.description);
        tvloc = (TextView) findViewById(R.id.loc);
        imgmain = (ImageView) findViewById(R.id.imageViewmain);
        frameLayout = (LinearLayout) findViewById(R.id.framemain);

    }
}

package com.example.cameron.foursquaretest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cameron.foursquaretest.Model.SavedList;
import com.example.cameron.foursquaretest.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Cameron on 28/02/2016.
 */
public class Description extends Activity {

    LinearLayout frameLayout;
    TextView tvName, tvRestaurant, tvDesc, tvloc;
    ImageView imgMain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position",0);

        tvName = (TextView) findViewById(R.id.name);
        tvRestaurant = (TextView) findViewById(R.id.restaurants);
        tvDesc = (TextView) findViewById(R.id.description);
        tvloc = (TextView) findViewById(R.id.loc);
        imgMain = (ImageView) findViewById(R.id.imageViewmain);
        frameLayout = (LinearLayout) findViewById(R.id.framemain);

        List<HashMap<String, String>> list;

        list = SavedList.getInstance().getList();


        tvName.setText(list.get(pos).get("name").toString());
        tvloc.setText(list.get(pos).get("location").toString());

    }
}

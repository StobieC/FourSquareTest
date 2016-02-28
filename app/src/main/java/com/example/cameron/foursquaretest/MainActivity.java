package com.example.cameron.foursquaretest;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cameron.foursquaretest.Controller.JsonToList;
import com.example.cameron.foursquaretest.Model.Constants;
import com.example.cameron.foursquaretest.adapter.MyAdapter;
import com.example.cameron.foursquaretest.app.AppController;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText search;
    RecyclerView recyclerView;
    Button buttonSearch;
    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        search = (EditText) findViewById(R.id.et_search);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        String address = search.getText().toString();

        recyclerView.setLayoutManager(layoutManager);
        buttonSearch = (Button) findViewById(R.id.button);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (search.getText() != null && search.getText().length() > 0) {
                    makeRequestJSON(search.getText().toString());

                }
            }
        });

    }

    /**
     * Recieves JSON data from foursquare api
     * @param searchtxt
     */
    void makeRequestJSON(String searchtxt)
    {
        Log.e("search for:", searchtxt);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                Constants.testurl, (String)null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("TAG RESPONSE", response.toString());
                        JsonToList jsonTOList = new JsonToList(MainActivity.this);
                        List<HashMap<String , String>> l =jsonTOList.convertjsontolist(response);
                        MyAdapter rvAdapter = new MyAdapter(l , MainActivity.this);
                        recyclerView.setAdapter(rvAdapter);

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

    }

    //Tried to convert location to Longitude and Latitude for use with finding
    /*
    buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (search.getText() != null && search.getText().length() > 0) {

                    Intent intent = new Intent(MainActivity.this, GeocodeAddressIntentService.class);
                    intent.putExtra(Constants.RECEIVER, mResultReceiver);
                    intent.putExtra(Constants.FETCH_TYPE_EXTRA, fetchType);

                    if (search.getText().length() == 0) {
                        Toast.makeText(MainActivity.this, "Please enter an address name", Toast.LENGTH_LONG).show();
                        return;
                    }
                    intent.putExtra(Constants.LOCATION_NAME_DATA_EXTRA, search.getText().toString());
                    Log.e("MainActivity", "Starting Service");
                    startService(intent);
                }

            }
        });
        }

    /*
    @SuppressLint("ParcelCreator")
    class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, final Bundle resultData) {
            if (resultCode == Constants.SUCCESS_RESULT) {
                final Address address = resultData.getParcelable(Constants.RESULT_ADDRESS);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();

                        Log.e("MainActivity", "Json");
                        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                                Constants.URL + latitude + "," + longitude, (String)null,
                                new Response.Listener<JSONObject>() {

                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Log.e("TAG RESPONSE", response.toString());
                                        JsonToList jsonTOList = new JsonToList(MainActivity.this);
                                        List<HashMap<String , String>> l =jsonTOList.convertjsontolist(response);
                                        MyAdapter rvAdapter = new MyAdapter(l , MainActivity.this);
                                        recyclerView.setAdapter(rvAdapter);

                                    }
                                }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.d("TAG", "Error: " + error.getMessage());
                            }
                        });

                        // Adding request to request queue
                        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
                    }
                });
            }
            else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }
    }*/


}


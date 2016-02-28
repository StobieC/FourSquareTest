package com.example.cameron.foursquaretest.Model;

/**
 * Created by Cameron on 28/02/2016.
 */
public class Constants {

    public static String CLIENT_ID = "client_id=R0LB4G2EP5ZKUE3NJ4MNP4EF4SI5SPO0M4OQ0WLKAQRD5ZPF";
    public static String CLIENT_SECRET = "client_secret=NNDKKUNAX4ZJ1HL0ODQDSIJ35KFDB3FFBTYCRWFR1G5PQT0T";
    public static String URL = "https://api.foursquare.com/v2/venues/search?" + CLIENT_ID + CLIENT_SECRET + "v=20130815%20&ll=40.7,-74%20&" +
            "query=";

    public static final String testurl = "https://api.foursquare.com/v2/venues/trending?ll=40.7,-74&oauth_token=13U3RHPIVFEPQ5PBVNYNBMFVNDQIKON3JHEYI2OPA5TVB4HT&v=20160228";

    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;

    public static final int USE_ADDRESS_NAME = 1;

    public static final String PACKAGE_NAME =
            "com.sample.foo.simplelocationapp";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME + ".RESULT_DATA_KEY";
    public static final String RESULT_ADDRESS = PACKAGE_NAME + ".RESULT_ADDRESS";
    public static final String LOCATION_NAME_DATA_EXTRA = PACKAGE_NAME + ".LOCATION_NAME_DATA_EXTRA";
    public static final String FETCH_TYPE_EXTRA = PACKAGE_NAME + ".FETCH_TYPE_EXTRA";
}

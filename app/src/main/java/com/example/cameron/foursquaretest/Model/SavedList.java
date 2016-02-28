package com.example.cameron.foursquaretest.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cameron on 28/02/2016.
 */
public class SavedList {

    private static SavedList savedList = new SavedList();
    private  SavedList(){}

    public List<HashMap<String, String>> getList()
    {
        return list;
    }

    public void setList(List<HashMap<String, String>> list)
    {
        this.list = list;
    }

    private List<HashMap<String, String>> list = new ArrayList<>();
    public static SavedList  getInstance()
    {
        return savedList;
    }

}

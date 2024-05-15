package com.example.realestateapp.Helper;

import android.content.Context;

import com.example.realestateapp.Domain.PropertyDomain;

import java.util.ArrayList;

public class ManageFavorite {
    private TinyDB tinyDB;

    public ManageFavorite(Context context) {
        tinyDB = new TinyDB(context); // Initialize tinyDB with the provided context
    }

    public ArrayList<PropertyDomain> insertItem(PropertyDomain item) {
        ArrayList<PropertyDomain> list = getList();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (!existAlready) {
            list.add(item);
        } else {
            list.set(n, item);
        }
        tinyDB.putListObject("Favorite List", list); // Assuming this method saves the list
        return list;
    }

    public ArrayList<PropertyDomain> getList() {
        return tinyDB.getListObject("Favorite List");
    }
}

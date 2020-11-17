package com.example.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class AdapterRate extends ArrayAdapter<Rate> {
    public AdapterRate( Context context, ArrayList<Rate> rates) {
        super(context, 0,rates);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Rate rate = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.currencylistlayout, parent, false);
        }
        // Lookup view for data population

        TextView currencyName = (TextView) convertView.findViewById(R.id.Cname);
        TextView currencyRate = (TextView) convertView.findViewById(R.id.CspotRate);
        // Populate the data into the template view using the data object

        String testtext = String.valueOf(rate.getSpotRate());
        currencyName.setText(rate.name);
        currencyRate.setText(testtext);
        // Return the completed view to render on screen

        return convertView;
    }


}

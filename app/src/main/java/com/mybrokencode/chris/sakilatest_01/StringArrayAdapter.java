package com.mybrokencode.chris.sakilatest_01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;

public class StringArrayAdapter extends BaseAdapter {

    String[] ids;
    String[] titles;
    String[] descs;
    Context c;
    LayoutInflater inflater;

    public StringArrayAdapter(String[] Ids, String[] Titles, String[] Descs, Context C) {
        this.c = C;
        this.ids = Ids;
        this.titles = Titles;
        this.descs = Descs;
        this.inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return titles[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Create the cell (View) and populate it with an element of the data.

        // Causes view to be recycled... but it's how other people do it. idk
//        if (view == null) {
            // Default view
//            view = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
//            TextView name = (TextView)view.findViewById(android.R.id.text1);
//            name.setText(titles[i]);

        // Custom view.
        view = inflater.inflate(R.layout.single_row, viewGroup, false);
        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);
        final int movie_index = i;
        final String movie_title = titles[i];
        final String movie_desc = descs[i];

        final String[] filmInfo = new String[13];
        final String[] filmValues = {"film_id", "title", "description", "release_year", "language_id", "original_language_id", "rental_duration", "rental_rate", "length", "replacement_cost", "rating", "special_features", "last_update"};

        title.setText(movie_title);
        desc.setText(movie_desc);

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    for (int j = 0; j < filmValues.length; j++) {
                        filmInfo[j] = MainActivity.jsonData.getJSONObject(movie_index).getString(filmValues[j]);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Starts new activity
                Intent intent = new Intent(c, FilmActivity.class);
//                Bundle bundle = new Bundle();
                intent.putExtra("filmInfo", filmInfo);
                c.startActivity(intent);

//                // Temp display
//                String results = "";
//                for (int j = 0; j < filmInfo.length; j++) {
//                    results += filmInfo[j] + " | ";
//                }
//                MainActivity.results.setText(results);
//                // End temp display
            }
        });
//        }

        return view;
    }
}

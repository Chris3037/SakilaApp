package com.mybrokencode.chris.sakilatest_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FilmActivity extends AppCompatActivity {

    public static TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        results = (TextView) findViewById(R.id.results);

        Intent intentExtras = getIntent();
        String[] filmInfo = intentExtras.getStringArrayExtra("filmInfo");

//        results.setText("Title: " + filmInfo[1]);

        // Temp display
        String output = "";
        for (int j = 0; j < filmInfo.length; j++) {
            output += filmInfo[j] + " | ";
        }
        results.setText(output);
        // End temp display
    }
}

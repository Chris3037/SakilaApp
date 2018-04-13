package com.mybrokencode.chris.sakilatest_01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public static Context classContext;
    public static ListView listView;
    public static JSONArray jsonData;
    public static TextView results;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view_1);
        results = (TextView) findViewById(R.id.results);
        classContext = this;

        results.setText("Fetching Data...");

        FetchJSON process = new FetchJSON();
        process.execute();
        // TODO: Make animation while waiting for data. Ie. animated ellipsis, percentage, loading bar, circle loading bar


    }
    public static void PopulateView(String data) {
        try {
            JSONObject obj1 = new JSONObject(data);
            JSONArray arr1 = obj1.getJSONArray("records");
            jsonData = obj1.getJSONArray("records");

            // TODO: Pagination using jsonData.
            int max = 10;
            if (arr1.length() < max) {
                max = arr1.length();
            }

            String[] idsArray = new String[max];
            String[] titlesArray = new String[max];
            String[] descsArray = new String[max];

            for (int i = 0; i < max; i++) {
                JSONObject jsonObject = arr1.getJSONObject(i);

                idsArray[i] = jsonObject.getString("film_id");
                titlesArray[i] = jsonObject.getString("title");
                descsArray[i] = jsonObject.getString("description");
            }

            StringArrayAdapter adapter = new StringArrayAdapter(idsArray, titlesArray, descsArray, classContext);
            listView.setAdapter(adapter);
            results.setText("Hello World.");


//        // Temp display
//        String output = "";
//        for (int j = 0; j < titlesArray.length; j++) {
//            output += titlesArray[j] + " | ";
//        }
//        results.setText(output);
//        // End temp display

        } catch (JSONException e) {
            e.printStackTrace();
            results.setText(e.toString());
        }
    }
}



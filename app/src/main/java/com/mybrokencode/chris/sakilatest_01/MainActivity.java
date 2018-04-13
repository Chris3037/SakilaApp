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

    // Tutorial followed: https://www.youtube.com/watch?v=Vcn4OuV4Ixg

    public static Context classContext;
    public static ListView listView;
    public static JSONArray jsonData;
    //    Button click;
//    public static String line ="{\"records\":[{\"title\":\"Movie 1\",\"rating\":\"PG\",\"rental_rate\":\"0.99\"},{\"title\":\"Movie 2\",\"rating\":\"R\",\"rental_rate\":\"2.99\"},{\"title\":\"Movie 3\",\"rating\":\"PG-13\",\"rental_rate\":\"1.99\"}]}";
//    public static String line;

    public static TextView results;
//    public static ListView listView;

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
//        process.onPostExecute(null);

//        results.setText(line);

//        URL url;
//        while (line == null) {}
//        results.setText(":)");



//        FetchJSON process = new FetchJSON();
//        process.execute();
//
//        String[] titles = {"Chris", "Bob", "Jess", "Frank", "Ella", "Phil", "Sue", "Jenn"};
//        String[] descs = {"Chris is nice.", "Bob is mean.", "Jess is swell.", "Frank is greedy.", "Ella is beautiful.", "Phil is savage.", "Sue is sweet.", "Jenn is nasty."};
//        ListView listView = (ListView) findViewById(R.id.list_view_1);
//        StringArrayAdapter adapter = new StringArrayAdapter(titles, descs, this);
//        listView.setAdapter(adapter);

//        click = (Button) findViewById(R.id.button);
//        data = (TextView) findViewById(R.id.data);


//        click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Executed when button is pressed
//                WaitingForData();
//
//                FetchData process = new FetchData();
//                process.execute();
//            }
//            private void WaitingForData() {
//                // TODO: Make animation while waiting for data. Ie. animated ellipsis, percentage, loading bar, circle loading bar
//                data.setText("Fetching data...");
//            }
//        });


    }
    public static void PopulateView(String data) {
//        results.setText(data);
        try {
//            data = "{\"records\":[{\"title\":\"Movie 1\",\"rating\":\"PG\",\"rental_rate\":\"0.99\"},{\"title\":\"Movie 2\",\"rating\":\"R\",\"rental_rate\":\"2.99\"},{\"title\":\"Movie 3\",\"rating\":\"PG-13\",\"rental_rate\":\"1.99\"}]}";

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

            String asdf = "";
            for (int i = 0; i < max; i++) {
                asdf += titlesArray[i].toString() + " | ";
            }

//            results.setText(asdf);
//            results.setText(titlesArray[9].toString());

        } catch (JSONException e) {
            e.printStackTrace();
            results.setText(e.toString());
        }
    }
}

//names = {"Chris", "Bob", "Jess", "Frank", "Ella"};




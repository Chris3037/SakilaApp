package com.mybrokencode.chris.sakilatest_01;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.ListView;

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

public class FetchJSON extends AsyncTask<Void, Void, Void> {
    String data;

    @Override
    protected Void doInBackground(Void... voids) {

        // Executed in background

        URL url;

        try {
//            url = new URL("http://mybrokencode.com/sakila/api/film/read.php");
            url = new URL("https://api.myjson.com/bins/qeujr");

//            url = new URL("https://api.myjson.com/bins/dmv4v");
//            url = new URL("https://api.myjson.com/bins/uwfof");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            data = "";
            while ((line = bufferedReader.readLine()) != null) {
                data += line;
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.PopulateView(data);
    }
}

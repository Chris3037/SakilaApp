package com.mybrokencode.chris.sakilatest_01;

import android.os.AsyncTask;

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

public class FetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {

        // Executed in background

        URL url;
        try {
            url = new URL("http://mybrokencode.com/sakila/api/film/read.php");
//            url = new URL("https://api.myjson.com/bins/uwfof");
//            url = new URL("https://api.myjson.com/bins/dmv4v");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }

            // TODO: Show this data in a ListView
            // https://www.youtube.com/watch?v=vpfeDoIWT0U

            // Use this when JSON begins with array.
//            JSONArray arr1 = new JSONArray(data);

            // Use this when JSON is an object containing arrays.
            JSONObject obj1 = new JSONObject(data);
            JSONArray arr1 = obj1.getJSONArray("records");

            int max = 10;
            if (arr1.length() < max) {
                max = arr1.length();
            }

            for (int i = 0; i < max; i++) {
                JSONObject jsonObject = arr1.getJSONObject(i);
                singleParsed =  "Title: " + jsonObject.getString("title") + "\n" +
                                "Rating: " + jsonObject.getString("rating") + "\n" +
                                "Cost: " + jsonObject.getString("rental_rate") + "\n\n";

                dataParsed += singleParsed;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            dataParsed = "There was a problem";
        } catch (IOException e) {
            e.printStackTrace();
            dataParsed = "There was a problem";
        } catch (JSONException e) {
            e.printStackTrace();
//            dataParsed = e.toString();
            dataParsed = "There was a problem";
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

//        MainActivity.data.setText(this.dataParsed);
    }
}

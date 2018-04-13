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

//    String[] titlesArray;
//    String[] descsArray;
//    String line;
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
//            while (line != null) {
//                line = bufferedReader.readLine();
//                data += line;
//            }
            while ((line = bufferedReader.readLine()) != null) {
//                line = bufferedReader.readLine();
                data += line;
            }



//            MainActivity.data = line;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        URL url;
//        try {
//            url = new URL("http://mybrokencode.com/sakila/api/film/read.php");
//
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//            String line = "";
//            while (line != null) {
//                line += bufferedReader.readLine();
//            }
//
//            JSONObject obj1 = new JSONObject(line);
//            JSONArray arr1 = obj1.getJSONArray("records");
//
//            String[] titlesArray = new String[arr1.length()];
//            String[] descsArray = new String[arr1.length()];
//
//            for (int i = 0; i < arr1.length(); i++) {
//                JSONObject jsonObject = arr1.getJSONObject(i);
//
//                titlesArray[i] = jsonObject.getString("title");
//                descsArray[i] = jsonObject.getString("description");
//            }
//
//
////            ListView listView = (ListView) findViewById(R.id.list_view_1);
////            StringArrayAdapter adapter = new StringArrayAdapter(titlesArray, descsArray, this);
////            listView.setAdapter(adapter);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

//        MainActivity.data.setText(this.dataParsed);
//        MainActivity.results.setText(data);
//        MainActivity.line = data;

        MainActivity.PopulateView(data);

//        MainActivity.DoThings
//        MainActivity.listView.add
    }
}

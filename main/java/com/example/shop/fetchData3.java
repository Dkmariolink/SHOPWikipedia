package com.example.shop;

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

public class fetchData3 extends AsyncTask<Void,Void,Void> {
    String data3 ="";
    String dataParsed3 = "";
    String singleParsed3 ="";

// The same as fetchData.java, just another instance so that the application can fetch and feed in a new URL into the data textview

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/voh2a");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while(line != null){
                line = bufferedReader.readLine();
                data3 = data3 + line;
            }


            JSONArray JA = new JSONArray(data3);
            for(int i =0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed3 = JO.get("name") +"\n" +"\n";
                dataParsed3 = dataParsed3 + singleParsed3;


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data3.setText(this.dataParsed3);

    }
}
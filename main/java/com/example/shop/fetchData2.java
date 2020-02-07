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

public class fetchData2 extends AsyncTask<Void,Void,Void> {
    String data2 ="";
    String dataParsed2 = "";
    String singleParsed2 ="";

// The same as fetchData.java, just another instance so that the application can fetch and feed in a new URL into the data textview

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.myjson.com/bins/176z4q");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";

                while(line != null){
                    line = bufferedReader.readLine();
                    data2 = data2 + line;
                }


                JSONArray JA = new JSONArray(data2);
                for(int i =0; i < JA.length(); i++){
                    JSONObject JO = (JSONObject) JA.get(i);
                    singleParsed2 = JO.get("name") +"\n" +"\n";
                    dataParsed2 = dataParsed2 + singleParsed2;


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

        MainActivity.data2.setText(this.dataParsed2);

    }
}


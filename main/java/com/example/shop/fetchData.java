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

public class fetchData extends AsyncTask<Void,Void,Void> {

    //Declaring default values

    // To fetch this data, I needed to declare internet intent in AndroidManifest XML file.

    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/iq262"); // URL is an API that houses SHOP information. API key is hidden here.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // Set up the connection feed
            InputStream inputStream = httpURLConnection.getInputStream(); // Set up input stream to allow for output into buffered reader.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
        // While line is not null, print out content from URL.

            JSONArray JA = new JSONArray(data);
            for(int i =0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = JO.get("name") +"\n" +"\n";
                dataParsed = dataParsed + singleParsed;


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

        MainActivity.data.setText(this.dataParsed);

        // After background process is complete, post executes gets to work and prints out content on a viewable layout.

    }
}

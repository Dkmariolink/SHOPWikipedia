package com.example.shop;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button brand;
    private Button categories;
    private Button locales;
    private Button share;
    public static TextView data;
    public static TextView data2;
    public static TextView data3;

    // APP TESTED ON A REDMI NOTE 5 PRO

    // Simple wikipedia app that demonstrates important features of mobile application development such as...
    // accessing phone features (contact share), connecting to web API to fetch data with JSON
    // accessible layout with easy to use UI, easy to view, and not complicated.
    // consistent layout in both portrait and landscape which is extremely important, especially for larger devices.

    // This app pulls data from SHOP API's product search (brands), category, and AFN sites.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brand = findViewById(R.id.brand);
        data = findViewById(R.id.fetchdata);
        data2 = findViewById(R.id.fetchdata);
        data3 = findViewById(R.id.fetchdata);
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    fetchData process = new fetchData();
                    process.execute();
                } // when button is clicked, fetches data from web api from fetchData class and executes. Do this for every button.
        });
        categories = findViewById(R.id.categories);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    fetchData2 process2 = new fetchData2();
                    process2.execute();
            }
        });
        locales = findViewById(R.id.affiliates);
        locales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    fetchData3 process3 = new fetchData3();
                    process3.execute();
            }
        });
        share = findViewById(R.id.share); // Button function for sharing with contacts
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Look at what I learned from SHOP Wikipedia!";
                String shareSub = "A simple yet effective app for finding out what SHOP.com brands exist!";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(shareIntent,"Share using..."));
                // Share could be anything from apps on phone being facebook, twitter, etc to the contact list

                // This is the most portable (as in, accessible) phone feature as every phone has a share list, but not a finger print auth for example.
            }
        });
    }

}

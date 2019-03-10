/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        //Create the Array List of earthquake locations


        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
        earthquakes.add(new Earthquake("San Francisco",7.2, "Feb 2, 2016"));
        earthquakes.add(new Earthquake("London", 6.1,"Feb 2, 2016"));
        earthquakes.add(new Earthquake("Tokyo",7.2, "Feb 2, 2016"));
        earthquakes.add(new Earthquake("Mexico City",7.2, "Feb 2, 2016"));
        earthquakes.add(new Earthquake("Moscow",7.2, "Feb 2, 2016"));
        earthquakes.add(new Earthquake("Rio de Janeiro",7.2, "Feb 2, 2016"));
        earthquakes.add(new Earthquake("Paris",7.2, "Feb 2, 2016"));

        // Create an Adapter whose data source is a list of Earthquakes.  The adapter knows how to create
        //list item views for each item in the list
        CustomAdapter earthquakeAdapter = new CustomAdapter(this,earthquakes);

        //get a reference to the List View and attache the adapter to the list view
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(earthquakeAdapter);

    }
}

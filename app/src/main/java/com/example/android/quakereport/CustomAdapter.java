package com.example.android.quakereport;


/*
 * This is an ArrayAdapter that can provide the layout for each list
 * based on a data source, which is a list of custom objects.
 * */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = CustomAdapter.class.getSimpleName();

    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * Context        The current context. Used to inflate the layout file.
     * Earthquakes A List of Earthquake objects to display in a list
     */
    public CustomAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * position The position in the list of data that should be displayed in the
     *                 list item view.
     * convertView The recycled view to populate.
     * parent The parent ViewGroup that is used for inflation.
     * The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Check if the existing view is being re-used, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        //Get the custom object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        //Find the appropriate views in the list_item.xml layout
        TextView locationTV = listItemView.findViewById(R.id.location_tv);
        TextView magnitudeTV = listItemView.findViewById(R.id.magnitude_tv);
        TextView dateTV = listItemView.findViewById(R.id.date_tv);

        //Set text on those views
        locationTV.setText(currentEarthquake.getLocation());
        magnitudeTV.setText(Double.toString(currentEarthquake.getMagnitude()));
        dateTV.setText(currentEarthquake.getDate());

        //Return the whole list item layout so that it can be shown in the List view
        return listItemView;

    }

}

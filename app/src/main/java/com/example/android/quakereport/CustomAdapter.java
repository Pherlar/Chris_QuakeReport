package com.example.android.quakereport;


/*
 * This is an ArrayAdapter that can provide the layout for each list
 * based on a data source, which is a list of custom objects.
 * */

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.graphics.drawable.GradientDrawable;

public class CustomAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = CustomAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = " of ";

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

        String primaryLocation;
        String locationOffset;


        //Get the custom object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        String originalLocation = currentEarthquake.getLocation();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);

        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);

        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());


        //Find the appropriate views in the list_item.xml layout
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location_tv);
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset_tv);
        TextView magnitudeTV = listItemView.findViewById(R.id.magnitude_tv);
        TextView dateTV = listItemView.findViewById(R.id.date_tv);
        TextView timeTV = listItemView.findViewById(R.id.time_tv);

        //Set text on those views
        primaryLocationView.setText(primaryLocation);
        locationOffsetView.setText(locationOffset);
        magnitudeTV.setText(formattedMagnitude);
        dateTV.setText(formattedDate);
        timeTV.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTV.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        //Return the whole list item layout so that it can be shown in the List view
        return listItemView;

    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


}

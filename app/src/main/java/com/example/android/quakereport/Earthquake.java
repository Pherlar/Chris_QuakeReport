package com.example.android.quakereport;

/**
 * This class represents a single Earthquake.
 * Each object has properties including: Location, Magnitude, Date
 */
public class Earthquake {

    // Location of the quake
    private String mLocation;

    // Magnitude of the quake
    private String mMagnitude;

    // Date of the quake
    private String mDate;

    /*
     * Create a new Earthquake object.
     *
     * assign variable names to the parameters passed in to the method
     * */
    public Earthquake(String location, String magnitude, String date)
    {
        mLocation = location;
        mMagnitude = magnitude;
        mDate = date;
    }

    /**
     * Getter method to get the location
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Getter method to get the location
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * Getter method to get the location
     */
    public String getDate() {
        return mDate;
    }


}

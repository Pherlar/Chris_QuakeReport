package com.example.android.quakereport;

/**
 * This class represents a single Earthquake.
 * Each object has properties including: Location, Magnitude, Date
 */
public class Earthquake {

    // Location of the quake
    private String mLocation;

    // Magnitude of the quake
    private double mMagnitude;

    // Date of the quake
    private Long mTimeInMilliseconds;

    //website URL of the earthquake
    private String mUrl;



    /*
     * Create a new Earthquake object.
     *
     * assign variable names to the parameters passed in to the method
     * */
    public Earthquake(String location, double magnitude, Long timeInMilliseconds, String Url)
    {
        mLocation = location;
        mMagnitude = magnitude;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = Url;
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
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Getter method to get the location
     */
    public Long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }


}

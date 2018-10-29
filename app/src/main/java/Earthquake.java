package com.example.android.quakereport;
public class Earthquake {
    private double magnitude;
    private String place;
    private long timeInMilliseconds;
    private String url;

    public Earthquake(double mag, String place, long time, String url)
    {
        this.magnitude = mag;
        this.place = place;
        this.timeInMilliseconds = time;
        this.url = url;
    }
    public double getMagnitude() {return this.magnitude;}
    public String getPlace() {return this.place;}
    public long getTimeInMilliseconds() {return this.timeInMilliseconds;}
    public String getUrl() {return this.url;}

    @Override
    public String toString() {
        return this.magnitude + " " + this.place + " " + this.timeInMilliseconds;
    }
}

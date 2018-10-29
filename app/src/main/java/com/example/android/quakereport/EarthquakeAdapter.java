package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;

public class EarthquakeAdapter extends ArrayAdapter<com.example.android.quakereport.Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<com.example.android.quakereport.Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        com.example.android.quakereport.Earthquake currentEarthquake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.magEarthquake);
        DecimalFormat decFormatted = new DecimalFormat("0.0");

        magTextView.setText(decFormatted.format(currentEarthquake.getMagnitude()));

        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.locationOffsetEarthquake);
        String currLocation = currentEarthquake.getPlace();
        if (currLocation.indexOf(" of") != -1) {
            offsetTextView.setText(currLocation.substring(0, currLocation.indexOf(" of") + 3));
        } else {
            offsetTextView.setText("Near the ");
        }
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.locationEarthquake);

        placeTextView.setText(currLocation.substring(currLocation.indexOf(" of") + 4));

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.dateEarthquake);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.timeEarthquake);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

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

    private int getMagnitudeColor(double magnitude) {
        int currColor;
        switch ((int) magnitude) {
            case 0:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 1:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                currColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return currColor;
    }
}

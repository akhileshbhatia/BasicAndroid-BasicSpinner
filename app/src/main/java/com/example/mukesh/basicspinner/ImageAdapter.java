package com.example.mukesh.basicspinner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends ArrayAdapter {
    private Context context;
    private String [] imageNames;
    private int [] imageIds;
    int resource;

    public ImageAdapter(Context context,int resource, String[] imageNames, int[]imageIds){
        super(context,resource,imageNames);

        this.context = context;
        this.imageIds = imageIds;
        this.imageNames = imageNames;
        this.resource = resource;
    }

    public View getView(int position, View view, ViewGroup group){
        View row;
        //get an inflator and inflate row
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        //wire objects with row's widgets
        row = inflater.inflate(resource,null);
        //populate row's objects with data
        ImageView icon = row.findViewById(R.id.icon);
        TextView label = row.findViewById(R.id.textView);

        label.setText(this.imageNames[position]);
        icon.setImageResource(this.imageIds[position]);

        return row;
    }

    public View getDropDownView(int position, View view, ViewGroup group){
        View row;
        //get an inflator and inflate row
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        //wire objects with row's widgets
        row = inflater.inflate(resource,null);
        //populate row's objects with data
        ImageView icon = row.findViewById(R.id.icon);
        TextView label = row.findViewById(R.id.textView);

        label.setText(this.imageNames[position]);
        icon.setImageResource(this.imageIds[position]);

        return row;
    }
}

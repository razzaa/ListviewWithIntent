package com.midmax.listviewwithintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class UsersAdapter extends ArrayAdapter<Model> {
    public UsersAdapter(Context context, ArrayList<Model> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Model user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }
        // Lookup view for data population
        TextView Name = (TextView) convertView.findViewById(R.id.name);
        TextView Roll = (TextView) convertView.findViewById(R.id.rollno);
        TextView age = (TextView) convertView.findViewById(R.id.age);
        TextView Phone = (TextView) convertView.findViewById(R.id.phoneno);
        // Populate the data into the template view using the data object
        Name.setText(user.getStudent_Name());
        Roll.setText(user.getRoll_no());
        age.setText(user.getAge());
        Phone.setText(user.getPhone_no());
        // Return the completed view to render on screen
        return convertView;
    }
}
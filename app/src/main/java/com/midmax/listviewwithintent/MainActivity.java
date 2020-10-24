package com.midmax.listviewwithintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Title;
    Button button;
    ListView listView;
    Context context;
    ArrayList<Model> arrayOfUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //receive data
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        arrayOfUsers = (ArrayList<Model>) args.getSerializable("ARRAYLIST");
        //intialization
        listView=findViewById(R.id.listview);

        // Construct the data source

        // Create the adapter to convert the array to views
        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Model str=(Model)o;//As you are using Model  Adapter
                //Toast.makeText(getBaseContext(),str.getStudent_Name(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("Name",str.getStudent_Name());
                intent.putExtra("Rollno",str.getRoll_no());
                intent.putExtra("Age",str.getAge());
                intent.putExtra("Phoneno",str.getPhone_no());
                startActivity(intent);
            }
        });
    }
}
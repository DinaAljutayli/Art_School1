package com.example.artschool;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDataActivity extends AppCompatActivity {

    TextView tv_data;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        db = new DatabaseHelper(this);
        tv_data = findViewById(R.id.tv_data);
        Cursor c = db.getAllData();

        if (c.getCount()==0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String result = "";
            while (c.moveToNext()){
                result = result + "ID: "+c.getString(0) + " Name: "+c.getString(2) + " Grade: " + c.getString(1)+"\n"+"\n";

            }
            tv_data.setText(result);
        }


    }
}
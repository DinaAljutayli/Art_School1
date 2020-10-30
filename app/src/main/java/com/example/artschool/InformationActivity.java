package com.example.artschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText name;
    EditText Id;
    EditText grade;
    Button submit_Button;
    Button show_Button;
    TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        db = new DatabaseHelper(this);
        name = findViewById(R.id.name_editext_info);
        Id = findViewById(R.id.id_editext_info);
        grade = findViewById(R.id.grade_editext_info);
        submit_Button = findViewById(R.id.submitButton);
        show_Button = findViewById(R.id.showButton);

        submit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString().trim();
                String ID = Id.getText().toString().trim();
                String Grade = grade.getText().toString().trim();


                        db.addStudent(Name, ID, Grade);
                        Toast.makeText(InformationActivity.this, "Data Inserted To Sqlite DataBase", Toast.LENGTH_LONG).show();
            }
        });


        show_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showIntent = new Intent(InformationActivity.this, ShowDataActivity.class);
                startActivity(showIntent);




            }
        });


    }


}
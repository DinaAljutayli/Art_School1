package com.example.artschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class wActivity extends AppCompatActivity {


    Button next_Button;
    Button previousButton;
    TextView hellouser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w);

        hellouser = findViewById(R.id.helloUser);
        Bundle extras = getIntent().getExtras();
        String username = null;
        if (extras != null) {
            username = extras.getString("username");
            hellouser.setText("Welcome " + username);

        }

        next_Button=findViewById(R.id.nextButton);
        next_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_Intent =  new Intent(wActivity.this, InformationActivity.class);
                startActivity(next_Intent);
            }
        });

        previousButton=findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent previousIntent =  new Intent(wActivity.this, LoginActivity.class);
                startActivity(previousIntent);
            }
        });

    }
}
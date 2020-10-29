package com.example.artschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


     DatabaseHelper db;
     EditText username_editext_login;
     EditText password_editext_login;

    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db = new DatabaseHelper(this);
        username_editext_login = findViewById(R.id.username_editext_login);
        password_editext_login = findViewById(R.id.password_editext_login);


        login_button = findViewById(R.id.login_butto);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username_editext_login.getText().toString().trim();
                String password = password_editext_login.getText().toString().trim();
                db.addusert(user,password);
                Intent wIntent = new Intent(LoginActivity.this, wActivity.class);
                startActivity(wIntent);

                }});


    }
}


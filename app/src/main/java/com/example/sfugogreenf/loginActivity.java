package com.example.sfugogreenf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class loginActivity extends AppCompatActivity {

    TextView activity_Name, app_Name, cas_Mssg, app_Phrase;

    EditText username, password;

    ImageView school_Logo, lock_Icon, user_Icon, app_Logo;

    Button  login, activity_Info_bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);

        activity_Name = findViewById(R.id.tvActivityName);
        app_Name = findViewById(R.id.tvAppName);
        cas_Mssg = findViewById(R.id.tvCAS_Mssg);
        app_Phrase = findViewById(R.id.tvAppPhrase);

    }


    public void openNewActivity(){
        Intent intent = new Intent(this, com.example.sfugogreenf.MapActivity.class);
        startActivity(intent);
    }

}

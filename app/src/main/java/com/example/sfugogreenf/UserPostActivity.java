package com.example.sfugogreenf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class UserPostActivity extends AppCompatActivity {

    TextView activity_Title, upload_Header ;

    ImageButton camera_Button;

    Button delete, post;

    EditText story_Desc, story_Title, item_Type;

    ImageView app_Logo, image_Place_Holder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post);
    }
}
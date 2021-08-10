package com.swagat.friends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FriendsWindow extends AppCompatActivity {
    ImageView imgFriend;
    TextView txtFriendName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_window);
        imgFriend = findViewById(R.id.imgFriend);
        txtFriendName = findViewById(R.id.txtFriendsName);


        Intent i = getIntent();
        //receiving Intents
        String name = i.getStringExtra("name");
        Log.d("name", name);



        String photo = i.getStringExtra("photo");
        Log.d("photo",photo);




//        boolean isMale = i.getBooleanExtra()
// glide to load images
        Glide.with(getApplicationContext()).load(photo).into(imgFriend);
        txtFriendName.setText(name);
    }
}
package com.swagat.friends;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread th = new Thread() {
            @Override
            public void run() {


                try {
                    sleep(3000);

                } catch (Exception e) {
                    Toast.makeText(SplashScreen.this, "Error", Toast.LENGTH_LONG).show();
                } finally {
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                super.run();
            }
        };
        th.start();
    }
}

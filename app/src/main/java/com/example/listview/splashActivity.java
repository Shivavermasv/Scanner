package com.example.listview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


@SuppressLint("CustomSplashScreen")
public class splashActivity extends AppCompatActivity {
    Typeface typeface;
    TextView name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        name = findViewById ( R.id.dev_name );
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView app_name = findViewById ( R.id.app_name );
        app_name.setTextColor( Color.WHITE);
        typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        app_name.setTypeface (typeface);
        name.setTextColor ( Color.WHITE );
        name.setTypeface ( typeface );

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1500);
                }catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(splashActivity.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
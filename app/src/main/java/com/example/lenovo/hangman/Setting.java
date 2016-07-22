package com.example.lenovo.hangman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Setting extends AppCompatActivity {

    public static boolean m, s;
    ImageButton music, sound;
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        music = (ImageButton) findViewById(R.id.music_btn);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m) {
                    music.setImageResource(R.drawable.music_off);
                    m = false;
                } else {
                    music.setImageResource(R.drawable.music_on);
                    m = true;
                }
            }
        });
        sound = (ImageButton) findViewById(R.id.sound_btn);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s) {
                    sound.setImageResource(R.drawable.sound_off);
                    s = false;
                } else {
                    sound.setImageResource(R.drawable.sound_on);
                    s = true;
                }
            }
        });
        logOut = (Button) findViewById(R.id.log_btn);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, StartPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        if (m)
            music.setImageResource(R.drawable.music_on);
        else
            music.setImageResource(R.drawable.music_off);
        if (s)
            sound.setImageResource(R.drawable.sound_on);
        else
            sound.setImageResource(R.drawable.sound_off);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("Sound", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("music", m);
        editor.putBoolean("sound", s);
        editor.apply();
    }
}
package com.example.lenovo.hangman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    public static boolean m, s;
    Button music, sound, logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        music = (Button) findViewById(R.id.music_btn);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m) {
                    music.setText("OFF");
                    m = false;
                } else {
                    music.setText("ON");
                    m = true;
                }
            }
        });
        sound = (Button) findViewById(R.id.sound_btn);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s) {
                    sound.setText("OFF");
                    s = false;
                } else {
                    sound.setText("ON");
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
            music.setText("ON");
        else
            music.setText("OFF");
        if (s)
            sound.setText("ON");
        else
            sound.setText("OFF");
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
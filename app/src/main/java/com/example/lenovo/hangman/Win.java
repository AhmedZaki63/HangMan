package com.example.lenovo.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigInteger;

public class Win extends AppCompatActivity {

    MediaPlayer win;
    TextView view;
    DataClass data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        win = MediaPlayer.create(this, R.raw.ta_da);
        data = new DataClass(this);
        if (Setting.s)
            win.start();
        view = (TextView) findViewById(R.id.scoreShowWin);
        view.setText("Your Score is : " + data.GetScore());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Win.this, Choosing.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

package com.example.lenovo.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Lose extends AppCompatActivity {

    MediaPlayer lose;
    TextView view;
    DataClass data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        lose = MediaPlayer.create(this, R.raw.wrong_answer);
        if (Setting.s)
            lose.start();
        data = new DataClass(this);
        view = (TextView) findViewById(R.id.scoreShowLose);
        view.setText("Your Score is : " + data.GetScore());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Lose.this, Choosing.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

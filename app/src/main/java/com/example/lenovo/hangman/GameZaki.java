package com.example.lenovo.hangman;


import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameZaki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_zaki);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.imageView);
        mySound = MediaPlayer.create(this, R.raw.androids);
        mySound.setLooping(true);
        mySound.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong();
                lives--;
            }
        });
    }

    MediaPlayer mySound;
    Button button;
    ImageView image;
    int lives = 4;

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String ss = String.valueOf(lives);
        outState.putString("lives", ss);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            lives = savedInstanceState.getInt("lives");
            wrong();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    public void wrong() {
        switch (lives) {
            case 4:
                image.setImageResource(R.drawable.life_4);
                break;
            case 3:
                image.setImageResource(R.drawable.life_3);
                break;
            case 2:
                image.setImageResource(R.drawable.life_2);
                break;
            case 1:
                image.setImageResource(R.drawable.life_1);
                break;
            case 0:
                image.setImageResource(R.drawable.life_0);
                button.setText("You Lose :(");
                button.setClickable(false);
                break;
            default:
                image.setImageResource(R.drawable.life_5);
        }
    }
}

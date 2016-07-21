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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        lose = MediaPlayer.create(this, R.raw.wrong_answer);
        lose.start();
        view=(TextView)findViewById(R.id.scoreShowLose);
        SharedPreferences sh1= getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences sh2= getSharedPreferences("User", Context.MODE_PRIVATE);
        String name=sh2.getString("key", "asdjs4545dfsa");
        StringBuffer show=new StringBuffer();
        show.append("Your Score is : " + sh1.getString(name,"dadasdad"));
        view.setText(show.toString());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Lose.this, Choosing.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

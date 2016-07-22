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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        win = MediaPlayer.create(this, R.raw.ta_da);
        if (Setting.s)
            win.start();
        view = (TextView) findViewById(R.id.scoreShowWin);
        SharedPreferences sh = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        SharedPreferences sh1 = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences sh2 = getSharedPreferences("User", Context.MODE_PRIVATE);
        String name = sh2.getString("key", "asdjs4545dfsa");
        BigInteger n1 = new BigInteger(sh1.getString(name, "ad565"));
        BigInteger n2 = new BigInteger("1");
        n1 = n1.add(n2);
        editor.putString(name, n1.toString());
        editor.apply();
        StringBuffer showScore = new StringBuffer();
        showScore.append("Your Score is : " + n1.toString());
        view.setText(showScore.toString());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Win.this, Choosing.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

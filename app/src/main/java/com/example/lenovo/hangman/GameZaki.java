package com.example.lenovo.hangman;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameZaki extends AppCompatActivity {

    public static String choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_zaki);
        image = (ImageView) findViewById(R.id.imageView);
        mySound = MediaPlayer.create(this, R.raw.androids);
        mySound.setLooping(true);
        mySound.start();
        show=(TextView) findViewById(R.id.viewUser);
        animeTopic = getResources().getStringArray(R.array.animeTopic);
        animalsTopic = getResources().getStringArray(R.array.animalsTopic);
        moviesTopic = getResources().getStringArray(R.array.moviesTopic);
        teamTopic = getResources().getStringArray(R.array.teamTopic);
        gamesTopic = getResources().getStringArray(R.array.gamesTopic);
        colorsTopic = getResources().getStringArray(R.array.colorsTopic);
        fruitsTopic = getResources().getStringArray(R.array.fruitsTopic);
        txt=(TextView) findViewById(R.id.textView);
        vegetablesTopic = getResources().getStringArray(R.array.vegetablesTopic);
        animalsTopic = getResources().getStringArray(R.array.animalsTopic);
        countriesTopic = getResources().getStringArray(R.array.countriesTopic);
        Bundle b = getIntent().getExtras();
        String kind = b.getString("Kind");
        name = b.getString("name");
        switch (kind) {
            case "Anime":
                n = rand.nextInt(animeTopic.length);
                word = animeTopic[n];
                user = word.toCharArray();
                break;
            case "Fruits":
                n = rand.nextInt(fruitsTopic.length);
                word = fruitsTopic[n];
                user = word.toCharArray();
                break;
            case "Vegetables":
                n = rand.nextInt(vegetablesTopic.length);
                word = vegetablesTopic[n];
                user = word.toCharArray();
                break;
            case "Movies":
                n = rand.nextInt(moviesTopic.length);
                word = moviesTopic[n];
                user = word.toCharArray();
                break;
            case "Games":
                n = rand.nextInt(gamesTopic.length);
                word = gamesTopic[n];
                user = word.toCharArray();
                break;
            case "Animals":
                n = rand.nextInt(animalsTopic.length);
                word = animalsTopic[n];
                user = word.toCharArray();
                break;
            case "Countries":
                n = rand.nextInt(countriesTopic.length);
                word = countriesTopic[n];
                user = word.toCharArray();
                break;
            case "Football Teams":
                n = rand.nextInt(teamTopic.length);
                word = teamTopic[n];
                user = word.toCharArray();
                break;
            case "Colors":
                n = rand.nextInt(colorsTopic.length);
                word = colorsTopic[n];
                user = word.toCharArray();
                break;
        }
        sss = hint(word);
        show.setText(sss);
        user = sss.toCharArray();
    }
    TextView show;
    String sss;
    TextView txt;
    String name;
    MediaPlayer mySound;
    ImageView image;
    int lives = 5;
    Random rand = new Random();
    Random rand1 = new Random();
    int n; // random number
    char one; // for the character he enter
    String word; // the original word
    char[] user; // user progress
    ArrayList<Character> used = new ArrayList<>(); // used character
    Toolbar mToolBar;
    String[] animeTopic, moviesTopic, teamTopic, gamesTopic, colorsTopic, fruitsTopic, vegetablesTopic, animalsTopic, countriesTopic;



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lives", lives);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lives = savedInstanceState.getInt("lives");
        wrong();
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
                break;
        }
    }


    public String hint(String original) {
        int size = original.length();
        StringBuffer string;
        if (size > 5) {
            string = new StringBuffer();
            int n1 = rand1.nextInt(size);
            int n2 = rand1.nextInt(size);
            while ((n1 == n2) || (original.charAt(n1) == original.charAt(n2))) {
                n2 = rand1.nextInt(size);
            }
            char x1 = original.charAt(n1), x2 = original.charAt(n2);
            for (int i = 0; i < size; i++) {
                if ((x1 == original.charAt(i)) || (x2 == original.charAt(i))) {
                    if (x1 == original.charAt(i))
                        string.append(x1);
                    if (x2 == original.charAt(i))
                        string.append(x2);
                } else
                    string.append("-");
            }
        } else {
            string = new StringBuffer();
            int nn1 = rand1.nextInt(size);
            char xx1 = original.charAt(nn1);
            for (int i = 0; i < size; i++) {
                if (xx1 == original.charAt(i))
                    string.append(xx1);
                else
                    string.append("-");
            }
        }
        return string.toString();
    }

    public void checkk(){
            txt.setText(choice);
            if (!(word.contains(choice))){
                lives--;
                wrong();
            }
            else {
                StringBuffer tryy = new StringBuffer();
                for (int i = 0; i < word.length(); i++) {
                    if (choice.charAt(0) == word.charAt(i))
                        tryy.append(choice.charAt(0));
                    else
                        tryy.append(user[i]);
                }
                sss = tryy.toString();
                user = sss.toCharArray();
                show.setText(sss);
            }
    }

    public void win(){
        if(!(sss.contains("-"))){
            Bundle bb=new Bundle();
            bb.putString("name",name);
            Intent intent=new Intent(GameZaki.this,Winn.class);
            intent.putExtras(bb);
            startActivity(intent);
        }
        else if (lives==0){
            Bundle bb=new Bundle();
            bb.putString("name",name);
            Intent intent=new Intent(GameZaki.this,Loose.class);
            intent.putExtras(bb);
            startActivity(intent);
        }
    }


}

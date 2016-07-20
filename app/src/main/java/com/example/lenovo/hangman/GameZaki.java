package com.example.lenovo.hangman;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameZaki extends AppCompatActivity {

    public static String choice;
    TextView show;
    String word, originalWord;
    String name;
    MediaPlayer backgroundMusic, correctChoice, wrongChoice;
    ImageView image;
    int lives = 5;
    Random rand = new Random();
    Random rand1 = new Random();
    int n; // random number
    Toolbar myToolBar;
    String[] animeTopic, moviesTopic, teamTopic, gamesTopic, colorsTopic, fruitsTopic, vegetablesTopic, animalsTopic, countriesTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_zaki);
        image = (ImageView) findViewById(R.id.imageView);
        backgroundMusic = MediaPlayer.create(this, R.raw.androids);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
        correctChoice = MediaPlayer.create(this, R.raw.bubble_clap);
        wrongChoice = MediaPlayer.create(this, R.raw.error_alert);
        show = (TextView) findViewById(R.id.viewUser);
        animeTopic = getResources().getStringArray(R.array.animeTopic);
        animalsTopic = getResources().getStringArray(R.array.animalsTopic);
        moviesTopic = getResources().getStringArray(R.array.moviesTopic);
        teamTopic = getResources().getStringArray(R.array.teamTopic);
        gamesTopic = getResources().getStringArray(R.array.gamesTopic);
        colorsTopic = getResources().getStringArray(R.array.colorsTopic);
        fruitsTopic = getResources().getStringArray(R.array.fruitsTopic);
        vegetablesTopic = getResources().getStringArray(R.array.vegetablesTopic);
        animalsTopic = getResources().getStringArray(R.array.animalsTopic);
        countriesTopic = getResources().getStringArray(R.array.countriesTopic);
        Bundle b = getIntent().getExtras();
        String kind = b.getString("Kind");
        name = b.getString("name");
        if (word == null) {
            select(kind);
            word = hint(originalWord);
            show.setText(word);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lives", lives);
        outState.putString("progress", word);
        outState.putString("original", originalWord);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lives = savedInstanceState.getInt("lives");
        word = savedInstanceState.getString("progress");
        originalWord = savedInstanceState.getString("original");
        show.setText(word);
        wrong();
    }

    @Override
    protected void onPause() {
        super.onPause();
        backgroundMusic.release();
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

    public void select(String s) {
        switch (s) {
            case "Anime":
                n = rand.nextInt(animeTopic.length);
                originalWord = animeTopic[n];
                break;
            case "Fruits":
                n = rand.nextInt(fruitsTopic.length);
                originalWord = fruitsTopic[n];
                break;
            case "Vegetables":
                n = rand.nextInt(vegetablesTopic.length);
                originalWord = vegetablesTopic[n];
                break;
            case "Movies":
                n = rand.nextInt(moviesTopic.length);
                originalWord = moviesTopic[n];
                break;
            case "Games":
                n = rand.nextInt(gamesTopic.length);
                originalWord = gamesTopic[n];
                break;
            case "Animals":
                n = rand.nextInt(animalsTopic.length);
                originalWord = animalsTopic[n];
                break;
            case "Countries":
                n = rand.nextInt(countriesTopic.length);
                originalWord = countriesTopic[n];
                break;
            case "Football Teams":
                n = rand.nextInt(teamTopic.length);
                originalWord = teamTopic[n];
                break;
            case "Colors":
                n = rand.nextInt(colorsTopic.length);
                originalWord = colorsTopic[n];
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

    public void check() {
        if (!(originalWord.contains(choice))) {
            wrongChoice.start();
            lives--;
            wrong();
        } else {
            correctChoice.start();
            StringBuffer tryy = new StringBuffer();
            for (int i = 0; i < originalWord.length(); i++) {
                if (choice.charAt(0) == originalWord.charAt(i))
                    tryy.append(choice.charAt(0));
                else
                    tryy.append(word.charAt(i));
            }
            word = tryy.toString();
            show.setText(word);
        }
    }

    public void win() {
        if (!(word.contains("-"))) {
            Bundle bb = new Bundle();
            bb.putString("name", name);
            Intent intent = new Intent(GameZaki.this, Win.class);
            intent.putExtras(bb);
            startActivity(intent);
        } else if (lives == 0) {
            Bundle bb = new Bundle();
            bb.putString("name", name);
            Intent intent = new Intent(GameZaki.this, Lose.class);
            intent.putExtras(bb);
            startActivity(intent);
        }
    }

}

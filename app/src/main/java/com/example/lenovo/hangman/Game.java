package com.example.lenovo.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {
    TextView view,show; // display the game word
    Random rand = new Random();
    Random rand1=new Random();
    EditText take;
    Button done;
    int n; // random number
    char one; // for the character he enter
    String word; // the original word
    char[] user; // user progress
    ArrayList<Character> used=new ArrayList<>(); // used character
    Toolbar mToolBar;
    String[] animeTopic={
            "naruto",
            "onepiece",
            "deathnote",
            "pokemon",
            "endride",
            "swordart"
    };
    String[] moviesTopic={
            "batmanvssuperman",
            "spiderman",
            "antman",
            "civilwar",
            "hitman",
            "minions",
            "spy",
            "warcraft",
            "huntsman",
            "zootopia",
            "martian",
            "home",
            "deadpool",
            "ironman"
    };
    String[] teamTopic={
            "barcelona",
            "realmadrid",
            "arsenal",
            "chelsea",
            "liverpool",
            "sunderland",
            "newcastle",
            "wimbledon",
            "stokecity",
            "southampton"
    };
    String[] gamesTopic={
            "gta",
            "castlevania",
            "blur",
            "farcry",
            "darksiders",
            "hitman",
            "pes",
            "wwe",
            "fifa",
            "prototype",
            "syndicate",
            "conquer"
    };
    String[] colorsTopic={
            "red",
            "green",
            "blue",
            "white",
            "black",
            "brown",
            "coral",
            "orange",
            "yellow",
            "violet",
            "pink",
            "gray",
            "gold",
            "silver",
            "purple"
    };
    String[] fruitsTopic={
            "apple",
            "banana",
            "cherry",
            "date",
            "orange",
            "lemon",
            "guava",
            "blueberry",
            "mango",
            "peach",
            "pear",
            "pineapple",
            "strawberry"
    };
    String[] vegetablesTopic={
            "corn",
            "pepper",
            "mushroom",
            "potato",
            "pumpkin",
            "pea",
            "onion",
            "tomato",
            "eggplant",
            "cabbage","redchili"
    };
    String[] animalsTopic={
            "bat",
            "bear",
            "bee",
            "bird",
            "butterfly",
            "buffalo",
            "camel",
            "chicken",
            "crow","deer","dog","dolphin","donkey","eagle","duck","elephant","fish","fox","fly","frog"

    };
    String[] countriesTopic={
            "australia","bahrain","brazil","burma","canada","argentine","france","denmark","egypt",
            "ghana","india","japan","china","iran","iraq","italy","libya","mali","nepal","oman","qatar"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        view = (TextView)findViewById(R.id.vieww);
        Bundle b = getIntent().getExtras();
        show=(TextView)findViewById(R.id.show);
        done=(Button)findViewById(R.id.done);
        take=(EditText)findViewById(R.id.take);
        String kind=b.getString("Kind");
        mToolBar=(Toolbar)findViewById(R.id.game_toolbar);
        mToolBar.setTitle(kind);
        setSupportActionBar(mToolBar);
        if(kind.equals("Anime")){
            n = rand.nextInt(animeTopic.length);
            word=animeTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Fruits")){
            n = rand.nextInt(fruitsTopic.length);
            word=fruitsTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Vegetables")){
            n = rand.nextInt(vegetablesTopic.length);
            word=vegetablesTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Movies")){
            n = rand.nextInt(moviesTopic.length);
            word=moviesTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Games")){
            n = rand.nextInt(gamesTopic.length);
            word=gamesTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Animals")){
            n = rand.nextInt(animalsTopic.length);
            word=animalsTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Countries")){
            n = rand.nextInt(countriesTopic.length);
            word=countriesTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Football Teams")){
            n = rand.nextInt(teamTopic.length);
            word=teamTopic[n];
            user=word.toCharArray();
        }
        else if(kind.equals("Colors")){
            n = rand.nextInt(colorsTopic.length);
            word=colorsTopic[n];
            user=word.toCharArray();
        }
        view.setText(word);
        final String sss=hint(word);
        show.setText(sss);
        user=sss.toCharArray();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(take.getText().toString().length()>1)
                    take.setError("Enter one character");
                else {
                    if (!(word.contains(take.getText().toString())))
                        take.setError("Noo");
                    else if(sss.contains(take.getText().toString()))
                        take.setError("Exist");
                    else{
                        String store = take.getText().toString();
                        StringBuffer tryy = new StringBuffer();
                        for (int i = 0; i < word.length(); i++) {
                            if (store.charAt(0) == word.charAt(i))
                                tryy.append(store.charAt(0));
                            else if (user[i]!='-')
                                tryy.append(user[i]);
                            else
                                tryy.append("-");
                        }
                        String userr=tryy.toString();
                        user=userr.toCharArray();
                        show.setText(userr);
                    }
                }

            }
        });

    }
    public String hint(String original){
        int size=original.length();
        StringBuffer string;
        if(size>5){
            string=new StringBuffer();
            int n1=rand1.nextInt(size);
            int n2=rand1.nextInt(size);
            while((n1==n2) || (original.charAt(n1)==original.charAt(n2))){
                n2=rand1.nextInt(size);
            }
            char x1=original.charAt(n1),x2=original.charAt(n2);
            for(int i=0;i<size;i++){
                if((x1==original.charAt(i))||(x2==original.charAt(i))){
                    if(x1==original.charAt(i))
                        string.append(x1);
                    if(x2==original.charAt(i))
                        string.append(x2);
                }
                else
                    string.append("-");
            }
        }
        else{
            string=new StringBuffer();
            int nn1=rand1.nextInt(size);
            char xx1=original.charAt(nn1);
            for(int i=0;i<size;i++){
                if(xx1==original.charAt(i))
                    string.append(xx1);
                else
                    string.append("-");
            }
        }
        return string.toString();
    }


    public Boolean check(String userin,String original){
        if(original.contains(userin))
            return true;
        else
            return false;
    }


}


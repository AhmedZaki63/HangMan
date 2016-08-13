package com.example.lenovo.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    DataClass data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final TextView sh=(TextView) findViewById(R.id.showNamess);
        StringBuilder s = new StringBuilder();
        data = new DataClass(this);
        s.append("Zaki \n");
        s.append("Hassaan");
        sh.setText(s);
        final ImageView image = (ImageView) findViewById(R.id.yinn);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        image.startAnimation(an);
        sh.startAnimation(AnimationUtils.loadAnimation(Welcome.this, android.R.anim.slide_in_left));
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.startAnimation(an2);
                finish();
                if(data.lastt()){
                    Intent intent = new Intent (Welcome.this,Choosing.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent (Welcome.this,StartPage.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

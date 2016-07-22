package com.example.lenovo.hangman;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {
    Button start;
    EditText takeName;
    Toolbar myToolBar;
    String de = "a21a5sd";
    public String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        myToolBar = (Toolbar) findViewById(R.id.start_toolbar);
        myToolBar.setTitle("Start");
        myToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolBar);
        start = (Button) findViewById(R.id.btnStart);
        takeName = (EditText) findViewById(R.id.takeName);
        takeName.setText("");
        SharedPreferences prefs = getSharedPreferences("Sound", MODE_PRIVATE);
        Setting.m = prefs.getBoolean("music", true);
        Setting.s = prefs.getBoolean("sound", true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.setting_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.menuu) {
            Intent intent = new Intent(StartPage.this, Setting.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    public void startGame(View view) {
        SharedPreferences sh = getSharedPreferences("Data", Context.MODE_PRIVATE);
        if (TextUtils.isEmpty(takeName.getText().toString()))
            takeName.setError("Empty");
        else {
            s = takeName.getText().toString();
            String check = sh.getString(s, de);
            if (!(check.equals(de))) {
                SharedPreferences sh1 = getSharedPreferences("User", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sh1.edit();
                editor1.putString("key", s);
                editor1.apply();
                Intent intent = new Intent(StartPage.this, Choosing.class);
                startActivity(intent);
            } else {
                AlertDialog.Builder newName = new AlertDialog.Builder(StartPage.this);
                newName.setMessage("Do you Want to Register this new Name?!");
                newName.setTitle("New Name!!");
                newName.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences sh = getSharedPreferences("Data", MODE_PRIVATE);
                        SharedPreferences sh1 = getSharedPreferences("User", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sh.edit();
                        SharedPreferences.Editor editor1 = sh1.edit();
                        editor.putString(s, "0");
                        editor1.putString("key", s);
                        editor1.apply();
                        editor.apply();
                        Toast.makeText(StartPage.this, "Done", Toast.LENGTH_SHORT).show();
                        takeName.setText(s);
                    }
                });
                newName.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        takeName.setText("");
                    }
                });
                newName.create().show();
            }
        }
    }

}

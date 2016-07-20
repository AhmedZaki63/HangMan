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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {
    Button start;
    EditText takeName;
    Toolbar myToolBar;
    String de = "a21a5sd";
    String s;

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
    }

    public void startGame(View view) {
        SharedPreferences sh = getSharedPreferences("Data", Context.MODE_PRIVATE);
        if (TextUtils.isEmpty(takeName.getText().toString()))
            takeName.setError("Empty");
        else {
            s = takeName.getText().toString();
            String check = sh.getString(s, de);
            if (!(check.equals(de))) {
                Bundle b = new Bundle();
                b.putString("name", s);
                Intent intent = new Intent(StartPage.this, Choosing.class);
                intent.putExtras(b);
                startActivity(intent);
            } else {
                AlertDialog.Builder newName = new AlertDialog.Builder(StartPage.this);
                newName.setMessage("Do you Want to Register this new Name?!");
                newName.setTitle("New Name!!");
                newName.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences sh = getSharedPreferences("Data", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sh.edit();
                        editor.putString(s, "0");
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

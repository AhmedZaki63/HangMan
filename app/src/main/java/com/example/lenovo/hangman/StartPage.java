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
    Names name;
    EditText takeeName;
    Toolbar mToolBar;
    String de="a21a5sd";
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        mToolBar=(Toolbar)findViewById(R.id.start_toolbar);
        mToolBar.setTitle("Start");
        setSupportActionBar(mToolBar);
        start = (Button)findViewById(R.id.btnStart);
        takeeName=(EditText)findViewById(R.id.takeName);
        takeeName.setText("");
        name=new Names(this);
    }

    public void startGame(View view){
        SharedPreferences sh=getSharedPreferences("Data", Context.MODE_PRIVATE);
        if(TextUtils.isEmpty(takeeName.getText().toString()))
            takeeName.setError("Empty");
        else{
            s1=takeeName.getText().toString();
            String check=sh.getString(s1,de);
            if(!(check.equals(de))){
                Toast.makeText(StartPage.this,"Done",Toast.LENGTH_SHORT).show();
                Bundle b=new Bundle();
                b.putString("name",s1);
                Intent intent=new Intent(StartPage.this,Choosing.class);
                intent.putExtras(b);
                startActivity(intent);
            }
            else{
                AlertDialog.Builder newName = new AlertDialog.Builder(StartPage.this);
                newName.setMessage("Do you Want to Register this new Name?!");
                newName.setTitle("New Name!!");
                newName.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences sh=getSharedPreferences("Data",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sh.edit();
                        editor.putString(s1,"0");
                        editor.apply();
                        Toast.makeText(StartPage.this, "Done", Toast.LENGTH_SHORT).show();
                        takeeName.setText(s1);
                    }
                });
                newName.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        takeeName.setText("");
                    }
                });
                newName.create().show();
            }
        }
    }
}

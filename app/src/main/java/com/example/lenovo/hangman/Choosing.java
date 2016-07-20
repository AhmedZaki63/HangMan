package com.example.lenovo.hangman;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigInteger;

public class Choosing extends AppCompatActivity {
    ListView list;
    String name;
    Toolbar mToolBar;
    ArrayAdapter<String> adapter;
    String[] catar={
            "Anime",
            "Movies",
            "Games",
            "Fruits",
            "Vegetables",
            "Countries",
            "Animals",
            "Colors",
            "Football Teams"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);
        list=(ListView)findViewById(R.id.listView);
        mToolBar=(Toolbar)findViewById(R.id.choose_toolbar);
        setSupportActionBar(mToolBar);
        Bundle b1=getIntent().getExtras();
        name=b1.getString("name");
        adapter = new ArrayAdapter<String>(this,R.layout.list_custom_try1,R.id.listItem,catar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String sg=adapter.getItem(position).toString();
                AlertDialog.Builder newName = new AlertDialog.Builder(Choosing.this);
                newName.setMessage("Do you want to choose " + sg + "?!");
                newName.setTitle("category!!");
                newName.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Kind", adapter.getItem(position));
                        b.putString("name",name);
                        Intent intent = new Intent(Choosing.this, GameZaki.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });
                newName.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                newName.create().show();
            }
        });
    }
}
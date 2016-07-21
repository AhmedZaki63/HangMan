package com.example.lenovo.hangman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Choosing extends AppCompatActivity {
    ListView list;
    //String name;
    Toolbar myToolBar;
    ArrayAdapter<String> adapter;
    String[] category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);
        list = (ListView) findViewById(R.id.listView);
        category = getResources().getStringArray(R.array.category);
        myToolBar = (Toolbar) findViewById(R.id.choose_toolbar);
        myToolBar.setTitle("Choose Category");
        myToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolBar);
        Bundle b1 = getIntent().getExtras();
        //name = b1.getString("name");
        adapter = new ArrayAdapter<>(this, R.layout.list_custom_try1, R.id.listItem, category);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String sg = adapter.getItem(position);
                AlertDialog.Builder newName = new AlertDialog.Builder(Choosing.this);
                newName.setMessage("Do you want to choose " + sg + "?!");
                newName.setTitle("category!!");
                newName.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Kind", adapter.getItem(position));
                        //b.putString("name", name);
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

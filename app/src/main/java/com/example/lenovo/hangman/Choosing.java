package com.example.lenovo.hangman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Choosing extends AppCompatActivity {
    ListView list;
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

        adapter = new ArrayAdapter<>(this, R.layout.list_custom_try1, R.id.listItem, category);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Bundle b = new Bundle();
                b.putString("Kind", adapter.getItem(position));
                Intent intent = new Intent(Choosing.this, GameZaki.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }
    /*
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem settingsMenuItem = menu.findItem(R.id.menu);
        SpannableString s = new SpannableString(settingsMenuItem.getTitle());
        s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, s.length(), 0);
        settingsMenuItem.setTitle(s);

        return super.onPrepareOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu) {
            Intent intent = new Intent(Choosing.this, Setting.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}

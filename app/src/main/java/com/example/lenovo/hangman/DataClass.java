package com.example.lenovo.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import java.math.BigInteger;

/**
 * Created by Lenovo on 8/13/2016.
 */
public class DataClass {
    Context context;
    private SharedPreferences.Editor setNew,setName;
    private SharedPreferences getName,getScore;
    String de = "a21a5sd";
    public DataClass(Context context){
        this.context=context;
        setNew = context.getSharedPreferences("Data", context.MODE_PRIVATE).edit();
        setName = context.getSharedPreferences("User", context.MODE_PRIVATE).edit();
        getName = context.getSharedPreferences("User", Context.MODE_PRIVATE);
        getScore = context.getSharedPreferences("Data", Context.MODE_PRIVATE);
    }

    public void SetName (String name){
        setName.putString("key", name);
        setName.apply();
    }

    public void SetNew(String name){
        setNew.putString(name,"0");
        setNew.apply();
    }

    public boolean search(String name){
        String tt = getScore.getString(name,de);
        if(tt.equals(de))
            return false;
        else
            return true;
    }

    public void addScore(){
        String name = getName.getString("key",de);
        BigInteger n1 = new BigInteger(getScore.getString(name,de));
        BigInteger n2 = new BigInteger("1");
        n1=n1.add(n2);
        setNew.putString(name,n1.toString());
        setNew.apply();
    }

    public String GetScore(){
        String name = getName.getString("key",de);
        return getScore.getString(name,de);
    }


}

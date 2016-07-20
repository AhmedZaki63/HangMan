package com.example.lenovo.hangman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Lenovo on 7/14/2016.
 */
public class Names {


    Namess  names;
    public Names(Context context) {

        names = new Namess(context);
    }

    //Insert
    public long nameInsert(String name){

        SQLiteDatabase sqLiteDatabase = names.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(names.name,name);
        contentValues.put(names.score,"0");
        long id = sqLiteDatabase.insert(Namess.tableName,null,contentValues);
        return id;
    }

    //Search
    public String searchName(String name){
        SQLiteDatabase sqLiteDatabase = names.getWritableDatabase();

        String [] columns = {Namess.name};

        Cursor cursor = sqLiteDatabase.query(Namess.tableName,columns,Namess.name+" = '"+name+"'" ,null,null,null,null);

        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext())
        {

            int index3 = cursor.getColumnIndex(Namess.name);
            String namee = cursor.getString(index3);

            stringBuffer.append(namee);
        }
        return stringBuffer.toString();
    }
    public String searchScore(String name){
        SQLiteDatabase sqLiteDatabase = names.getWritableDatabase();

        String [] columns = {Namess.name, Namess.score};

        Cursor cursor = sqLiteDatabase.query(Namess.tableName,columns,Namess.name+" = '"+name+"'" ,null,null,null,null);

        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext())
        {

            int index3 = cursor.getColumnIndex(Namess.score);
            String scoree = cursor.getString(index3);

            stringBuffer.append(scoree);
        }
        return stringBuffer.toString();
    }

    //Update
    public void updateScore(String name,String newScore){
        SQLiteDatabase db=names.getWritableDatabase();
        //db.execSQL("update TRY11 set password='" + pass + "'where Username="+name);
        ContentValues c=new ContentValues();
        c.put("Score",newScore);
        db.update("DATAUSER",c,"Name = ? ",new String[] {name});

    }

    //Design Table
    static class Namess extends SQLiteOpenHelper {


        private static final String dataBase_Name = "Users";
        private static final String tableName = "DATAUSER";
        private static final int dataBase_Version = 1;
        private static final String UID = "id";
        private static final String name = "Name";
        private static final String score = "Score";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+tableName;
        private static final String CREATE_TABLE = "CREATE TABLE "+tableName+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+name+" VARCHAR(255), "+score+" VARCHAR(255));";
        private Context context;


        public Namess(Context context) {
            super(context, dataBase_Name, null, dataBase_Version);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try{
                db.execSQL(CREATE_TABLE);
            }catch (SQLException e){
                Toast.makeText(context, "due to: " + e, Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


            try{
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context,"due to: "+e,Toast.LENGTH_LONG).show();
            }

        }
    }

}

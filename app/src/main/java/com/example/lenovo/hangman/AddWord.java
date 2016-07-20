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
public class AddWord {

    Word  AddNewWord;
    public AddWord(Context context) {

        AddNewWord = new Word(context);
    }


    //Insert
    public long WordInsert(String word){

        SQLiteDatabase sqLiteDatabase = AddNewWord.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Word.woord,word);
        long id = sqLiteDatabase.insert(Word.tableName,null,contentValues);
        return id;
    }


    //Search
    public String searchWord(String name){
        SQLiteDatabase sqLiteDatabase = AddNewWord.getWritableDatabase();

        String [] columns = {Word.woord};

        Cursor cursor = sqLiteDatabase.query(Word.tableName,columns,Word.woord+" = '"+name+"'" ,null,null,null,null);

        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext())
        {

            int index3 = cursor.getColumnIndex(Word.woord);
            String wOrd = cursor.getString(index3);

            stringBuffer.append(wOrd);
        }
        return stringBuffer.toString();
    }



    //Design Table
    static class Word extends SQLiteOpenHelper {


        private static final String dataBase_Name = "Word";
        private static final String tableName = "WordBase";
        private static final int dataBase_Version = 1;
        private static final String UID = "id";
        private static final String woord = "Word";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+tableName;
        private static final String CREATE_TABLE = "CREATE TABLE "+tableName+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+woord+" VARCHAR(255));";
        private Context context;


        public Word(Context context) {
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

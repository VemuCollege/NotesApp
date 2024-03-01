package com.mani.notesappdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public  static  int DB_VERSION = 1;
    public static  String DB_NAME = "MYNotesApp";

    String NOTES_ID_COLUMN = "notesID";
    String NOTES_CONTENT_COLUMN = "notesContent";
    String NOTES_CREATION_DATE_COLUMN = "notesCreationDate";

    SQLiteDatabase db = null;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table NOTESTBL(notesID INTEGER PRIMARY KEY AUTOINCREMENT, notesContent TEXT, notesCreationDate TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long insertNotesContentData(String notesContent,String notesCreationDate) {

        db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NOTES_CONTENT_COLUMN,notesContent);
        cv.put(NOTES_CREATION_DATE_COLUMN,notesCreationDate);

        long id = db.insert("NOTESTBL",null,cv);
        return id;



    }
}

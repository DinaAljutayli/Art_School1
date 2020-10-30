package com.example.artschool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {


    public static String DATABASE_NAME ="art.db";

    public static String DATABASE_TABLE = "students";
    public static String COL_NAME ="_name";
    public static String COL_ID ="_id";
    public static String COL_GRADE ="_grade";



    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String quryAdd = "CREATE TABLE "+ DATABASE_TABLE + " (" +
                COL_ID + " TEXT, "+
                COL_GRADE + " TEXT, "+
                COL_NAME + " TEXT);";

        sqLiteDatabase.execSQL(quryAdd);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);

    }

    public long addStudent(String name,String id,String grade)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_ID,id);
        cv.put(COL_GRADE,grade);

        long res = db.insert(DATABASE_TABLE,null,cv);

        return res;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from "+ DATABASE_TABLE , null);
        return c;



    }
}

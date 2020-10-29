package com.example.artschool;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Art.db";
    private SQLiteDatabase db;

    //login table
    public static final String TABLE_LOGIN ="loginuser";
    public static final String COL_USERNAME ="Username";
    public static final String COL_Password ="password";
    private static final String LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "(" + COL_USERNAME + " TEXT ," + COL_Password + " TEXT," + ")";

    //student table
    public static final String TABLE_StudenINFO = "StudentInfo";
    public static final String COL_Name = "Name";
    public static final String COL_ID = " ID";
    public static final String COL_Grade = "Grade";
    private static final String Student_TABLE = "CREATE TABLE " + TABLE_StudenINFO + "(" + COL_Name + " TEXT ," + COL_Grade + " TEXT," + COL_ID + " PRIMARY KEY" + ")";

    public DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null, 1);
    }


    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL(LOGIN_TABLE);
        db.execSQL(Student_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_LOGIN + TABLE_StudenINFO);
        onCreate(sqLiteDatabase);
    }


    public long addusert(String username, String password ){
        // SQLiteDatabase db = this.getWritableDatabase();
        openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",username);
        contentValues.put("Password",password);
        long res = db.insert("LOGIN_TABLE",null,contentValues);
        db.close();
        return  res;
    }


    public long addStudent(String name, String id , String grade){
       // SQLiteDatabase db = this.getWritableDatabase();
        openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("ID",id);
        contentValues.put("Grade",grade);
        long res = db.insert("StudentInfo",null,contentValues);
        db.close();
        return  res;
    }


    public void openDatabase() {
        db = this.getWritableDatabase();
    }



}

package com.example.studentlocator.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

//import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database =getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertStudent(String firstName,String lastName, String regNo,String school,String department,String course,String hostel,String roomNo,String hobby,String password){
        SQLiteDatabase database = getWritableDatabase();
        String sql ="INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,firstName);
        statement.bindString(2,lastName);
        statement.bindString(3,regNo);
        statement.bindString(4,school);
        statement.bindString(5,department);
        statement.bindString(6,course);
        statement.bindString(7,hostel);
        statement.bindString(8,roomNo);
        statement.bindString(9,hobby);
        statement.bindString(10,password);
        statement.executeInsert();
    }
    public Cursor AllStudents(String hobby){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM student WHERE hobby=?",new String[]{hobby});
        return cursor;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

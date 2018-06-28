package com.example.asus.austcgpacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2/9/2018.
 */

public class ResultDBHandeler extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "CGPADB";
    private static final String tableName = "result";
    private static final String keyUser = "user";
    private static final String keySemester = "Semester";
    private static final String keyGPA = "GPA";

    public ResultDBHandeler(Context context) {

        super(context, databaseName,null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+tableName +"(" +keyUser+" TEXT, " +keySemester+" TEXT, " +keyGPA+" REAL" +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion1) {
        String sql = "DROP TABLE IF EXISTS "+tableName;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertResult(Result res){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(keyUser, res.getUser());
        values.put(keySemester, res.getSemester());
        values.put(keyGPA, res.getCg());

        db.insert(tableName,null, values);
        db.close();
    }

    public List<Result> getAllResults(String user){
        SQLiteDatabase db = this.getReadableDatabase();

        List<Result> resList = new ArrayList<>();
        String sql = "SELECT * FROM "+tableName;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Result res = new Result(cursor.getString(0).toString(), cursor.getString(1).toString(), Double.parseDouble(cursor.getString(2).toString()));
                if(res.getUser().equals(user))resList.add(res);
            }while (cursor.moveToNext());
        }
        db.close();
        return resList;
    }
}

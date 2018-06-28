package com.example.asus.austcgpacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 2/9/2018.
 */

public class loginDBHaandeler extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "expenseManagerDB";
    private static final String tableName = "accounts";
    private static final String keyId = "id";
    private static final String keyUserName = "user";
    private static final String keyPassword = "pass";

    public loginDBHaandeler(Context context) {

        super(context, databaseName,null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+tableName +"(" +keyUserName+" TEXT PRIMARY KEY, " +keyPassword+" REAL" +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion1) {
        String sql = "DROP TABLE IF EXISTS "+tableName;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(keyUserName, user.getUser_name());
        values.put(keyPassword, user.getPassword());

        db.insert(tableName,null, values);
        db.close();
    }

    public User getuser(String user_name, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tableName, new String[] {keyUserName, keyPassword}, null, null, null, null, null, null);
        cursor.moveToFirst();

        User user = null;
        for (int i = 0; i < cursor.getCount() ;i++){
            cursor.moveToPosition(i);
            if (user_name.equals(cursor.getString(0)) && password.equals(cursor.getString(1))){
                user = new User(cursor.getString(0), cursor.getString(1));
                db.close();
                return user;
            }
        }
        db.close();
        return user;
    }
}

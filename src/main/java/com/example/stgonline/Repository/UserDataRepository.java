package com.example.stgonline.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stgonline.Data.DBHelper;
import com.example.stgonline.Entity.UserData;

public class UserDataRepository {

    private Context _context;
    public static final String TABLE_USER_DATA = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "_name";
    public static final String KEY_VALUE = "_value";
    private DBHelper _dbHelper;

    public UserDataRepository(Context context){
        _context = context;
        _dbHelper = new DBHelper(context);
    }

    public void add(UserData userData){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, userData.getName());
        contentValues.put(KEY_VALUE, userData.getValue());

        db.insert(TABLE_USER_DATA, null, contentValues);
        db.close();
    }

    public UserData findById(int userDataId){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();

        UserData userData = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER_DATA + " WHERE ... ORDER BY _id DESC LIMIT 1", null);
        if (cursor.moveToFirst()){
            do {
                // Passing values
                int id = cursor.getInt(0);
                ...
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return userData;
    }

    public UserData findByName(String userDataName){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();

        ...
        db.close();

        return userData;
    }

    public void listAll(){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();

        ...
        db.close();
    }

    public void update(UserData userData){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        ...
        int numberOfUpdatedRows = db.update(TABLE_USER_DATA, contentValues, "_id = ?", new String[]{id});
        db.close();
    }

    public void delete(UserData userData){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        db.delete(TABLE_USER_DATA, "_id = ?", new String[]{String.valueOf(userData.getId())});
        db.close();
    }

    public void clearAll(){
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        db.delete(TABLE_USER_DATA, null,null);
        db.close();
    }
}

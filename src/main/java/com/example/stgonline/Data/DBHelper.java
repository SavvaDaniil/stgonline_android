package com.example.stgonline.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.stgonline.Repository.UserDataRepository;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 000000000000000;
    private static final String DATABASE_NAME = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + XXXXXXXXXXXXXXXXXXXXXXXXX
                + " (" + XXXXXXXXXXXXXXXXXXXXXXXXX + " integer primary key autoincrement, "
        + XXXXXXXXXXXXXXXXXXXXXXXXX + " text, "
        + XXXXXXXXXXXXXXXXXXXXXXXXX + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UserDataRepository.TABLE_USER_DATA);
        onCreate(db);
    }
}

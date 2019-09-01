package com.example.user.funarabicapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author javierAle
 */
public class MySQLHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "register_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "PHONE";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PASS";
    public static final String COL_7 = "PASS2";

    public MySQLHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USERNAME TEXT, PHONE INTEGER, EMAIL TEXT, PASS TEXT, PASS2 TEXT) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData (String name, String username, String phone, String email, String pass, String pass2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put (COL_2, name);
        contentValues.put (COL_3, username);
        contentValues.put (COL_4, phone);
        contentValues.put (COL_5, email);
        contentValues.put (COL_6, pass);
        contentValues.put (COL_7, pass2);
        long result = db.insert (TABLE_NAME, null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(" select * from " + TABLE_NAME, null );
        return c;

    }

    public boolean updateData (String id, String name, String surname, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put (COL_1, id);
        contentValues.put (COL_2, name);
        contentValues.put (COL_3, surname);
        contentValues.put (COL_4, marks);
        db.update(TABLE_NAME, contentValues, "ID = ? ", new String[] { id });
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ? ", new String[] { id });

    }

    public Cursor fetchAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.query(TABLE_NAME, new String[]{ COL_1,COL_3,COL_6,}, null,null,null,null,null,null);
        return res;
    }
}


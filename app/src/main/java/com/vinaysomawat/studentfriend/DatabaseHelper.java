package com.vinaysomawat.studentfriend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import junit.runner.Version;

/**
 * Created by Vinay Somawat on 06-01-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATBASE_NAME = "mydatabase.db";
    public static final int DATABASE_VERSION = 1;

    private static String CREATE_TABLE = " CREATE TABLE " + Course.TABLE_NAME + " ( "+ Course.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            Course.COURSE_NAME + " TEXT,"+Course.BUNK_COUNT + " INTEGER, "+Course.LEC_TIME + " INTEGER);";

    public void test()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //onUpgrade(db,1,2);
        onUpgrade(db,1,2);
        Log.d("course","testing of database done");
    }

    public DatabaseHelper(Context c)
    {
        super(c,DATBASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        Log.d("course","going to create table course");
        db.execSQL(CREATE_TABLE);
        Log.d("course","creation done");
    }

    public void insert(String course_name,int bunk_count,int lect_time)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
      //  values.put(Course.ID,10);
        values.put(Course.COURSE_NAME,course_name);
        values.put(Course.BUNK_COUNT,bunk_count);
        values.put(Course.LEC_TIME,lect_time);
        db.insert(Course.TABLE_NAME,null,values);
        db.close();
        Log.d("course","insertion done");
    }

    public void delete(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Course.TABLE_NAME,Course.ID +"=?",new String[]{String.valueOf(id)});
        Log.d("course","deleted with id : "+id);
    }

    public void update(int id,String course_name,int bunk_count,int lect_time)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Course.COURSE_NAME,course_name);
        values.put(Course.BUNK_COUNT,bunk_count);
        values.put(Course.LEC_TIME,lect_time);

        db.update(Course.TABLE_NAME,values,Course.ID + "=?" , new String[]{String.valueOf(id)});

        Log.d("course","updated new value of : "+id);
    }

   // public void search(String )

    public Course[] get_all()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Course.TABLE_NAME,null);

        //int index  = cursor.getColumnIndex();
        int course_id = cursor.getColumnIndex(Course.ID);
        int course_name_index = cursor.getColumnIndex(Course.COURSE_NAME);
        int bunk_count_index = cursor.getColumnIndex(Course.BUNK_COUNT);
        int lec_time_index = cursor.getColumnIndex(Course.LEC_TIME);

        Course[] all_courses = new Course[cursor.getCount()];
        int i =0;
        while(cursor.moveToNext())
        {
            Log.d("course",cursor.getInt(course_id)+" "+cursor.getString(course_name_index) + " " + cursor.getInt(bunk_count_index) + " " + cursor.getInt(lec_time_index));
            Course temp = new Course(cursor.getInt(course_id),cursor.getString(course_name_index),cursor.getInt(bunk_count_index),cursor.getInt(lec_time_index));
            all_courses[i] = temp;
            i++;
        }

        Log.d("mylist","value of i : "+Integer.toString(i));

        db.close();
        return all_courses;
    }

//    public void insert(String course_name)
//    {
//        Log.d("course","going to insert");
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(Course.COURSE_NAME,name);
//        db.insert(Course.TABLE_NAME,null,values);
//        db.close();
//        Log.d("course","key is inserted");
//    }

    public void delete_table()
    {
        String delete = "DROP TABLE " + Course.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(delete);
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+Course.TABLE_NAME);
        onCreate(db);
    }

}

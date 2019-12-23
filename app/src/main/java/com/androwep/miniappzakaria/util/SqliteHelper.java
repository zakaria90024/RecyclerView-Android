package com.androwep.miniappzakaria.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.androwep.miniappzakaria.util.data.local.Student;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {
    private final String TABLE1="tbl_student";
    private final String TABLE1_COL1="st_id";
    private final String TABLE1_COL2="name";
    private final String TABLE1_COL3="dep_id";
    private final String TABLE1_COL4="category";
    private final String TABLE1_COL5="price";
    private final String TABLE1_COL6="discreption";

    public SqliteHelper(@Nullable Context context) {
        super(context, "studentdb", null, 1);
    }

    public void save(String name,int dep_id, String category, String price, String discreption ){
        ContentValues values=new ContentValues();
        values.put(TABLE1_COL2,name);
        values.put(TABLE1_COL3,dep_id);

        values.put(TABLE1_COL4,category);
        values.put(TABLE1_COL5,price);
        values.put(TABLE1_COL6,discreption);

        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(TABLE1,null,values);

    }

    public List<Student> getAllStudent()
    {
        List<Student> students=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE1+" ORDER BY "+TABLE1_COL1+" DESC";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            while (cursor.moveToNext())
            {
                String id=cursor.getString(cursor.getColumnIndex(TABLE1_COL1));
                String name=cursor.getString(cursor.getColumnIndex(TABLE1_COL2));
                String dep=cursor.getString(cursor.getColumnIndex(TABLE1_COL3));

                String category=cursor.getString(cursor.getColumnIndex(TABLE1_COL4));
                String price=cursor.getString(cursor.getColumnIndex(TABLE1_COL5));
                String discreption=cursor.getString(cursor.getColumnIndex(TABLE1_COL6));

                Student student=new Student(Integer.parseInt(id),name,Integer.parseInt(dep),category,price,discreption);
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> searchStudent(final int sid)
    {
        List<Student> students=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE1+" WHERE "+TABLE1_COL1+" = "+sid;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            while (cursor.moveToNext())
            {
                String id=cursor.getString(cursor.getColumnIndex(TABLE1_COL1));
                String name=cursor.getString(cursor.getColumnIndex(TABLE1_COL2));
                String dep=cursor.getString(cursor.getColumnIndex(TABLE1_COL3));

                String category=cursor.getString(cursor.getColumnIndex(TABLE1_COL4));
                String price=cursor.getString(cursor.getColumnIndex(TABLE1_COL5));
                String discreption=cursor.getString(cursor.getColumnIndex(TABLE1_COL6));


                Student student=new Student(Integer.parseInt(id),name,Integer.parseInt(dep),category, price, discreption);
                students.add(student);
            }
        }
        return students;
    }



    public void delete(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE1,""+TABLE1_COL1+" = ?",new String[]{""+id});
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1= "CREATE TABLE "+TABLE1+" ("+TABLE1_COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE1_COL2+" VARCHAR(50), "+TABLE1_COL3+" INTEGER, "+TABLE1_COL4+" VARCHAR(50), "+TABLE1_COL5+" VARCHAR(50), "+TABLE1_COL6+" VARCHAR(50))";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropQuery="DROP TABLE IF EXISTS "+TABLE1;
        db.execSQL(dropQuery);
        onCreate(db);
    }

    public void update(Student student) {

        int id=student.getId();
        String name = student.getName();
        int dep_id = student.getDep_id();



        ContentValues values=new ContentValues();
        values.put(TABLE1_COL2,""+name);
        values.put(TABLE1_COL3,""+dep_id);





        SQLiteDatabase db=this.getWritableDatabase();
        db.update(TABLE1,values,""+TABLE1_COL1+" = ?",new String[]{""+id});
    }
}

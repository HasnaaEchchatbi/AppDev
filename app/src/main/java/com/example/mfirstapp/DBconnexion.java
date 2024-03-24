package com.example.mfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBconnexion extends SQLiteOpenHelper {
    public DBconnexion(Context context) {
        super(context, "UserDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table user(email TEXT primary key ,password TEXT )");
        db.execSQL("create Table annonce(titre TEXT primary key ,ville TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
    }
    public int countJobsByCity(String ville) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Exécuter la requête SQL pour compter le nombre d'annonces pour la ville donnée
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + " annonce "+
                " WHERE " + ville + " = ?", new String[]{ville});

        int count = 0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0); // Récupérer le nombre d'annonces
            }
            cursor.close();
        }

        return count;
    }
    public Boolean insertuserdata( String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        long result = db.insert("user", null, values);
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from annonce", null);
        return cursor;
    }
    public Boolean insertannoncedata( String titre, String ville) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titre", titre);
        values.put("ville", ville);
        long result = db.insert("annonce", null, values);
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkusername(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor =db.rawQuery("Select * from user where email = ?",new String[] {email});
      if(cursor.getCount() >0)
      {return true;}
      else
      {return false;}

    }
    public Boolean checkpassword(String email ,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery("Select * from user where email = ? and password = ?",new String[] {email,password});
        if(cursor.getCount() >0)
        {return true;}
        else
        {return false;}

    }

}

package com.example.phone_service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import aidlservice.ContactModel;
import aidlservice.FavoriteModel;
import aidlservice.RecentModel;

public class PhoneDbHandler extends SQLiteOpenHelper {

    public PhoneDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Table for storing contacts
        String createContactTable = "CREATE TABLE " + Params.CONTACTS_TABLE_NAME + " ("
                + Params.CONTACT_ID + " INTEGER PRIMARY KEY, " + Params.CONTACT_NAME
                + " TEXT, " + Params.CONTACT_NUMBER + " TEXT" + ")";
        db.execSQL(createContactTable);

        //Table for storing favorites
        String createFavoriteTable = "CREATE TABLE " + Params.FAVORITES_TABLE_NAME + " ("
                + Params.CONTACT_ID + " INTEGER PRIMARY KEY, " + Params.FAVORITE_NAME
                + " TEXT, " + Params.FAVORITE_NUMBER + " TEXT" + ")";
        db.execSQL(createFavoriteTable);

        //Table for storing recents
        String createRecentTable = "CREATE TABLE " + Params.RECENTS_TABLE_NAME + " ("
                + Params.RECENT_ID + " INTEGER PRIMARY KEY, " + Params.RECENT_NAME
                + " TEXT, " + Params.RECENT_NUMBER + " TEXT, " + Params.RECENT_DATE + " TEXT " + ")";
        db.execSQL(createRecentTable);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //ContactTableHandler
    public void addContact(ContactModel contact) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.CONTACT_NAME, contact.getName());
        values.put(Params.CONTACT_NUMBER, contact.getNumber());
        db.insert(Params.CONTACTS_TABLE_NAME, null, values);
        Log.d("contactsdb", "Successfully inserted");
        db.close();
    }

    public List<ContactModel> getAllContacts() {
        List<ContactModel> contactsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        //Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CONTACTS_TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        //Loop through now
//        id, name, duration, date
        if (cursor.moveToFirst()) {
            do {
                ContactModel contacts = new ContactModel();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setNumber(cursor.getString(2));
                contactsList.add(0, contacts);
            } while (cursor.moveToNext());
        }
        db.close();
        return contactsList;
    }

    public int updateContact(ContactModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.CONTACT_NAME, contact.getName());
        values.put(Params.CONTACT_NUMBER, contact.getNumber());
        //Upadte now, return of update() is number of affected rows
        return db.update(Params.CONTACTS_TABLE_NAME, values, Params.CONTACT_ID + "=?",
                new String[]{String.valueOf(contact.getId())});


    }

    public void deleteContactById(int contact_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.CONTACTS_TABLE_NAME, Params.CONTACT_ID + "=?", new String[]{String.valueOf(contact_id)});
        db.close();

    }

    public void deleteContact(ContactModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.CONTACTS_TABLE_NAME, Params.CONTACT_ID + "=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public int getContactsCount() {
        String query = "SELECT * FROM " + Params.CONTACTS_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }

    //FavoriteTableHandler
    public void addFavorite(FavoriteModel favorite) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.FAVORITE_NAME, favorite.getName());
        values.put(Params.FAVORITE_NUMBER, favorite.getNumber());
        db.insert(Params.FAVORITES_TABLE_NAME, null, values);
        db.close();
    }

    public List<FavoriteModel> getAllFavorites() {
        List<FavoriteModel> favoritesList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        //Generate the query to read from the database
        String select = "SELECT * FROM " + Params.FAVORITES_TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        //Loop through now
        if (cursor.moveToFirst()) {
            do {
                FavoriteModel favorites = new FavoriteModel();
                favorites.setId(Integer.parseInt(cursor.getString(0)));
                favorites.setName(cursor.getString(1));
                favorites.setNumber(cursor.getString(2));
                favoritesList.add(0, favorites);
            } while (cursor.moveToNext());
        }
        db.close();
        return favoritesList;

    }

    public int updateFavorite(FavoriteModel favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.FAVORITE_NAME, favorite.getName());
        values.put(Params.FAVORITE_NUMBER, favorite.getNumber());
        //Update now, return of update() is number of affected rows
        return db.update(Params.FAVORITES_TABLE_NAME, values, Params.FAVORITE_ID + "=?",
                new String[]{String.valueOf(favorite.getId())});


    }

    public void deleteFavoriteById(int favorite_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.FAVORITES_TABLE_NAME, Params.FAVORITE_ID + "=?", new String[]{String.valueOf(favorite_id)});
        db.close();

    }

    public void deleteFavorite(FavoriteModel favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.FAVORITES_TABLE_NAME, Params.FAVORITE_ID + "=?", new String[]{String.valueOf(favorite.getId())});
        db.close();
    }

    public int getFavoritesCount() {
        String query = "SELECT * FROM " + Params.FAVORITES_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }


    //RecentTableHandler
    public void addRecent(RecentModel recent) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.RECENT_NAME, recent.getName());
        values.put(Params.RECENT_NUMBER, recent.getNumber());
        values.put(Params.RECENT_DATE, recent.getDate());
        db.insert(Params.RECENTS_TABLE_NAME, null, values);
        Log.d("recentsdb", "Successfully inserted");
        db.close();
    }

    public List<RecentModel> getAllRecents() {
        List<RecentModel> recentsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        //Generate the query to read from the database
        String select = "SELECT * FROM " + Params.RECENTS_TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        //Loop through now
//        id, name, duration, date
        if (cursor.moveToFirst()) {
            do {
                RecentModel recents = new RecentModel();
                recents.setId(Integer.parseInt(cursor.getString(0)));
                recents.setName(cursor.getString(1));
                recents.setNumber(cursor.getString(2));
//                recents.setDate(cursor.getString(3));
                recents.setDate(cursor.getString(3));
                recentsList.add(0, recents);
            } while (cursor.moveToNext());
        }
        db.close();
//sorting the list
//        Collections.sort(recentsList, RecentModel.recentsModelDateComparator);
        return recentsList;
//        return new ArrayList<>(); //empty list for testing "empty recent list" message

    }

    public int updateRecent(RecentModel recent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.RECENT_NAME, recent.getName());
        values.put(Params.RECENT_NUMBER, recent.getNumber());
        values.put(Params.RECENT_DATE, recent.getDate());
        //Upadte now, return of update() is number of affected rows
        return db.update(Params.RECENTS_TABLE_NAME, values, Params.RECENT_ID + "=?",
                new String[]{String.valueOf(recent.getId())});


    }

    public void deleteRecentById(int recent_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.RECENTS_TABLE_NAME, Params.RECENT_ID + "=?", new String[]{String.valueOf(recent_id)});
        db.close();

    }

    public void deleteRecent(RecentModel recent) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.RECENTS_TABLE_NAME, Params.RECENT_ID + "=?", new String[]{String.valueOf(recent.getId())});
        db.close();
    }

    public int getRecentsCount() {
        String query = "SELECT * FROM " + Params.RECENTS_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }


}

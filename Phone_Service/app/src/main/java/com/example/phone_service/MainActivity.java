package com.example.phone_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import aidlservice.ContactModel;
import aidlservice.FavoriteModel;
import aidlservice.RecentModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // add dummy data if tables are empty.
        // PhoneDbHandler phoneDbHandler = new PhoneDbHandler(this);
//
//        if (phoneDbHandler.getContactsCount() == 0) {
//            ContactModel contact1 = new ContactModel();
//            contact1.setName("Thomas");
//            contact1.setNumber("9638368373");
//            phoneDbHandler.addContact(contact1);
//
//            ContactModel contact2 = new ContactModel();
//            contact2.setName("Ravi");
//            contact2.setNumber("7063736736");
//            phoneDbHandler.addContact(contact2);
//        }
//        if (phoneDbHandler.getRecentsCount() == 0) {
//            RecentModel recent1 = new RecentModel();
//            recent1.setName("Thomas");
//            recent1.setNumber("9638368373");
//            recent1.setDate();
//            phoneDbHandler.addRecent(recent1);
//
//            RecentModel recent2 = new RecentModel();
//            recent2.setName("Ravi");
//            recent2.setNumber("7063736736");
//            recent2.setDate();
//            phoneDbHandler.addRecent(recent2);
//        }
//
//        if (phoneDbHandler.getFavoritesCount() == 0) {
//            FavoriteModel fav1 = new FavoriteModel();
//            fav1.setName("Amal");
//            fav1.setNumber("9638368373");
//            phoneDbHandler.addFavorite(fav1);

//            FavoriteModel fav2 = new FavoriteModel();
//            fav2.setName("Ravi");
//            fav2.setNumber("7063736736");
//            phoneDbHandler.addFavorite(fav2);
//
//            FavoriteModel fav3 = new FavoriteModel();
//            fav3.setName("aaa");
//            fav3.setNumber("3233131331");
//            phoneDbHandler.addFavorite(fav3);
//        }
//
        permissionCallPhone();
        permissionReadContacts();
        getContacts();

    }

    @SuppressLint("Range")
    private void getContacts() {
        PhoneDbHandler phoneDbHandler = new PhoneDbHandler(this);

        @SuppressLint("Recycle") Cursor cursor = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        cursor.moveToFirst();
        do {
            phoneDbHandler.addContact(new ContactModel(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));

        } while (cursor.moveToNext());

        // add dummy contacts if no contacts are available.

        if (phoneDbHandler.getContactsCount() == 0) {
            ContactModel contact1 = new ContactModel();
            contact1.setName("Thomas");
            contact1.setNumber("9638368373");
            phoneDbHandler.addContact(contact1);

            ContactModel contact2 = new ContactModel();
            contact2.setName("Ravi");
            contact2.setNumber("7063736736");
            phoneDbHandler.addContact(contact2);
        }

    }

    private void permissionReadContacts() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        }

    }

    private void permissionCallPhone() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

    }
}
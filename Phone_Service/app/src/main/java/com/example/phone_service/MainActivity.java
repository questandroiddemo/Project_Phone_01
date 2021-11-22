package com.example.phone_service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import aidlservice.ContactModel;
import aidlservice.FavoriteModel;
import aidlservice.RecentModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding dummy objects to the PhoneDb tables
        PhoneDbHandler phoneDbHandler = new PhoneDbHandler(this);

        RecentModel recent1 = new RecentModel();
        recent1.setName("Thomas");
        recent1.setNumber("9638368373");
        recent1.setDate();
        phoneDbHandler.addRecent(recent1);

        RecentModel recent2 = new RecentModel();
        recent2.setName("Ravi");
        recent2.setNumber("7063736736");
        recent2.setDate();
        phoneDbHandler.addRecent(recent2);

        FavoriteModel fav1 = new FavoriteModel();
        fav1.setName("Thomas");
        fav1.setNumber("9638368373");
        phoneDbHandler.addFavorite(fav1);

        FavoriteModel fav2 = new FavoriteModel();
        fav2.setName("Ravi");
        fav2.setNumber("7063736736");
        phoneDbHandler.addFavorite(fav2);

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
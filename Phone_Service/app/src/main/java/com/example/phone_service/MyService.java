package com.example.phone_service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;


import java.util.ArrayList;
import java.util.List;

import aidlservice.ContactModel;
import aidlservice.FavoriteModel;
import aidlservice.IMyAidlInterface;
import aidlservice.RecentModel;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }


    IMyAidlInterface.Stub iBinder = new IMyAidlInterface.Stub() {
        @Override
        public String getText() throws RemoteException {
            return "hello from service app!!!!!!";
        }

        @Override
        public void placeCall(String number) throws RemoteException {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_FROM_BACKGROUND);
            startActivity(intent);
        }

        @Override
        public List<String> getList() throws RemoteException {
            List<String> list = new ArrayList<>();
            list.add("Phone");
            list.add("Contact");
            list.add("Favorite");
            list.add("Recent");
            return list;
        }

        @Override
        public List<RecentModel> getAllRecents() throws RemoteException {
            List<RecentModel> recentModelArrayList = new ArrayList<>();
            PhoneDbHandler phoneDbHandler = new PhoneDbHandler(getApplicationContext());
            return phoneDbHandler.getAllRecents();
        }

        @Override
        public List<ContactModel> getAllContacts() throws RemoteException {

            PhoneDbHandler phoneDbHandler = new PhoneDbHandler(getApplicationContext());
            return phoneDbHandler.getAllContacts();
        }

        @Override
        public List<FavoriteModel> getAllFavorites() throws RemoteException {
            PhoneDbHandler phoneDbHandler = new PhoneDbHandler(getApplicationContext());
            return phoneDbHandler.getAllFavorites();
        }


        @Override
        public void deleteFavorite(int id) throws RemoteException {
            PhoneDbHandler phoneDbHandler = new PhoneDbHandler(getApplicationContext());
            phoneDbHandler.deleteFavoriteById(id);
        }

        @Override
        public void addToFavorite(ContactModel contact) throws RemoteException {
            PhoneDbHandler phoneDbHandler = new PhoneDbHandler(getApplicationContext());
            phoneDbHandler.addFavorite(new FavoriteModel(contact.getName(), contact.getNumber()));
            
        }

        @Override
        public void addToRecent(ContactModel contact) throws RemoteException {
            PhoneDbHandler phoneDbHandler = new PhoneDbHandler(getApplicationContext());
            RecentModel recentModel = new RecentModel();
            recentModel.setName(contact.getName());
            recentModel.setNumber(contact.getNumber());
            recentModel.setDate();
            phoneDbHandler.addRecent(recentModel);
        }

    };
}
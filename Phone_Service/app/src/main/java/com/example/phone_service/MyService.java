package com.example.phone_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import aidlservice.IMyAidlInterface;

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
    };
}
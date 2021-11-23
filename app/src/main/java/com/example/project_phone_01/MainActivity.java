package com.example.project_phone_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.project_phone_01.adapter.FragmentAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import aidlservice.IMyAidlInterface;
import aidlservice.RecentModel;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;
    static IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        pager2 = findViewById(R.id.viewpager2);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Phone"));
        tabLayout.addTab(tabLayout.newTab().setText("Contacts"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorites"));
        tabLayout.addTab(tabLayout.newTab().setText("Recents"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());

                try {
                    //demo: retrieving lists (string, parcelables: contact, fav, recents) from service app
                    switch (tab.getPosition()) {
                        case 0:
                            Toast.makeText(getApplicationContext(), iMyAidlInterface.getList().get(0), Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(getApplicationContext(), iMyAidlInterface.getList().get(1) + " contains: " +
                                    iMyAidlInterface.getAllContacts().size()+" items", Toast.LENGTH_SHORT).show();
                            Log.d("Trial",""+iMyAidlInterface.getAllContacts().get(1).getName());
                            ArrayList contactList = new ArrayList();
                            break;
                        case 2:
                            Toast.makeText(getApplicationContext(), iMyAidlInterface.getList().get(2) + " contains: " +
                                    iMyAidlInterface.getAllFavorites().size() +" items", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(getApplicationContext(), iMyAidlInterface.getList().get(3) + " contains: " +
                                    iMyAidlInterface.getAllRecents().size()+" items", Toast.LENGTH_SHORT).show();
                            break;
                    }

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        bindToAIDLService();

    }

    private void bindToAIDLService() {
        Intent aidlServiceintent = new Intent();
        aidlServiceintent.setClassName("com.example.phone_service", "com.example.phone_service.MyService");
        bindService(aidlServiceintent, serviceConnectionObject, BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnectionObject = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("status", "disconnected");
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    public static IMyAidlInterface getAidl(){
        return iMyAidlInterface;
    }

}
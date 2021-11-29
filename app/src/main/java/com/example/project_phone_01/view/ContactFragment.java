package com.example.project_phone_01.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project_phone_01.MainActivity;
import com.example.project_phone_01.R;
import com.example.project_phone_01.adapter.ContactAdapter;
import com.example.project_phone_01.adapter.FavoriteAdapter;

import java.util.ArrayList;
import java.util.List;

import aidlservice.ContactModel;

public class ContactFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    private ContactAdapter contactAdapter;
    private  TextView textView;


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = view.findViewById(R.id.rv_contacts);

         textView = view.findViewById(R.id.empty_view_contact);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;

        recyclerView.setLayoutManager(layoutManager);

        List<ContactModel> contactList = new ArrayList<>();

        try {
            contactList.addAll(MainActivity.getAidl().getAllContacts());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

         contactAdapter = new ContactAdapter(contactList, getContext());
        recyclerView.setAdapter(contactAdapter);

        updateVisibility();

        return view;
    }



    public void updateVisibility(){
        if (contactAdapter.getItemCount() == 0) {
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }

    }
}
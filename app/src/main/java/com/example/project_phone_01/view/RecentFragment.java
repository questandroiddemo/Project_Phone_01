package com.example.project_phone_01.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.CallLog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project_phone_01.R;
import com.example.project_phone_01.adapter.RecentAdapter;
import com.example.project_phone_01.model.RecentModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RecentFragment extends Fragment {
    private RecyclerView recyclerView;
    private View v;

    public RecentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recent, container, false);
        recyclerView = v.findViewById(R.id.rv_recents);
        TextView textView = v.findViewById(R.id.empty_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        getCallLogs();

        // dummy contacts
        List<RecentModel> listRecents = new ArrayList<>();
        RecentModel contact1 = new RecentModel("Jim", "9879898989", "Nov 18 2021");
        RecentModel contact2 = new RecentModel("Tom", "2121212121", "Nov 18 2021");
        RecentModel contact3 = new RecentModel("Jerrin", "4343434343", "Nov 18 2021");
        listRecents.add(contact1);
        listRecents.add(contact2);
        listRecents.add(contact3);

        RecentAdapter recentAdapter = new RecentAdapter(getContext(), listRecents);

        //to display empty call log message

        if (recentAdapter.getItemCount() == 0) {
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
        recyclerView.setAdapter(recentAdapter);

        return v;
    }

    private void getCallLogs() {

    }
}
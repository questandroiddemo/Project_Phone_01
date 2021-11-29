package com.example.project_phone_01.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project_phone_01.MainActivity;
import com.example.project_phone_01.R;
import com.example.project_phone_01.adapter.FavoriteAdapter;
import com.example.project_phone_01.adapter.RecentAdapter;
import com.example.project_phone_01.presenter.RecentPresenter;

import aidlservice.FavoriteModel;
import aidlservice.RecentModel;

import java.util.ArrayList;
import java.util.List;


public class RecentFragment extends Fragment implements RecentPresenter.View{
    private RecyclerView recyclerView;
    private View v;
    private RecentPresenter presenter;
    private  RecentAdapter recentAdapter;
    private  TextView textView;


    public RecentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter = new RecentPresenter(this);

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recent, container, false);
        recyclerView = v.findViewById(R.id.rv_recents);
         textView = v.findViewById(R.id.empty_view);


        presenter.recentAdapter();

        getCallLogs();

        List<RecentModel> listRecents = new ArrayList<>();
        try {
            listRecents.addAll(MainActivity.getAidl().getAllRecents());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

         recentAdapter = new RecentAdapter(getContext(), listRecents);

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


    @Override
    public void recentAdapterInView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        Log.d("TAG", "recentAdapterInView: ");
    }


    @Override
    public void onResume() {
        super.onResume();
        updateRecentList();
        //to display empty call log message
        updateVisibility();
    }


    public void updateRecentList() {
        List<RecentModel> recentList = new ArrayList<>();

        try {
            recentList.addAll(MainActivity.getAidl().getAllRecents());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        recentAdapter = new RecentAdapter(getContext(), recentList);
        recyclerView.setAdapter(recentAdapter);
    }

    public void updateVisibility(){
        if (recentAdapter.getItemCount() == 0) {
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }

    }


}
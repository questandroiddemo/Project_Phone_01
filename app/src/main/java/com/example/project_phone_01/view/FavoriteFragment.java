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
import com.example.project_phone_01.adapter.FavoriteAdapter;

import java.util.ArrayList;
import java.util.List;

import aidlservice.FavoriteModel;

public class FavoriteFragment extends Fragment {
    private static RecyclerView recyclerView;
    private View view;
    private  FavoriteAdapter favoriteAdapter;
    private  TextView textView;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = view.findViewById(R.id.rv_favorite);

         textView = view.findViewById(R.id.empty_view_favorite);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;

        recyclerView.setLayoutManager(layoutManager);

        List<FavoriteModel> favoriteList = new ArrayList<>();

        try {
            favoriteList.addAll(MainActivity.getAidl().getAllFavorites());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        favoriteAdapter = new FavoriteAdapter(favoriteList, getContext());
        recyclerView.setAdapter(favoriteAdapter);

        //to display empty call log message
        updateVisibility();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateFavoriteList();
        //to display empty call log message
        updateVisibility();
    }


    public void updateFavoriteList() {
        List<FavoriteModel> favoriteList = new ArrayList<>();

        try {
            favoriteList.addAll(MainActivity.getAidl().getAllFavorites());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

         favoriteAdapter = new FavoriteAdapter(favoriteList, getContext());
        recyclerView.setAdapter(favoriteAdapter);
    }

    public void updateVisibility(){
        if (favoriteAdapter.getItemCount() == 0) {
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }

    }
}
package com.example.project_phone_01.presenter;

public class RecentPresenter {
    private View view;

    public RecentPresenter(View view) {
        this.view = view;
    }
    public void recentAdapter(){
        view.recentAdapterInView();
    }

    public interface  View{
        void recentAdapterInView();
    }
}

package com.example.project_phone_01.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.project_phone_01.view.ContactFragment;
import com.example.project_phone_01.view.FavoriteFragment;
import com.example.project_phone_01.view.PhoneFragment;
import com.example.project_phone_01.view.RecentFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new ContactFragment();

            case 2:
                return new FavoriteFragment();
            case 3:
                return new RecentFragment();
        }
        return new PhoneFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

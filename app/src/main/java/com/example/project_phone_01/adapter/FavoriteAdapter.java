package com.example.project_phone_01.adapter;

import android.content.Context;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_phone_01.MainActivity;
import com.example.project_phone_01.R;
import com.example.project_phone_01.view.FavoriteFragment;

import java.util.List;

import aidlservice.FavoriteModel;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private List<FavoriteModel> favoriteList;
    private LayoutInflater layoutInflater;
    private Context context;
    FavoriteFragment favoriteFragment;


    public FavoriteAdapter(List<FavoriteModel> favoriteList, Context context) {
        this.favoriteList = favoriteList;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_favorite, parent, false);
        return new FavoriteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        TextView name;
        name = holder.name;

        name.setText(favoriteList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ToggleButton toggleButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.frag_favorite_name);
            toggleButton = itemView.findViewById(R.id.btn_remove_favorite);
//            itemView.setOnClickListener(this);
            toggleButton.setOnClickListener(this);
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.drawable.btn_star_big_on));


        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
            try {
                MainActivity.getAidl().deleteFavorite(favoriteList.get(position).getId());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            favoriteList.remove(position);

            notifyItemRemoved(position);
        }

    }

}

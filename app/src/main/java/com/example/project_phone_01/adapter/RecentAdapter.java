package com.example.project_phone_01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_phone_01.R;

import aidlservice.RecentModel;

import java.util.List;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context mContext;

    private List<RecentModel> mlistRecents;

    public RecentAdapter(Context context, List<RecentModel> listRecents) {
        mContext = context;
        mlistRecents = listRecents;

    }

    @NonNull
    @Override
    public RecentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.item_recent, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView name, number, date;
        name = holder.name;
        number = holder.number;
        date = holder.date;

        name.setText(mlistRecents.get(position).getName());
//        number.setText(mlistRecents.get(position).getNumber());
        date.setText(mlistRecents.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return mlistRecents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, number, date;
        Button callRecent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);

            name = itemView.findViewById(R.id.contact_name);
//            number = itemView.findViewById(R.id.call_number);
            date = itemView.findViewById(R.id.call_date);
            callRecent = itemView.findViewById(R.id.btn_callRecent);
            callRecent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
            RecentModel recent = mlistRecents.get(position);
            String name = recent.getName();
            String date = recent.getDate();
            String number = recent.getNumber();

            //TODO to be replaced by 'redirect to primary call app'.
            Toast.makeText(mContext, position + ") " +
                    " Name: " + name + ", Number: " + number, Toast.LENGTH_SHORT).show();

        }


    }
}

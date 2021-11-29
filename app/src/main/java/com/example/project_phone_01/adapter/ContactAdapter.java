package com.example.project_phone_01.adapter;

import android.content.Context;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_phone_01.MainActivity;
import com.example.project_phone_01.R;

import java.util.List;

import aidlservice.ContactModel;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<ContactModel> contactList;
    private LayoutInflater layoutInflater;
    private Context context;

    public ContactAdapter(List<ContactModel> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView name;
        ToggleButton toggleButton;

        name = holder.name;
        toggleButton = holder.toggleButton;

        name.setText(contactList.get(position).getName());
        toggleButton.setChecked(isFavorite());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ToggleButton toggleButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.frag_contact_name);
            toggleButton = itemView.findViewById(R.id.btn_addOrRemove_favorite);
            itemView.setOnClickListener(this);

//            toggleButton.setChecked(false);
//             toggleButton.setChecked(isFavorite());


            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.drawable.btn_star));
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.drawable.btn_star_big_on));

                        try {
                            MainActivity.getAidl().addToFavorite(contactList.get(getAdapterPosition()));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    } else {
                        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.drawable.btn_star_big_off));

                    }
                }
            });

        }

        @Override
        public void onClick(View v) {

            int position = this.getAdapterPosition();
            try {
                MainActivity.getAidl().placeCall(contactList.get(position).getNumber());
                MainActivity.getAidl().addToRecent(contactList.get(position));

            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

    }

    private boolean isFavorite() {
        //TODO read favorite status of the contact

        return false;
    }

}

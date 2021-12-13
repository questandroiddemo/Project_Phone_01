package com.example.project_phone_01.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.project_phone_01.MainActivity;
import com.example.project_phone_01.R;


public class PhoneFragment extends Fragment {
    private EditText edtPhoneNo;
    private View x;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnCall;
    private ImageButton btndel;

    public PhoneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        x = inflater.inflate(R.layout.fragment_phone, container, false);
        edtPhoneNo = x.findViewById(R.id.edtPhoneNumber);
        btnZero = x.findViewById(R.id.btnZero);
        btnOne = x.findViewById(R.id.btnOne);
        btnTwo = x.findViewById(R.id.btnTwo);
        btnThree = x.findViewById(R.id.btnThree);
        btnFour = x.findViewById(R.id.btnFour);
        btnFive = x.findViewById(R.id.btnFive);
        btnSix = x.findViewById(R.id.btnSix);
        btnSeven = x.findViewById(R.id.btnSeven);
        btnEight = x.findViewById(R.id.btnEight);
        btnNine = x.findViewById(R.id.btnNine);
        btndel = x.findViewById(R.id.btndel);
        btnCall = x.findViewById(R.id.btnCall);

        btnZero.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "0"));
        btnOne.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "1"));
        btnTwo.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "2"));
        btnThree.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "3"));
        btnFour.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "4"));
        btnFive.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "5"));
        btnSix.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "6"));
        btnSeven.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "7"));
        btnEight.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "8"));
        btnNine.setOnClickListener(v -> edtPhoneNo.setText(edtPhoneNo.getText() + "9"));
        btndel.setOnClickListener(v -> {
            String str=edtPhoneNo.getText().toString();
            if(str.length()>=1){
                str=str.substring(0,str.length()-1);
                edtPhoneNo.setText(str);
            }else if (str.length()<1){
                edtPhoneNo.setText("");
            }
        });

        btnCall.setOnClickListener(v -> {

            if (edtPhoneNo.getText().length() < 10 || edtPhoneNo.getText().length() > 10 ) {
                Toast.makeText(getContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    String number= edtPhoneNo.getText().toString();
                    MainActivity.getAidl().placeCall("tel:" + number);
                    //MainActivity.getAidl().addNumberToRecent(number);

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

        });
        permissionCallPhone();
        return x;
    }

    private void permissionCallPhone() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }
}
















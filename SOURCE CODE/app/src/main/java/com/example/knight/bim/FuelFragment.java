package com.example.knight.bim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by KNIGHT on 10/29/2017.
 */

public class FuelFragment extends Fragment {

    EditText etFirstName,etLastName,etFavFood;
    Button btnAdd;
    DatabaseHelper myDB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fuel,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etFavFood = (EditText) view.findViewById(R.id.etFavFood);
        etFirstName = (EditText) view.findViewById(R.id.etFirstName);
        etLastName = (EditText) view.findViewById(R.id.etLastName);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        myDB = new DatabaseHelper(getActivity());



        view.findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = etFirstName.getText().toString();
                String lName = etLastName.getText().toString();
                String fFood = etFavFood.getText().toString();
                if(fName.length() != 0 && lName.length() != 0 && fFood.length() != 0){
                    AddData(fName,lName, fFood);
                    etFavFood.setText("");
                    etLastName.setText("");
                    etFirstName.setText("");
                }else{
                    Toast.makeText(getActivity(),"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void AddData(String firstName,String lastName, String favFood ){
        boolean insertData = myDB.addData(firstName,lastName,favFood);

        if(insertData==true){
            Toast.makeText(getActivity(),"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(),"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}

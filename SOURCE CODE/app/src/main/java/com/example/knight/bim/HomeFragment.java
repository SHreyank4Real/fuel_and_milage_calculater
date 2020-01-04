package com.example.knight.bim;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KNIGHT on 10/29/2017.
 */

public class HomeFragment extends android.support.v4.app.Fragment {

    EditText e1,e2,e3;
    TextView e4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        e1= (EditText) view.findViewById(R.id.editText);
        e2= (EditText) view.findViewById(R.id.editText2);
        e3= (EditText) view.findViewById(R.id.editText3);
        e4 = (TextView) view.findViewById(R.id.textView9);


       view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long a = Integer.parseInt(String.valueOf(e1.getText()));
                long b = Integer.parseInt(String.valueOf(e2.getText()));
                long c = Integer.parseInt(String.valueOf(e3.getText()));
                if(e1.getText().equals("") && e2.getText().equals("") && e3.getText().equals("")){
                    Toast.makeText(getActivity(),"You must put something in the text field!",Toast.LENGTH_LONG).show();

                }else{
                    long d = b / c;
                    long mon = d * a;
                    e4.setText("You Need " + mon + " Rs");
                }
            }
        });

    }
}

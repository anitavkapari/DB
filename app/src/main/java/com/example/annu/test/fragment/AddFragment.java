package com.example.annu.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.annu.test.DB.DBHolder;
import com.example.annu.test.DB.Student;
import com.example.annu.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    Button btnSave;
    EditText edtName,edtAddress,edtPhone;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        btnSave=view.findViewById( R.id.btnSave );
        edtName=view.findViewById( R.id.edtName );
        edtAddress=view.findViewById( R.id.edtAddress);
        edtPhone=view.findViewById( R.id.edtPhone);
        btnSave.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                String name =edtName.getText().toString().trim();
                String address =edtAddress.getText().toString().trim();
                String phone =edtPhone.getText().toString().trim();
                Student student=new Student( name,address,phone );
                DBHolder dBholder=new DBHolder( getActivity() );
                boolean isAddes= dBholder.addStudent( student );
                if(isAddes){
                    Toast.makeText( getActivity(),"Recod Added",Toast.LENGTH_SHORT ).show();

                }
            }
        } );
        return view;

    }
}


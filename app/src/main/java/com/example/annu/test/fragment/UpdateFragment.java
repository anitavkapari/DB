package com.example.annu.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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
public class UpdateFragment extends Fragment {
    EditText edtName,edtAddress,edtPhone;
    Button btnSearch,btnUpdate;
    int id = -1;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_update, container, false );

        // Inflate the layout for this fragment

        btnSearch = view.findViewById( R.id.btnSearch );
        btnUpdate = view.findViewById( R.id.btnUpdate );
        edtName = view.findViewById( R.id.edtName );
        edtAddress = view.findViewById( R.id.edtAddress );
        edtPhone = view.findViewById( R.id.edtPhone );
        btnSearch.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                String name = edtName.getText( ).toString( ).trim( );
                if (TextUtils.isEmpty( name )) {
                    Toast.makeText( getActivity( ), "please enter name to search ", Toast.LENGTH_SHORT ).show( );
                    return;
                }
                DBHolder dbHolder = new DBHolder( getActivity( ) );
                Student student = dbHolder.getStudent( name );
                if (student==null) {
                    Toast.makeText( getActivity(),"Student not found", Toast.LENGTH_SHORT ).show();
                }
                else {
                    edtAddress.setText( student.getAddress() );
                    edtPhone.setText( student.getPhone() );
                    id=student.getId();
                    //spCourse.( employee.getCourse() );


                }
            }
        } );
        btnUpdate.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {

                String name =edtName.getText().toString().trim();
                String address =edtAddress.getText().toString().trim();
                String phone =edtPhone.getText().toString().trim();


                if (TextUtils.isEmpty( name )|| TextUtils.isEmpty( address )|| TextUtils.isEmpty( phone )){
                    Toast.makeText( getActivity(),"Enter all entities",Toast.LENGTH_SHORT ).show();
                    return;
                }

                Student student=new Student( name,address,phone);
                DBHolder dbHolder=new DBHolder( getActivity() );
                boolean isUpdate= dbHolder.updateStudent( student  , id );
                if(isUpdate){
                    Toast.makeText( getActivity(),"Record Updated",Toast.LENGTH_SHORT ).show();

                }
            }
        } );
        return view;
        // Inflate the layout for this fragment
    }

}


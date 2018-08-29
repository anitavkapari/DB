package com.example.annu.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annu.test.DB.DBHolder;
import com.example.annu.test.DB.Student;
import com.example.annu.test.R;
import com.example.annu.test.adapter.StudentListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    RecyclerView rvStudent;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        rvStudent=view.findViewById( R.id.rvStudent );
        rvStudent.setLayoutManager( new LinearLayoutManager( getActivity() ) );//
        DBHolder dbholder=new DBHolder( getActivity() );//
        List<Student> students=dbholder.getAllStudent();//
        StudentListAdapter adapter=new StudentListAdapter(students ,dbholder );
        rvStudent.setAdapter( adapter );
        // Inflate the layout for this fragment
        return view;    }

}

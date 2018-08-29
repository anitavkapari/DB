package com.example.annu.test.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annu.test.DB.DBHolder;
import com.example.annu.test.DB.Student;
import com.example.annu.test.R;

import java.util.List;

public class StudentListAdapter  extends RecyclerView.Adapter<StudentViewHolder>{
    List<Student> students;
    DBHolder dbholder;
    public  StudentListAdapter(List<Student> students, DBHolder dbholder) { //constructor
        this.students = students;
        this.dbholder = dbholder;

    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.stud_list,viewGroup,false  );
        return new StudentViewHolder( view );    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        final Student student=students.get( i );
        studentViewHolder .txtName.setText( "Name :"+ student.getName() );
        studentViewHolder .txtAddress.setText( "Address :"+ student.getAddress() );
        studentViewHolder .txtPhone.setText( "Phone :"+ student.getPhone() );
        studentViewHolder.btnDelete.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                boolean isDelete = dbholder.deleateStudent( student.getId() );
                if (isDelete){
                    students.remove( student );
                    notifyDataSetChanged();
                }
            }
        } );
    }

    @Override
    public int getItemCount() {
            return students.size();
        }

    }


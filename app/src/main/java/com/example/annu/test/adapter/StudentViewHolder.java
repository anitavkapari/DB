package com.example.annu.test.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.annu.test.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView txtName,txtPhone,txtAddress;
    ImageButton btnDelete;


    public StudentViewHolder(@NonNull View itemView) {
        super( itemView );
        txtName=itemView.findViewById(R.id.txtName );
        txtAddress=itemView.findViewById( R.id.txtAddress );
        txtPhone=itemView.findViewById(R.id.txtPhone );
        btnDelete=itemView.findViewById( R.id.btnDelete );

    }
}

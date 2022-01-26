package com.supriya.roomdbwithimageanddate;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name, uname, dob;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.cardFullName);
        uname = itemView.findViewById(R.id.cardUserName);
        dob = itemView.findViewById(R.id.cardDOB);
        imageView = itemView.findViewById(R.id.cardImg);
    }
}

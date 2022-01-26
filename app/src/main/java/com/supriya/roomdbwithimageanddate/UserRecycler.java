package com.supriya.roomdbwithimageanddate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supriya.roomdbwithimageanddate.DataModel.DataConverter;
import com.supriya.roomdbwithimageanddate.DataModel.User;

import java.util.List;

public class UserRecycler extends RecyclerView.Adapter<UserViewHolder> {

    List<User> data;

    public UserRecycler(List<User> users){
        data = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_layout,
                parent,false
        );
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.name.setText(user.getFullName());
        holder.uname.setText(user.getUserName());
        holder.dob.setText(String.valueOf(user.getDob()));
        holder.imageView.setImageBitmap(DataConverter.convertByteArrayToImage(user.getImage()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

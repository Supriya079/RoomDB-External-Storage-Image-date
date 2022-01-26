package com.supriya.roomdbwithimageanddate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supriya.roomdbwithimageanddate.DataModel.DataConverter;
import com.supriya.roomdbwithimageanddate.DataModel.User;
import com.supriya.roomdbwithimageanddate.billRoom.Bill;

import java.util.List;

public class BillRecycler extends RecyclerView.Adapter<BillViewHolder> {

    List<Bill> data;

    public BillRecycler(List<Bill> bills){
        data = bills;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_layout_bill,
                parent,false
        );
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {
        Bill bill = data.get(position);
        holder.category.setText(bill.getCategory());
        holder.obj_name.setText(bill.getObject_name());
        holder.description.setText(bill.getDescription());
        holder.location.setText(bill.getLocation());
        holder.dob.setText(String.valueOf(bill.getDate()));
//        Bitmap bmImg = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/Forget/Image-7759.jpg");
        Bitmap bmImg = BitmapFactory.decodeFile(bill.getImagePath());
        holder.imageViewBill.setImageBitmap(bmImg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

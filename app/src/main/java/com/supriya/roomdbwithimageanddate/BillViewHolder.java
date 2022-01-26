package com.supriya.roomdbwithimageanddate;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BillViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewBill;
    TextView category, obj_name, description,location,dob;

    public BillViewHolder(@NonNull View itemView) {
        super(itemView);
        category = itemView.findViewById(R.id.cardcategory);
        obj_name = itemView.findViewById(R.id.cardobjname);
        description = itemView.findViewById(R.id.carddescription);
        location = itemView.findViewById(R.id.cardlocation);
        dob = itemView.findViewById(R.id.cardBillDOB);
        imageViewBill = itemView.findViewById(R.id.cardImgBill);
    }
}

package com.supriya.roomdbwithimageanddate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.supriya.roomdbwithimageanddate.DataModel.UserDAO;
import com.supriya.roomdbwithimageanddate.DataModel.UserDB;
import com.supriya.roomdbwithimageanddate.billRoom.BillDAO;
import com.supriya.roomdbwithimageanddate.billRoom.BillDB;

public class ShowBillsActivity extends AppCompatActivity {

    RecyclerView recyclerViewBill;
    BillDAO billDAO;
    ImageView empty_imageview;
    TextView no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bills);

        recyclerViewBill = findViewById(R.id.billRecyclerView);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        billDAO = BillDB.getDBInstance(this).billDao();
        BillRecycler billRecycler = new BillRecycler(billDAO.getAllBills());
//        recyclerViewBill.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewBill.setAdapter(billRecycler);

        if (billRecycler.getItemCount() != 0 ){
            recyclerViewBill.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewBill.setAdapter(billRecycler);
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }else {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }

    }
}
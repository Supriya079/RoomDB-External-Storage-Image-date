package com.supriya.roomdbwithimageanddate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.supriya.roomdbwithimageanddate.DataModel.UserDAO;
import com.supriya.roomdbwithimageanddate.DataModel.UserDB;

public class ShowUsersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);
        recyclerView = findViewById(R.id.userRecyclerView);

        userDAO = UserDB.getDBInstance(this).userDao();
        UserRecycler userRecycler = new UserRecycler(userDAO.getAllUsers());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userRecycler);

    }
}
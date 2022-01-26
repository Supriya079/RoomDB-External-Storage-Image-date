package com.supriya.roomdbwithimageanddate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.supriya.roomdbwithimageanddate.DataModel.DataConverter;
import com.supriya.roomdbwithimageanddate.DataModel.User;
import com.supriya.roomdbwithimageanddate.DataModel.UserDAO;
import com.supriya.roomdbwithimageanddate.DataModel.UserDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap bmpImage;
    EditText name,uname,pass,dob;

    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.userImage);
        bmpImage = null;
        name = findViewById(R.id.fullName);
        uname = findViewById(R.id.userName);
        pass = findViewById(R.id.userPassword);
        dob = findViewById(R.id.userDob);

        userDAO = UserDB.getDBInstance(this).userDao();
    }

    final int CAMERA_INTENT = 97;

    public void takePicture(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!= null){
            //check permission for camera
            startActivityForResult(intent,CAMERA_INTENT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA_INTENT:
                if (resultCode == Activity.RESULT_OK){
                    bmpImage = (Bitmap) data.getExtras().get("data");
                    if (bmpImage != null){
                        imageView.setImageBitmap(bmpImage);
                    }
                }
                break;
        }
    }

    public void saveUsers(View view) {
        if (name.getText().toString().isEmpty() || uname.getText().toString().isEmpty()
                || pass.getText().toString().isEmpty() || dob.getText().toString().isEmpty()
                || bmpImage == null){
            Toast.makeText(this,"User data is missing",Toast.LENGTH_SHORT).show();
        }else {
            User user = new User();
            user.setFullName(name.getText().toString());
            user.setUserName(uname.getText().toString());
            user.setPassword(pass.getText().toString());
            user.setImage(DataConverter.convertImageToByteArray(bmpImage));
            try {
                user.setDob(new SimpleDateFormat("dd/mm/yyyy").parse(dob.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            userDAO.insertUser(user);
        }
    }

    public void showUsers(View view) {
        Intent intent = new Intent(this,ShowUsersActivity.class);
        startActivity(intent);
    }
}
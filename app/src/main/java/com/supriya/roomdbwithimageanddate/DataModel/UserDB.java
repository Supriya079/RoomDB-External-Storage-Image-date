package com.supriya.roomdbwithimageanddate.DataModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = User.class,version = 1,exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class UserDB extends RoomDatabase {

    private static UserDB userDB = null;

    //access DAO methods
    public abstract UserDAO userDao();

    public static synchronized UserDB getDBInstance(Context context){
        if (userDB == null){
            userDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDB.class,
                    "userDemo")
                    .allowMainThreadQueries()//allow DAO queries
                    .build();
        }
        return userDB;
    }

}

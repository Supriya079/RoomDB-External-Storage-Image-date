package com.supriya.roomdbwithimageanddate.billRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.supriya.roomdbwithimageanddate.DataModel.DataConverter;

@Database(entities = Bill.class,version = 1,exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class BillDB extends RoomDatabase {

    private static BillDB billDB = null;

    //access DAO methods
    public abstract BillDAO billDao();

    public static synchronized BillDB getDBInstance(Context context){
        if (billDB == null){
            billDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BillDB.class,
                    "billDemo")
                    .allowMainThreadQueries()//allow DAO queries
                    .build();
        }
        return billDB;
    }

}

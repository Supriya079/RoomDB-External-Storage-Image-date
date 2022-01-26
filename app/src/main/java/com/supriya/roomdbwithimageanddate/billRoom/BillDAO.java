package com.supriya.roomdbwithimageanddate.billRoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BillDAO {

    @Query("SELECT * FROM Bill")
    List<Bill> getAllBills();

    @Insert
    void insertBill(Bill bill);

    @Update
    void updateBill(Bill bill);

    @Delete
    void deleteBill(Bill bill);

}

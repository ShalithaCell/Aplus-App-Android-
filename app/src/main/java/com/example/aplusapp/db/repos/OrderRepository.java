package com.example.aplusapp.db.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.aplusapp.db.GeneralRoomDatabase;
import com.example.aplusapp.db.dao.OrderDao;
import com.example.aplusapp.model.Order;

import java.util.List;

public class OrderRepository {

    private OrderDao orderDao;


    public OrderRepository(Application application){

        GeneralRoomDatabase db = GeneralRoomDatabase.getDatabase(application);
        orderDao = db.orderDao();
    }

    public void insertOrder(Order order){

        GeneralRoomDatabase.databaseWriteExecutor.execute(() -> {orderDao.insertOrder(order);});

    }

    public void removeOrder(int id){

        GeneralRoomDatabase.databaseWriteExecutor.execute(() -> {orderDao.removeByID(id);});
    }

    public void updateOrder(Order order){

        GeneralRoomDatabase.databaseWriteExecutor.execute(() -> {orderDao.updateOrder(order);});
    }
}

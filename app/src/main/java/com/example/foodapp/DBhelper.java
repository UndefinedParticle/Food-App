package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.foodapp.Models.OrderShowModel;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    final static String DBName="myDataBase.db";
    final static int DBVersion=2;
    public DBhelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table Orders"+
                        "(id integer primary key autoincrement,"+
                        "name text,"+
                        "phone text,"+
                        "image int,"+
                        "foodName text,"+
                        "price int,"+
                        "quantity int,"+
                        "description text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Orders");
        onCreate(sqLiteDatabase);
    }
    public boolean insertOrder(String name,String phone,int image,String foodName,int price,int quantity,String description){
        SQLiteDatabase dataBase=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("foodName",foodName);
        values.put("price",price);
        values.put("quantity",quantity);
        values.put("description",description);
        long id=dataBase.insert("Orders",null,values);
        if(id<=0)
            return false;
        else
            return true;
    }
    public ArrayList<OrderShowModel> getOrders(){
        ArrayList<OrderShowModel> orders=new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select id,image,foodName,price,quantity from Orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderShowModel model=new OrderShowModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setOrderedImage((cursor.getInt(1)));
                model.setOrderedFood(cursor.getString(2));
                model.setOrderedPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        return orders;
    }
}

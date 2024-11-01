package com.doanchung.assignmentand102.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.doanchung.assignmentand102.database.DbHelper;
import com.doanchung.assignmentand102.models.Product;

import java.util.ArrayList;

public class ProductDAO {
    private DbHelper dbHelper;

    public ProductDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //lấy danh sách sản phẩm
    public ArrayList<Product> getAllProduct() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PRODUCT", null);
        ArrayList<Product> productList = new ArrayList<>();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                productList.add(new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        return productList;
    }

    //thêm sản phẩm
    public boolean insertProduct(Product product) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("productName", product.getProductName());
        contentValues.put("productPrice", product.getProductPrice());
        contentValues.put("productNumber", product.getProductNumber());
        //trả về -1 nếu thất bại (theo document)
        long resultCheck = sqLiteDatabase.insert("PRODUCT", null, contentValues);
        if (resultCheck == -1) {
            return false;
        }
        return true;
        //return resultCheck != -1;
    }

    //lấy sản phẩm theo id
    public boolean editProduct(Product product) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("productName", product.getProductName());
        contentValues.put("productPrice", product.getProductPrice());
        contentValues.put("productNumber", product.getProductNumber());
        //tên table, giá trị cập nhật, điều kiện cập nhật, giá trị điều kiện cần
        int check = sqLiteDatabase.update("PRODUCT", contentValues, "id = ?", new String[]{String.valueOf(product.getId())});
        if(check <= 0) return false;
        return true;
    }




}

package com.example.ayurvedahouseassesment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem


@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract val shoppingDao: ShoppingDao

}
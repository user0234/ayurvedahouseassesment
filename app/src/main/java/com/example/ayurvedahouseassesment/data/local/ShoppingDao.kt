package com.example.ayurvedahouseassesment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cartItem: ShoppingItem): Long

    @Query("Select * From shopping_table")
    fun getCartItemList(): LiveData<List<ShoppingItem>>

    @Query("Select * From shopping_table where cartCount > 0")
    fun getItemInCart(): LiveData<List<ShoppingItem>>

    @Update
    suspend fun update(cartItem: ShoppingItem)

    @Delete
    suspend fun delete(cartItem: ShoppingItem)

    @Query("Select COUNT(*) From shopping_table where cartCount > 0")
    fun getCartItemCount(): LiveData<Int>

    @Query("Select * From shopping_table where id=:id LIMIT 1")
    fun getItemUsingId(id: String): LiveData<ShoppingItem>

}